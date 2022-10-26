package boke.boke.mapper;

import boke.boke.entity.User;
import boke.boke.entity.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertstr(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 获得密码
     * @param userName 用户名
     */
    String getPassword(String userName);

    /**
     * 获得角色权限
     * @param userName 用户名
     * @return user/admin
     */
    String getRole(String userName);

    /**
     * 根据用户名查询密码
     */
    String getpwd(String name);

    //查询所有用户名和编号
    List<User> selectByAllUser();
}