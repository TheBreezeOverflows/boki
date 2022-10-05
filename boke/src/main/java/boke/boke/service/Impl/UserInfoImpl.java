package boke.boke.service.Impl;

import boke.boke.entity.User;
import boke.boke.entity.UserExample;
import boke.boke.entity.Userdatainfo;
import boke.boke.mapper.UserMapper;
import boke.boke.mapper.UserdatainfoMapper;
import boke.boke.service.UserInfo;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserInfoImpl implements UserInfo {
    //依赖mapper
    @Autowired(required = false)
    private UserMapper userMapper;
    //依赖mapper
    @Autowired(required = false)
    private UserdatainfoMapper userdatainfoMapper;

    //根据id查询用户信息
    @Override
    public User UserInfo(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

   //根据用户id查询用户详细信息
    @Override
    public Userdatainfo UserDatailInfo(int id) {
        return userdatainfoMapper.selectByusernamePrimaryKey(id);
    }


    /**
     *
     * @param user 用户信息
     * @return 用户注册
     */
    @Override
    public boolean UserRegister(User user) {
        boolean fal =false;
        int in = userMapper.insertstr(user);
        if (in!=0){
            user.getUserdatainfo().setUserId(in);
            userdatainfoMapper.insert(user.getUserdatainfo());
            fal=true;
        }
        return fal;
    }

    /**
     *
     * @param name
     * @return 根据用户名获取用户密码
     */
    @Override
    public String Userpwass(String name) {
        return userMapper.getPassword(name);
    }


    /**
     *
     * @param name 用户名
     * @return 根据用户名获取角色权限
     */
    @Override
    public String UserPermission(String name) {
        return userMapper.getRole(name);
    }

    /**
     *
     * @param username 用户名
     * @param userpassword 用户密码
     * @return 根据用户名密码获取用户信息
     */
    @Override
    public User login(String username, String userpassword) {
        UserExample example=new UserExample();
        example.createCriteria().andUserNameEqualTo(username)
                .andUserUserPasswordEqualTo(userpassword);
        return userMapper.selectByExample(example).get(0);
    }
}
