package site.fsyj.timeaxis.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.fsyj.timeaxis.dto.EventDto;
import site.fsyj.timeaxis.entity.Event;
import site.fsyj.timeaxis.entity.Group;
import site.fsyj.timeaxis.entity.User;
import site.fsyj.timeaxis.mapper.EventMapper;
import site.fsyj.timeaxis.mapper.GroupMapper;
import site.fsyj.timeaxis.mapper.GroupMemberMapper;
import site.fsyj.timeaxis.mapper.UserMapper;
import site.fsyj.timeaxis.service.EventService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Service
public class EventServiceImpl implements EventService {

    @Resource
    private EventMapper eventMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private GroupMapper groupMapper;

    @Resource
    private GroupMemberMapper groupMemberMapper;

    @Override
    public int deleteByPrimaryKey(Integer id, String userid) {
        List<Event> events = selectAll(userid);
        for (Event event : events) {
            if (event.getId().equals(id)) {
                return eventMapper.deleteByPrimaryKey(id);

            }
        }
        throw new RuntimeException("该用户无权删除事件");
    }

    @Override
    public int insert(Event record) {
        return eventMapper.insert(record);
    }

    @Override
    public int insertSelective(Event record) {
        return eventMapper.insertSelective(record);
    }

    @Override
    public Event selectByPrimaryKey(Integer id) {
        return eventMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Event record) {
        return eventMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Event record) {
        return eventMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Event> selectAll(String userid) {
        return eventMapper.selectAllByOwner(Long.valueOf(userid));
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return eventMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    @Override
    public void addGroupEvent(String userid, String groupid, EventDto groupEvent) {
        // 校验ID有效性
        User user = userMapper.selectByPrimaryKey(Integer.valueOf(userid));
        if (Objects.isNull(user)) {
            throw new IllegalArgumentException("用户ID无效");
        }
        Group group = groupMapper.selectByPrimaryKey(Integer.valueOf(groupid));
        // 校验群ID的有效性
        if (group == null) {
            throw new IllegalArgumentException("群ID无效");
        }
        if (!group.getCreator().equals(user.getId())) {
            throw new IllegalArgumentException("无权创建");
        }
        // 获取群成员
        List<Integer> members = groupMemberMapper.selectGroupMember(Integer.valueOf(groupid));
        // 对每个成员都添加事件
        for (Integer member : members) {
            Event event = new Event();
            event.setMajor(groupEvent.getMajor());
            event.setName(groupEvent.getName());
            event.setTime(groupEvent.getTime());
            event.setOwner(member);
            event.setTeacher(groupEvent.getTeacher());
            eventMapper.insert(event);
        }
    }
}


