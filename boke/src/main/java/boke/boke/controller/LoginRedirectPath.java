package boke.boke.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录跳转控制
 */
@Controller
@RequestMapping("redirec")
public class LoginRedirectPath {

    @GetMapping("/login")
    public String logPath(){
        return "redirect:/index";
    }
    @GetMapping("/")
    public String redirec(){
        return "redirect:/index";
    }

}
