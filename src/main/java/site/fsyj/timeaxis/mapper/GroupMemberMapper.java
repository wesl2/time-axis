package site.fsyj.timeaxis.mapper;

import org.apache.ibatis.annotations.Mapper;
import site.fsyj.timeaxis.entity.GroupMember;

@Mapper
public interface GroupMemberMapper {
    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(GroupMember record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(GroupMember record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    GroupMember selectByPrimaryKey(Integer id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(GroupMember record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(GroupMember record);
}