package site.fsyj.timeaxis.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import site.fsyj.timeaxis.entity.LoginUser;
import site.fsyj.timeaxis.entity.User;
import site.fsyj.timeaxis.mapper.UserMapper;

import javax.annotation.Resource;
import java.util.Objects;

@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    private RuntimeException loginException = new RuntimeException("用户名或密码错误");

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!StringUtils.hasLength(username)) {
            throw loginException;
        }
        //根据用户名查询用户信息
        User user = userMapper.selectByEmail(username);
        if (Objects.isNull(user)) {
            throw loginException;
        }
        //封装成UserDetails对象返回
        return new LoginUser(user);
    }
}
