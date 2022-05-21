package site.fsyj.timeaxis.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import site.fsyj.timeaxis.mapper.GroupMemberMapper;
import site.fsyj.timeaxis.entity.GroupMember;
import site.fsyj.timeaxis.service.GroupMemberService;
@Service
public class GroupMemberServiceImpl implements GroupMemberService{

    @Resource
    private GroupMemberMapper groupMemberMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return groupMemberMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(GroupMember record) {
        return groupMemberMapper.insert(record);
    }

    @Override
    public int insertSelective(GroupMember record) {
        return groupMemberMapper.insertSelective(record);
    }

    @Override
    public GroupMember selectByPrimaryKey(Integer id) {
        return groupMemberMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(GroupMember record) {
        return groupMemberMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(GroupMember record) {
        return groupMemberMapper.updateByPrimaryKey(record);
    }

}
