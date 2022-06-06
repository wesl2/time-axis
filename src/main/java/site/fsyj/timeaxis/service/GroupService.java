package site.fsyj.timeaxis.service;

import site.fsyj.timeaxis.entity.Group;
public interface GroupService{


    int deleteByPrimaryKey(Integer id);

    int insert(Group record);

    int insertSelective(Group record);

    Group selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Group record);

    int updateByPrimaryKey(Group record);

}
