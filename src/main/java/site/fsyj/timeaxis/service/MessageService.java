package site.fsyj.timeaxis.service;

import site.fsyj.timeaxis.entity.Message;
public interface MessageService{


    int deleteByPrimaryKey(Integer id);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);

}
