package site.fsyj.timeaxis.service;

import site.fsyj.timeaxis.entity.Event;

import java.util.List;

public interface EventService{


    int deleteByPrimaryKey(Integer id);

    int insert(Event record);

    int insertSelective(Event record);

    Event selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Event record);

    int updateByPrimaryKey(Event record);

    List<Event> selectAll(String userid);
}
