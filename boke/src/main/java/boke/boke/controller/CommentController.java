package boke.boke.controller;

import boke.boke.JWT.ResultMap;
import boke.boke.entity.Comment;
import boke.boke.entity.dto.CommentResult;
import boke.boke.service.CommentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 博客评论区
 */
@RestController
@RequestMapping("/boke/Comment")
public class CommentController {
    ModelAndView mav=new ModelAndView("register");
    private final ResultMap resultMap;
    private CommentInfo commentInfo;
    //依赖mapper
    @Autowired
    public CommentController(CommentInfo commentInfo, ResultMap resultMap) {
        this.commentInfo = commentInfo;
        this.resultMap = resultMap;
    }

    //根据文章id查询文章内容
    @GetMapping("/blogComment")
    @ResponseBody
    public  List<CommentResult<Comment>> ClassArticle(String ids){
        return commentInfo.selectCommentblog(Integer.parseInt(ids));
    }
    //发表评论
    @PostMapping("/release")
    public ModelAndView UserRegister(String comment, String author, String email, String url, String messageRey, String blogid) throws ParseException {
        System.out.print("信息："+comment+"名称"+author+"邮箱"+email+"路径"+url+"回复id"+messageRey);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String transformDate=simpleDateFormat.format(new Date());
        Comment com=new Comment();
        com.setVoiceMessage(comment);
        com.setMessageName(author);
        com.setMessageEmail(email);
        com.setDirectSite(url);
        com.setMessageReply(Integer.parseInt(messageRey));
        com.setBlogsarticleId(Integer.parseInt(blogid));
        com.setCommentDate(simpleDateFormat.parse(transformDate));
        boolean b = commentInfo.AddCommentparent(com);
        if (b){
            return new ModelAndView("redirect:/detail?id="+blogid);
        }
        return new ModelAndView("redirect:/errors");


    }

}
