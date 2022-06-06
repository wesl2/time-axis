package site.fsyj.timeaxis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import site.fsyj.timeaxis.entity.User;

@Mapper
public interface UserMapper {
    /**
     * delete by primary key
     * <<<<<<< HEAD
     * <p>
     * =======
     * >>>>>>> 961dc4a4990572e3a9cec04845f0e86cf539dac8
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert record to table
     * <<<<<<< HEAD
     * <p>
     * =======
     * >>>>>>> 961dc4a4990572e3a9cec04845f0e86cf539dac8
     *
     * @param record the record
     * @return insert count
     */
    int insert(User record);

    /**
     * insert record to table selective
     * <<<<<<< HEAD
     * <p>
     * =======
     * >>>>>>> 961dc4a4990572e3a9cec04845f0e86cf539dac8
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(User record);

    /**
     * select by primary key
     * <<<<<<< HEAD
     * <p>
     * =======
     * >>>>>>> 961dc4a4990572e3a9cec04845f0e86cf539dac8
     *
     * @param id primary key
     * @return object by primary key
     */
    User selectByPrimaryKey(Integer id);

    /**
     * update record selective
     * <<<<<<< HEAD
     * <p>
     * =======
     * >>>>>>> 961dc4a4990572e3a9cec04845f0e86cf539dac8
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * update record
     * <<<<<<< HEAD
     * <p>
     * =======
     * >>>>>>> 961dc4a4990572e3a9cec04845f0e86cf539dac8
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(User record);

    /**
     * 根据用户名（Email）查询
     * <<<<<<< HEAD
     *
     * @param username
     * @return
     */
    User selectByEmail(@Param("email") String username);
}

