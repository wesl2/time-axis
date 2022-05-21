package site.fsyj.timeaxis.service;

import site.fsyj.timeaxis.entity.Event;
public interface EventService{


    int deleteByPrimaryKey(Integer id);

    int insert(Event record);

    int insertSelective(Event record);

    Event selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Event record);

    int updateByPrimaryKey(Event record);

}
