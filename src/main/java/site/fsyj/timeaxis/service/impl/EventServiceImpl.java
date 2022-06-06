package site.fsyj.timeaxis.service.impl;

import org.springframework.stereotype.Service;
import site.fsyj.timeaxis.entity.Event;
import site.fsyj.timeaxis.mapper.EventMapper;
import site.fsyj.timeaxis.service.EventService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Resource
    private EventMapper eventMapper;

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

}
