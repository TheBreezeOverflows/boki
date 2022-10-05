package boke.boke.service;

import boke.boke.entity.User;
import boke.boke.entity.Userdatainfo;
import org.springframework.transaction.annotation.Transactional;

public interface UserInfo {
    //根据id查询用户信息
    public User UserInfo(int id);
    //根据用户id查询用户详细信息
    public Userdatainfo UserDatailInfo(int id);
    //用户注册
    //@Transactional
    public boolean UserRegister(User user);
    //根据用户姓名获取用户密码
    public String Userpwass(String name);
    //根据用户名获取角色权限
    public String UserPermission(String name);
    // 根据用户密码
    public User login(String username,String userpassword);
}
