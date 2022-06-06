package site.fsyj.timeaxis.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.fsyj.timeaxis.util.EmailRandomUtil;
import site.fsyj.timeaxis.util.RedisCache;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.util.concurrent.TimeUnit;

/**
 * 发送邮件获取验证码
 * @author fsyj
 */
@Api("邮箱验证")
@RestController
@Slf4j
@RequestMapping("/user")
public class GetEmailCodeController {

    @Resource
    RedisCache redisCache;

    /**
     * 注入发送邮件的bean
     */
    @Resource(type = JavaMailSender.class)
    JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String emailUserName;

    //定义发送的标题
    public static String title = "获取验证码";


    /**
     * @param email
     * @description: 发送给指定邮箱验证码
     * @return: java.lang.String
     * @author: liuchuanfeng
     * @time: 2020/12/8 16:23
     */
    @GetMapping(value = "/getCode/{email}")
    public ResponseEntity<String> getEmail(@PathVariable String email) {
        try {
            // 设置邮件格式
            String body = setEmailBody(email);
            // 创建邮件对象
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage);

            //设置发件邮箱
            message.setFrom(emailUserName);
            //设置收件人
            message.setTo(email);
            //设置标题
            message.setSubject(title);
            //第二个参数true表示使用HTML语言来编写邮件
            message.setText(body);
            log.info("getEmail send email message: [{}]", message);
            // 发邮件
            mailSender.send(mimeMessage);
        } catch (Exception e) {
            log.error("[{}] send email message exception", email, e);
            throw new RuntimeException("邮箱有误");
        }
        return ResponseEntity.ok("验证码发送成功");
    }

    private String setEmailBody(String email) {
        //获取邮箱随机验证码
        String emailCode = EmailRandomUtil.randomNumBuilder();
        //在redis中保存邮箱验证码并设置过期时间
        redisCache.setCacheObject(email, emailCode, 300, TimeUnit.SECONDS);
        return "客官您来啦,里面请!\n\n" + "    您的验证码为:  " + emailCode + "\n\n" +
                "    客官请注意:需要您在收到邮件后5分钟内使用，否则该验证码将会失效。\n\n";
    }
}
