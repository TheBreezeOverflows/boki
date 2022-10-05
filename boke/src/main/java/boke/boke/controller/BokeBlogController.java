package boke.boke.controller;

import boke.boke.entity.Blogsarticle;
import boke.boke.entity.User;
import boke.boke.entity.dto.SearchResult;
import boke.boke.service.BlogsArticleInfo;
import boke.boke.service.ClassifyInfo;
import boke.boke.util.GetHeaderToken;
import boke.boke.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 后台博客文章详细操作
 */
@RestController
@RequestMapping("/boke/blog")
public class BokeBlogController {

    //依赖mapper
    @Autowired
    private BlogsArticleInfo blogsArticleInfo;
    @Autowired
    private ClassifyInfo classifyInfo;

    //根据文章id查询文章内容
    @GetMapping("/Classnameid")
    @ResponseBody
    public Blogsarticle ClassArticle(String ids){
        Blogsarticle blogsarticle = blogsArticleInfo.BlogsArticleContentInfo(Integer.parseInt(ids));
        return blogsarticle;
    }
    //根据文章id查询文章内容添加流量数
    @GetMapping("/Classname")
    @ResponseBody
    public Blogsarticle ClassArticlenumber(String ids){
        int id =Integer.parseInt(ids);
        blogsArticleInfo.AddBlogAccessnumber(id);
        Blogsarticle blogsarticle = blogsArticleInfo.BlogsArticleContentInfo(id);
        return blogsarticle;
    }
    @PostMapping
    @ResponseBody
    public SearchResult<?> save(@RequestBody Blogsarticle blog) throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String transformDate=simpleDateFormat.format(new Date());
        //获取用户名称和编号进行添加
        String username ="不详";
        String userid =null;
        String token= GetHeaderToken.getRequestHeaderMap().get("baitoken");
        if (!token.equals(null)) {
             username = JWTUtil.getUsername(token, "username");//获取当前用户名
             userid = JWTUtil.getUserid(token);//获取当前用户编号
        }
        blog.setBlogsarticleUserId(Integer.parseInt(userid));
        blog.setBloagUserNames(username);
        blog.setBlogsarticleDate(simpleDateFormat.parse(transformDate));
        blog.setAccessnumber(0);
        blog.setCommentnumber(0);
        //返回新增的文章id
        int blogid = blogsArticleInfo.save(blog);
        //添加文章与标签关联
        int classid =classifyInfo.selectByByPrimaryClass(blog.getBlogsarticleInformation());
        blogsArticleInfo.AddblogClassify(blogid,classid);
        return SearchResult.success();
    }

    @PutMapping
    @ResponseBody
    public SearchResult<?> update(@RequestBody Blogsarticle blog) {
        blog.setBlogsarticleDate(new Date());
        //修改文章与标签关联
        if (blog.getBlogsarticleInformation()!=null){
            int classid =classifyInfo.selectByByPrimaryClass(blog.getBlogsarticleInformation());
            blogsArticleInfo.UpdablogClassify(blog.getBlogsarticleId(), classid);
        }
        return SearchResult.success(blogsArticleInfo.updateById(blog));
    }

    @GetMapping("/delteblog")
    @ResponseBody
    public SearchResult<?> delete(int id) {
        System.out.print("id="+id);
        blogsArticleInfo.removeById(id);
        blogsArticleInfo.removeblogIdClass(id);
        return SearchResult.success();
    }

    //点赞
    @GetMapping("/commentnumber")
    @ResponseBody
    public SearchResult<?> commentnumber(String ids) {
        blogsArticleInfo.AddBlogcommentnumber(Integer.parseInt(ids));
       return SearchResult.success();
    }
}

