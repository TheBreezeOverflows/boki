package boke.boke.controller;

import boke.boke.entity.Classify;
import boke.boke.mapper.ClassifyMapper;
import boke.boke.service.ClassifyInfo;
import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
*个人技术栏查询
 */
@Controller
@RequestMapping("classif")
public class ClassifyController {

    //依赖server接口
    @Autowired(required = false)
    private ClassifyInfo classifyInfo;

    @GetMapping("/base")
    @ResponseBody
    public List<Classify> classifybase(){
        return classifyInfo.calssifyInfo();
    }
    //查询当前文章的标签id
    @GetMapping("/bolgClass")
    @ResponseBody
    public String bolgClass(String ids){
        String str="java";
        if (!StringUtils.isEmpty(ids)){
            str=classifyInfo.selectByByPrimaryClassid(Integer.parseInt(ids));
        }
        return str;
    }
    }
