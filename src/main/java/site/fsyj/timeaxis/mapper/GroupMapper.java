package site.fsyj.timeaxis.mapper;

import org.apache.ibatis.annotations.Mapper;
import site.fsyj.timeaxis.entity.Group;

@Mapper
public interface GroupMapper {
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
    int insert(Group record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Group record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    Group selectByPrimaryKey(Integer id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Group record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Group record);

    /**
     * 返回群组ID
     *
     * @param groupname
     * @return
     */
    Integer selectByName(String groupname);
}