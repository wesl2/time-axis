package site.fsyj.timeaxis.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.fsyj.timeaxis.entity.Group;
import site.fsyj.timeaxis.entity.GroupMember;
import site.fsyj.timeaxis.entity.User;
import site.fsyj.timeaxis.mapper.GroupMapper;
import site.fsyj.timeaxis.mapper.GroupMemberMapper;
import site.fsyj.timeaxis.mapper.UserMapper;
import site.fsyj.timeaxis.service.GroupService;

import javax.annotation.Resource;
import java.util.Objects;

@Service
public class GroupServiceImpl implements GroupService {

    @Resource
    private GroupMapper groupMapper;

    @Resource
    private UserMapper userMapper;
    @Resource
    private GroupMemberMapper groupMemberMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return groupMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Group record) {
        return groupMapper.insert(record);
    }

    @Override
    public int insertSelective(Group record) {
        return groupMapper.insertSelective(record);
    }

    @Override
    public Group selectByPrimaryKey(Integer id) {
        return groupMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Group record) {
        return groupMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Group record) {
        return groupMapper.updateByPrimaryKey(record);
    }

    @Override
    public void join(String userId, String groupname) {
        // 验证组名是否有效
        Integer groupId = groupMapper.selectByName(groupname);
        if (groupId == null) {
            throw new RuntimeException("该群不存在");
        }
        GroupMember member = new GroupMember();
        member.setMenberId(Integer.valueOf(userId));
        member.setGroupId(groupId);
        member.setType("1");
        groupMemberMapper.insert(member);
    }

    @Transactional
    @Override
    public boolean createGroup(String userid, String groupName) {
        // 校验用户ID的有效性
        User user = userMapper.selectByPrimaryKey(Integer.valueOf(userid));
        if (Objects.isNull(user)) {
            throw new IllegalArgumentException("用户ID无效");
        }
        // 校验群名称的可用性
        if (!Objects.isNull(groupMapper.selectByName(groupName))) {
            throw new IllegalArgumentException("群名称已被使用");
        }
        Group group = new Group();
        group.setCreator(user.getId());
        group.setName(groupName);
        insert(group);
        // 查询获取GroupName
        Integer groupId = groupMapper.selectByName(groupName);
        Group newGroup = selectByPrimaryKey(groupId);
        // 添加到群成员
        GroupMember groupMember = new GroupMember();
        groupMember.setGroupId(newGroup.getId());
        groupMember.setMenberId(user.getId());
        groupMember.setType("0");
        groupMemberMapper.insert(groupMember);
        return true;
    }

}


