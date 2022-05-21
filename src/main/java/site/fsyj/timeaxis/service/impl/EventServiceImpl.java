package site.fsyj.timeaxis.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import site.fsyj.timeaxis.mapper.EventMapper;
import site.fsyj.timeaxis.entity.Event;
import site.fsyj.timeaxis.service.EventService;
@Service
public class EventServiceImpl implements EventService{

    @Resource
    private EventMapper eventMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return eventMapper.deleteByPrimaryKey(id);
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

}
