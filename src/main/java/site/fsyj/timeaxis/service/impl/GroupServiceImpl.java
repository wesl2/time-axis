package site.fsyj.timeaxis.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import site.fsyj.timeaxis.mapper.GroupMapper;
import site.fsyj.timeaxis.entity.Group;
import site.fsyj.timeaxis.service.GroupService;
@Service
public class GroupServiceImpl implements GroupService{

    @Resource
    private GroupMapper groupMapper;

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

}
