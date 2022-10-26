package boke.boke.service.Impl;

import boke.boke.controller.UserController;
import boke.boke.entity.*;
import boke.boke.entity.dto.SearchParam;
import boke.boke.entity.dto.SearchResult;
import boke.boke.mapper.LinkMapper;
import boke.boke.mapper.UserMapper;
import boke.boke.mapper.UserdatainfoMapper;
import boke.boke.service.UserInfo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoImpl implements UserInfo {
    //依赖mapper
    @Autowired(required = false)
    private UserMapper userMapper;
    //依赖mapper
    @Autowired(required = false)
    private UserdatainfoMapper userdatainfoMapper;
    //依赖mapper
    @Autowired(required = false)
    private LinkMapper linkMapper;

    //根据id查询用户信息
    @Override
    public User UserInfo(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

   //根据用户id查询用户详细信息
    @Override
    public Userdatainfo UserDatailInfo(int id) {


        Userdatainfo userdatainfo = userdatainfoMapper.selectByusernamePrimaryKey(id);
        List<Link> links = linkMapper.selectByUserType(id);
        if (links.size()>0){
            userdatainfo.setUserRelevance(links);
        }
        return userdatainfo;
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
            user.getUserdatainfo().setUserId(user.getUserId());
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

    /**
     * 分页查询所有用户信息
     * @return
     */
    @Override
    public SearchResult<Userdatainfo> AllUserMessage(SearchParam searchParam) {
        //设置分页信息
        PageHelper.startPage(searchParam.getPageNum(), searchParam.getPageSize());
        List<Userdatainfo> brands = userdatainfoMapper.selectendPrimaryKey();
        //查询
        Page page =new Page();
        if (brands instanceof Page){
            page = (Page) brands;
            return new SearchResult<>(page.getTotal(), page.getResult());
        }
        return new SearchResult<Userdatainfo>((long)brands.size(),brands);
    }

    /**
     * 根据name分页查询所有用户信息
     * @return
     */
    @Override
    public SearchResult<Userdatainfo> AlluserNameMessage(SearchParam searchParam, String name) {
        //设置分页信息
        PageHelper.startPage(searchParam.getPageNum(), searchParam.getPageSize());
        List<Userdatainfo> brands = userdatainfoMapper.selectendPrimaryname(name);
        //查询
        Page page =new Page();
        if (brands instanceof Page){
            page = (Page) brands;
            return new SearchResult<>(page.getTotal(), page.getResult());
        }
        return new SearchResult<Userdatainfo>((long)brands.size(),brands);
    }

    /**
     * 修改用户信息
     * @param userdatainfo
     * @return
     */
    @Override
    public boolean updateByUser(Userdatainfo userdatainfo){
        boolean fal =false;
        User user = new User();
        user.setUserId(userdatainfo.getUserId());
        user.setUserName(userdatainfo.getUserdatanames());
        user.setPermission(userdatainfo.getUserpermission());
        if (!userdatainfo.getUserPassword().isEmpty()){
            user.setUserUserPassword(UserController.PasswordEncryption(userdatainfo.getUserPassword()));
        }
        //修改用户信息
        int in =userMapper.updateByPrimaryKey(user);
        if (in!=0){
            //修改用户详细信息
            int i =  userdatainfoMapper.updateByPrimaryKey(userdatainfo);
            if (i!=0){
                fal=true;
            }
        }
        return fal;
    }


    @Override
    public boolean DelteByUserMessage(int userid,int userinfoid) {
        boolean fal =false;
        //删除用户详细信息
        int in =userdatainfoMapper.deleteByPrimaryKey(userinfoid);
        if (in!=0){
            //删除用户信息
            int i =  userMapper.deleteByPrimaryKey(userid);
            if (i!=0){
                fal=true;
            }
        }
        return fal;
    }

    @Override
    public List<User> selectAlluserinfo() {
        return userMapper.selectByAllUser();
    }
}
