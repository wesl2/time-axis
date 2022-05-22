package site.fsyj.timeaxis.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    private UserService userServiceImpl;

    @Autowired
    private RedisCache redisCache;

    @ApiOperation("登录")
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody String email, @RequestBody String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user = userServiceImpl.login(user);
        user.setPassword("");
        HashMap<String, Object> resp = new HashMap<>(2);
        resp.put("token", JwtUtil.createJWT(String.valueOf(user.getId())));
        resp.put("user", user);
        return ResponseEntity.ok(resp);
    }

    @ApiOperation("注册，需要先申请邮箱验证码")
    @PostMapping("/registry")
    public ResponseEntity<String> registry(@RequestBody String email, @RequestBody String password, @RequestBody String name,
                                           @RequestBody String no, @RequestBody String major,
                                           @ApiParam("m：男， f：女") @RequestBody String sex, @RequestBody String emailCode) {
        String code = redisCache.getCacheObject(email);
        if (code != null && code.equals(emailCode)) {
            // 验证码通过验证
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            user.setName(name);
            user.setNo(no);
            user.setMajor(major);
            user.setSex(sex);
            userServiceImpl.insert(user);
            return ResponseEntity.ok("注册成功");
        } else {
            return ResponseEntity.badRequest().body("请输入正确的验证码或验证码已超时");
        }
    }
}
