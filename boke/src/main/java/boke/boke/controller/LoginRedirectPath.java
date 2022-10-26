package boke.boke.controller;

import boke.boke.util.GetHeaderToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录跳转控制
 */
@Controller
@RequestMapping("redirec")
public class LoginRedirectPath {

    @GetMapping("/login")
    public String logPath(){
        return "redirect:index";
    }
    @GetMapping("/")
    public String redirec(){
        return "redirect:index";
    }
    @GetMapping("/endframe")
    public String frameend(){
        //return "forward:/end/frame";
        return "redirect:/end/frame";//重定向
    }

}
