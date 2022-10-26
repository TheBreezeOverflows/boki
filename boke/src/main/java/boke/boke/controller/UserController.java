package boke.boke.controller;

import boke.boke.JWT.ResultMap;
import boke.boke.entity.Friend;
import boke.boke.entity.User;
import boke.boke.entity.Userdatainfo;
import boke.boke.entity.dto.SearchParam;
import boke.boke.entity.dto.SearchResult;
import boke.boke.mapper.UserMapper;
import boke.boke.service.UserInfo;
import boke.boke.util.GetHeaderToken;
import boke.boke.util.JWTUtil;
import boke.boke.util.UtilTools;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 用户登录和用户信息查询
 */
@RestController
@RequestMapping("user")
public class UserController  {
    private final ResultMap resultMap;
    private final UserInfo userInfoservice;
    @Autowired
    public UserController(UserInfo userInfoservice, ResultMap resultMap) {
        this.userInfoservice = userInfoservice;
        this.resultMap = resultMap;
    }

    //用户登录
    @PostMapping("/login")
    public ResultMap Userlog(String username,String password){
        String pass = userInfoservice.Userpwass(username);
        if (null != pass) {
           String pwd =PasswordDecode(password);
            if (!pwd.equals(pass)) {
                return resultMap.fail().code(401).message("密码错误");
            } else {
                User user = userInfoservice.login(username,pwd);
                String token = JWTUtil.createToken(user.getUserId() + "", user.getUserName(), user.getUserUserPassword());
                return resultMap.success().code(200).message(token);
            }
        }
        return resultMap.fail().code(401).message("用户名错误");
    }
    //注册
    @PostMapping("/register")
    public ResultMap UserRegister(String username,String password,String email,String birthday){
        String uname = userInfoservice.Userpwass(username);

        if (null !=uname) {
            return resultMap.fail().code(401).message("用户名已经存在");
        } else {
            String register = Register(username, password, email, birthday);
            return resultMap.fail().code(401).message(register);
        }
    }
    //注册调用方法
    public String Register(String username,String password,String email,String birthday){
        String pwd = PasswordEncryption(password);
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
        User user=new User();
        Userdatainfo userdatainfo=new Userdatainfo();
        user.setUserName(username);
        user.setUserUserPassword(pwd);
        user.setPermission("initial");
        userdatainfo.setUserTime(new Date());
        userdatainfo.setUserEmail(email);
        try {
            userdatainfo.setUserBirthdaydate(sdf.parse(birthday));
        } catch (Exception e) {
            System.out.println("日期类型转换异常");
            e.printStackTrace();
        }
        user.setUserdatainfo(userdatainfo);
        boolean blean = userInfoservice.UserRegister(user);
        if (blean) {
            return "注册成功";
        } else {
            return "注册失败请检查注册信息是否有异常";
        }
    }
    //密码加密
    public static String PasswordEncryption(String password){
        SimpleHash simpleHash = new SimpleHash("MD5", password.getBytes(StandardCharsets.UTF_8), UtilTools.Salt(), 128);
        return simpleHash.toHex();
    }
    //密码匹配
    public String PasswordDecode(String password){
        SimpleHash simpleHash = new SimpleHash("MD5", password.getBytes(StandardCharsets.UTF_8), UtilTools.Salt(), 128);
        return simpleHash.toHex();
    }
    //错误页面
    @RequestMapping(path = "/error/{message}")
    public ResultMap unauthorized(@PathVariable String message) throws UnsupportedEncodingException {
        return resultMap.success().code(401).message(message);
    }

    //获取默认用户信息
    @GetMapping(path = "infos")
    public Userdatainfo defaults(){
        return userInfoservice.UserDatailInfo(1);
    }

    @GetMapping(path = "info")
    public Userdatainfo defauser(){
        return userInfoservice.UserDatailInfo(1);
    }
    //-------------------------------------------后台页面(后台的接口可以添加token的验证)----------------------------------------------------------------
    //分页查询所有用户
    @GetMapping("/AllUsermessage")
    @ResponseBody
    public SearchResult selectAlluser(SearchParam params){
        return userInfoservice.AllUserMessage(params);
    }
    //根据名称分页查询所有用户
    @GetMapping("/NamePage")
    @ResponseBody
    public SearchResult NamefindPage(SearchParam para,String search){
        SearchResult<Userdatainfo> CommentSearchResult = userInfoservice.AlluserNameMessage(para,search);;
        return CommentSearchResult;
    }
    //修改用户
    @PutMapping("/UserOper")
    @ResponseBody
    public SearchResult<?> updateuser(@RequestBody Userdatainfo userdatainfo){
        boolean flg =true; userInfoservice.updateByUser(userdatainfo);
        if (flg){
            return SearchResult.success();
        }
        return SearchResult.success("500");
    }
    //删除用户
    @GetMapping("/delteComment")
    @ResponseBody
    public SearchResult<?> deleteFriend(int id,int infoid) {
        System.out.print("id="+id);
        userInfoservice.DelteByUserMessage(id,infoid);
        return SearchResult.success();
    }

    //分页查询所有用户
    @GetMapping("/AllUser")
    @ResponseBody
    public List<User> selectAlluserinfo(){
        return userInfoservice.selectAlluserinfo();
    }
}