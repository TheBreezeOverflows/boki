package boke.boke.service.Impl;

import boke.boke.entity.User;
import boke.boke.entity.UserExample;
import boke.boke.entity.Userdatainfo;
import boke.boke.mapper.UserMapper;
import boke.boke.mapper.UserdatainfoMapper;
import boke.boke.service.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    //用户登录
    @Override
    public String UserLog(String name) {
        return userMapper.getpwd(name);
    }

    //用户注册
    @Override
    public boolean UserRegister(User user) {
        boolean fal =false;
        int in = userMapper.insert(user);
        if (in>0){
            fal=true;
        }
        return fal;
    }

    //根据用户姓名获取用户密码
    @Override
    public String Userpwass(String name) {
        return userMapper.getPassword(name);
    }

    //根据用户名获取角色权限
    @Override
    public String UserPermission(String name) {
        return userMapper.getRole(name);
    }
}
