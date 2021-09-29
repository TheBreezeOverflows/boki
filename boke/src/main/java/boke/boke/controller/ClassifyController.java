package boke.boke.controller;

import boke.boke.entity.Classify;
import boke.boke.mapper.ClassifyMapper;
import boke.boke.service.ClassifyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
