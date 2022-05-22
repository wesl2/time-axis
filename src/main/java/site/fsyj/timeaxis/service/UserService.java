package site.fsyj.timeaxis.service;

import site.fsyj.timeaxis.entity.User;
public interface UserService{


    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 登录接口，放回登录结果的封装
     * @param user
     * @return
     */
    User login(User user);
}
