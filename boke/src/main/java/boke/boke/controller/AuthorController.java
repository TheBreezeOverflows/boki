package boke.boke.controller;

import boke.boke.entity.Author;
import boke.boke.entity.dto.SearchResult;
import boke.boke.service.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 博客个人信息
 */
@RestController
@RequestMapping("/authorblog")
public class AuthorController {
    @Autowired
    private  UserInfo userInfoservice;

    //查询关于我页面
    @GetMapping("/Authormessage")
    @ResponseBody
    public String selectAuthormessage(){
       return userInfoservice.selectAuthormessage();
    }
    @GetMapping("/endAuthormessage")
    @ResponseBody
    public Author selectendAuthormessage(){
        Author author =null;
         author = userInfoservice.selectendAuthormessage();
        if (author==null){
            author =new Author();
            author.setAuthorId(0);
        }
        return author;
    }
    @PostMapping("/saveAuthor")
    @ResponseBody
    public  SearchResult<?>  saveAuthor(@RequestBody Author autor){
        boolean b = userInfoservice.saveAuthor(autor);
        if (b){
            return SearchResult.success();
        }
        return SearchResult.success2("500");
    }

    @PutMapping("/saveAuthor")
    @ResponseBody
    public  SearchResult<?>  UpdateAuthor(@RequestBody Author autor){
        boolean b = userInfoservice.UpdateAuthor(autor);
        if (b){
            return SearchResult.success();
        }
        return SearchResult.success2("500");
    }
}
