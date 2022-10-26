package boke.boke.controller;

import boke.boke.entity.Classify; 
import boke.boke.entity.dto.SearchParam;
import boke.boke.entity.dto.SearchResult;
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
    //查询默认显示的,状态为零的
    @GetMapping("/base")
    @ResponseBody
    public List<Classify> classifybase(){
        return classifyInfo.calssifyInfo();
    }
    //查询所有标签
    @GetMapping("/bases")
    @ResponseBody
    public List<Classify> classifybases(){
        return classifyInfo.calssifyInfos();
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
    //分页查询所有标签
    @GetMapping("/AllClassmessage")
    @ResponseBody
    public SearchResult selectAllClass(SearchParam params){
        return classifyInfo.AllClassMessage(params);
    }
    //根据名称分页查询所有标签
    @GetMapping("/NamePage")
    @ResponseBody
    public SearchResult NamefindPage(SearchParam para,String search){
        SearchResult<Classify> CommentSearchResult = classifyInfo.AllClassNameMessage(para,search);;
        return CommentSearchResult;
    }
    //修改标签
    @PutMapping("/ClassOper")
    @ResponseBody
    public SearchResult<?> updateClass(@RequestBody Classify classify){

        boolean flg =false;
        //判断是否是类型
        if (classify.getSuperclassId()==0){
            classifyInfo.updatebigByClass(classify);
        }else {
            //查询选择的标签ID
            classifyInfo.updateByClass(classify);
        }
        if (flg){
            return SearchResult.success();
        }
        return SearchResult.success("500");
    }
    @PostMapping("/ClassOper")
    @ResponseBody
    public SearchResult<?> PostClass(@RequestBody Classify classify){

        boolean flg =false;
        flg=classifyInfo.saveByClass(classify);
        if (flg){
            return SearchResult.success();
        }
        return SearchResult.success("500");
    }
    //删除标签
    @GetMapping("/delteComment")
    @ResponseBody
    public SearchResult<?> deleteFriend(int id) {
        System.out.print("id="+id);
        //查询文章关联如果有则不通过
        boolean b = classifyInfo.DelteByClassMessage(id);
        if (b){
            return SearchResult.success();
        }
        return SearchResult.success2("-1");
    }
}
