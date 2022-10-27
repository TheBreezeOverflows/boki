package boke.boke.service;

import boke.boke.entity.Author;
import boke.boke.entity.Friend;
import boke.boke.entity.User;
import boke.boke.entity.Userdatainfo;
import boke.boke.entity.dto.SearchParam;
import boke.boke.entity.dto.SearchResult;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    //分页查询所有用户
    public SearchResult<Userdatainfo> AllUserMessage(SearchParam searchParam);
    //根据名称分页查询所有用户
    public SearchResult<Userdatainfo> AlluserNameMessage(SearchParam searchParam,String name);
    //修改用户
    public boolean updateByUser(Userdatainfo userdatainfo);
    //删除用户
    public boolean DelteByUserMessage(int userid,int userinfoid);
    //出现所有用户信息
    public List<User> selectAlluserinfo();
    //查询关于我
    public String selectAuthormessage();
    //后台查询关于我
    Author selectendAuthormessage();
    //根据用户编号添加关于我的信息数据
    boolean saveAuthor(Author autor);
    //修改关于我
    boolean UpdateAuthor(Author autor);
}
