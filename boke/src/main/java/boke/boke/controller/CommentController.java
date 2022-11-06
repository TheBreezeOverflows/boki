package boke.boke.controller;

import boke.boke.JWT.ResultMap;
import boke.boke.entity.Blogsarticle;
import boke.boke.entity.Comment;
import boke.boke.entity.dto.CommentResult;
import boke.boke.entity.dto.SearchParam;
import boke.boke.entity.dto.SearchResult;
import boke.boke.service.BlogsArticleInfo;
import boke.boke.service.CommentInfo;
import boke.boke.util.GetHeaderToken;
import boke.boke.util.JWTUtil;
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
    private BlogsArticleInfo blogsArticleInfo;
    //依赖mapper
    @Autowired
    public CommentController(CommentInfo commentInfo, ResultMap resultMap, BlogsArticleInfo blogsArticleInfo) {
        this.commentInfo = commentInfo;
        this.resultMap = resultMap;
        this.blogsArticleInfo=blogsArticleInfo;
    }

    //根据文章id查询评论区内容
    @GetMapping("/blogComment")
    @ResponseBody
    public SearchResult ClassArticle(SearchParam params,String ids){
        return commentInfo.selectCommentblog(params,Integer.parseInt(ids));
    }
    //查询留言板
    @GetMapping("/blogCommentmessage")
    @ResponseBody
    public  SearchResult selectblogmessage(SearchParam params){
        return commentInfo.selectblogmessage(params);
    }
    //发表评论
    @PostMapping("/release")
    public ModelAndView UserRegister(String comment, String author, String email, String url,
                                     String messageRey, String blogid,String messagename,String audit) throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String transformDate=simpleDateFormat.format(new Date());
        Comment com=new Comment();
        com.setVoiceMessage(comment);
        com.setMessageName(author);
        com.setMessageEmail(email);
        com.setDirectSite(url);
        com.setMessageReply(Integer.parseInt(messageRey));
        com.setBlogsarticleId(Integer.parseInt(blogid));
        com.setCommentDate(simpleDateFormat.parse(transformDate));
        com.setMessageReplyName(messagename);
        String str="redirect:/detail?id="+blogid+"#comment-"+messageRey;
        if (audit.equals("0")){//是否需要审核
            com.setCommentAudit(0);
            str="redirect:/message#comment-"+messageRey;
        }else if(audit.equals("-1")) {
            com.setCommentAudit(1);
            str="redirect:/friend#comment-"+messageRey;
        }else {
            //当评论的是谋篇文章时则增加文章类中评论总数
            blogsArticleInfo.AddBlogcommentnumber(Integer.parseInt(blogid));
            com.setCommentAudit(1);
        }
        //判断是否有token
        String token= GetHeaderToken.getRequestCookie("baitoken");
        String userid = JWTUtil.getUserid(token);
        if (userid.equals("1")){
            com.setHeadPortrait("/style/images/headImg.png");
            com.setCommentAudit(1);
        }
        //添加评论数据
        boolean b = commentInfo.AddCommentparent(com);
        if (b){
            return new ModelAndView(str);
        }
        return new ModelAndView("redirect:/errors");
    }
    //查询所有评论
    @GetMapping("/AllCommentmessage")
    @ResponseBody
    public  SearchResult selectAllComment(SearchParam params){
        return commentInfo.AllCommentmessage(params);
    }
    //根据名称信息查询信息
    @GetMapping("/NamePage")
    @ResponseBody
    public SearchResult NamefindPage(SearchParam para,String search){
        SearchResult<Comment> CommentSearchResult = commentInfo.commentNameifyIdInfo(para,search);;
        return CommentSearchResult;
    }
    //删除评论
    @GetMapping("/delteComment")
    @ResponseBody
    public SearchResult<?> deleteComment(int id,int blogid) {
        int i = commentInfo.DelteCommentmessage(id);
        //减少总评论数量
        if (i>0){
            blogsArticleInfo.delBlogcommentnumber(blogid,i);
        }
        return SearchResult.success();
    }
    //审核评论
    @GetMapping("/updateComment")
    @ResponseBody
    public SearchResult<?> updateComment(int id) {
        commentInfo.AuditCommentmessage(id);
        return SearchResult.success();
    }
}
