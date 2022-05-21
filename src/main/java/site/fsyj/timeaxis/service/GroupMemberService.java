package site.fsyj.timeaxis.service;

import site.fsyj.timeaxis.entity.GroupMember;
public interface GroupMemberService{


    int deleteByPrimaryKey(Integer id);

    int insert(GroupMember record);

    int insertSelective(GroupMember record);

    GroupMember selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GroupMember record);

    int updateByPrimaryKey(GroupMember record);

}
