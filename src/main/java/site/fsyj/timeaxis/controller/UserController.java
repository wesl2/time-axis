package site.fsyj.timeaxis.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.fsyj.timeaxis.dto.LoginDto;
import site.fsyj.timeaxis.dto.RegisterUser;
import site.fsyj.timeaxis.entity.User;
import site.fsyj.timeaxis.service.UserService;
import site.fsyj.timeaxis.util.JwtUtil;
import site.fsyj.timeaxis.util.RedisCache;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fsyj on 2022/5/22
 */
@Slf4j
@Api("用户相关模块")
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    PasswordEncoder passwordEncoder;

    @Resource
    private UserService userServiceImpl;

    @Autowired
    private RedisCache redisCache;

    @ApiOperation("登录")
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginDto loginUser) {
        User user = new User();
        user.setEmail(loginUser.getEmail());
        user.setPassword(loginUser.getPassword());
        user = userServiceImpl.login(user);
        user.setPassword("");
        HashMap<String, Object> resp = new HashMap<>(2);
        resp.put("token", JwtUtil.createJWT(String.valueOf(user.getId())));
        resp.put("user", user);
        return ResponseEntity.ok(resp);
    }

    @ApiOperation("注册，需要先申请邮箱验证码")
    @PostMapping("/registry")
    public ResponseEntity<String> registry(@RequestBody RegisterUser registerUser) {
        String code = redisCache.getCacheObject(registerUser.getEmail());
        if (code != null && code.equals(registerUser.getEmailCode())) {
            // 验证码通过验证，移除redis中的验证码
            redisCache.deleteObject(registerUser.getEmail());
            User user = new User();
            user.setEmail(registerUser.getEmail());
            user.setPassword(passwordEncoder.encode(registerUser.getPassword()));
            user.setName(registerUser.getName());
            user.setNo(registerUser.getNo());
            user.setMajor(registerUser.getMajor());
            user.setSex(registerUser.getSex());
            user.setEnable(true);
            userServiceImpl.insert(user);
            return ResponseEntity.ok("注册成功");
        } else {
            return ResponseEntity.badRequest().body("请输入正确的验证码或验证码已超时");
        }
    }
}
