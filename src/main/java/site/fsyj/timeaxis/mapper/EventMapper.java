package site.fsyj.timeaxis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import site.fsyj.timeaxis.entity.Event;

import java.util.List;

@Mapper
public interface EventMapper {
    /**
     * delete by primary key
<<<<<<< HEAD
     *
=======
>>>>>>> 961dc4a4990572e3a9cec04845f0e86cf539dac8
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert record to table
<<<<<<< HEAD
     *
=======
>>>>>>> 961dc4a4990572e3a9cec04845f0e86cf539dac8
     * @param record the record
     * @return insert count
     */
    int insert(Event record);

    /**
     * insert record to table selective
<<<<<<< HEAD
     *
=======
>>>>>>> 961dc4a4990572e3a9cec04845f0e86cf539dac8
     * @param record the record
     * @return insert count
     */
    int insertSelective(Event record);

    /**
     * select by primary key
<<<<<<< HEAD
     *
=======
>>>>>>> 961dc4a4990572e3a9cec04845f0e86cf539dac8
     * @param id primary key
     * @return object by primary key
     */
    Event selectByPrimaryKey(Integer id);

    /**
     * update record selective
<<<<<<< HEAD
     *
=======
>>>>>>> 961dc4a4990572e3a9cec04845f0e86cf539dac8
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Event record);

    /**
     * update record
<<<<<<< HEAD
     *
=======
>>>>>>> 961dc4a4990572e3a9cec04845f0e86cf539dac8
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Event record);

    /**
     * select all
<<<<<<< HEAD
     *
     * @param owner
     * @return
     */
    List<Event> selectAllByOwner(@Param("owner") Long owner);
}