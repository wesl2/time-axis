package site.fsyj.timeaxis.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import site.fsyj.timeaxis.entity.Event;

import java.util.List;

@Mapper
public interface EventMapper {
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
    int insert(Event record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Event record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    Event selectByPrimaryKey(Integer id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Event record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Event record);

    /**
     * select all
     * @param owner
     * @return
     */
    List<Event> selectAllByOwner(@Param("owner")Long owner);


}
