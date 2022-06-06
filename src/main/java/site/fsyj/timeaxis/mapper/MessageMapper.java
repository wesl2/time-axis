package site.fsyj.timeaxis.mapper;

import org.apache.ibatis.annotations.Mapper;
import site.fsyj.timeaxis.entity.Message;

@Mapper
public interface MessageMapper {
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
    int insert(Message record);

    /**
     * insert record to table selective
<<<<<<< HEAD
     *
=======
>>>>>>> 961dc4a4990572e3a9cec04845f0e86cf539dac8
     * @param record the record
     * @return insert count
     */
    int insertSelective(Message record);

    /**
     * select by primary key
<<<<<<< HEAD
     *
=======
>>>>>>> 961dc4a4990572e3a9cec04845f0e86cf539dac8
     * @param id primary key
     * @return object by primary key
     */
    Message selectByPrimaryKey(Integer id);

    /**
     * update record selective
<<<<<<< HEAD
     *
=======
>>>>>>> 961dc4a4990572e3a9cec04845f0e86cf539dac8
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Message record);

    /**
     * update record
<<<<<<< HEAD
     *
=======
>>>>>>> 961dc4a4990572e3a9cec04845f0e86cf539dac8
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Message record);
}