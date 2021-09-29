package boke.boke.controller;

import boke.boke.JWT.ResultMap;
import boke.boke.entity.User;
import boke.boke.entity.Userdatainfo;
import boke.boke.service.UserInfo;
import boke.boke.util.JWTUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

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
        System.out.println("进入登录控制器");
        System.out.println("用户名："+username+"密码："+password);
        String pwd = userInfoservice.UserLog(username);
        if (null == pwd) {
            System.out.println("密码查询不到");
            return resultMap.fail().code(401).message("用户名错误");
        } else if (!pwd.equals(password)) {
            System.out.println("密码错误");
            return resultMap.fail().code(401).message("密码错误");
        } else {
            return resultMap.success().code(200).message(JWTUtil.createToken(username));
        }
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
}
