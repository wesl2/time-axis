package site.fsyj.timeaxis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import site.fsyj.timeaxis.entity.LoginUser;
import site.fsyj.timeaxis.entity.User;
import site.fsyj.timeaxis.mapper.UserMapper;
import site.fsyj.timeaxis.service.UserService;
import site.fsyj.timeaxis.util.RedisCache;

import javax.annotation.Resource;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    @Autowired
    private RedisCache redisCache;

    @Resource
    private AuthenticationManager authenticationManager;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public User login(User user) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authentication);
        // 登录认证失败
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("登录失败，请检查用户名和密码");
        }
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        user = loginUser.getUser();
        redisCache.setCacheObject(String.valueOf(user.getId()), user);
        return selectByPrimaryKey(user.getId());
    }

}
