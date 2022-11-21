package boke.boke.controller;

import boke.boke.entity.Blogsarticle;
import boke.boke.entity.Classify;
import boke.boke.entity.User;
import boke.boke.entity.dto.SearchResult;
import boke.boke.service.BlogsArticleInfo;
import boke.boke.service.ClassifyInfo;
import boke.boke.util.GetHeaderToken;
import boke.boke.util.JWTUtil;
import com.alibaba.druid.util.StringUtils;
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
        if (!GetHeaderToken.gettokenEmpty()){
            return SearchResult.success2("4399");
        }
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String transformDate=simpleDateFormat.format(new Date());
        //获取用户名称和编号进行添加
        String username ="不详";
        String userid =null;
        String token= GetHeaderToken.getRequestCookie();
        if (StringUtils.isEmpty(token)) {
            return SearchResult.success2("403");
        }
        username = JWTUtil.getUsername(token, "username");//获取当前用户名
        userid = JWTUtil.getUserid(token);//获取当前用户编号
        blog.setBlogsarticleUserId(Integer.parseInt(userid));
        blog.setBloagUserNames(username);
        blog.setBlogsarticleDate(simpleDateFormat.parse(transformDate));
        blog.setAccessnumber(0);
        blog.setCommentnumber(0);
        blog.setLikenumber(0);
        //返回新增的文章id
        int blogid = blogsArticleInfo.save(blog);
        //添加文章与标签关联
        Classify classify = classifyInfo.selectByByPrimaryClass(blog.getBlogsarticleInformation());
        if (classify.getSuperclassId()!=0){
            blogsArticleInfo.AddblogClassify(blogid,classify.getSuperclassId());
        }
        int classid =classify.getClassifyId();
        blogsArticleInfo.AddblogClassify(blogid,classid);
        return SearchResult.success();
    }

    @PutMapping
    @ResponseBody
    public SearchResult<?> update(@RequestBody Blogsarticle blog) {
        if (!GetHeaderToken.gettokenEmpty()){
            return SearchResult.success2("4399");
        }
        blog.setBlogsarticleDate(new Date());
        int bloid=blog.getBlogsarticleId();
        String blogtag=blog.getBlogsarticleInformation();
        //修改文章与标签关联
        if (!StringUtils.isEmpty(blogtag)){
            //删除文章与标签关联id
            blogsArticleInfo.removeblogIdClass(bloid);
            //添加文章与标签关联id
            Classify classify = classifyInfo.selectByByPrimaryClass(blogtag);
            if (classify.getSuperclassId()!=0){
                blogsArticleInfo.AddblogClassify(bloid,classify.getSuperclassId());
            }
            int classid =classify.getClassifyId();
            blogsArticleInfo.AddblogClassify(bloid,classid);
        }
        return SearchResult.success(blogsArticleInfo.updateById(blog));
    }

    @GetMapping("/delteblog")
    @ResponseBody
    public SearchResult<?> delete(String  id) {
        if (!GetHeaderToken.gettokenEmpty()){
            return SearchResult.success2("4399");
        }
        blogsArticleInfo.removeById(Integer.parseInt( id));
        blogsArticleInfo.removeblogIdClass(Integer.parseInt(id));
        return SearchResult.success();
    }

    //点赞
    @GetMapping("/likenumber")
    @ResponseBody
    public SearchResult<?> likenumber(String ids) {
        blogsArticleInfo.AddBlogLikenumber(Integer.parseInt(ids));
       return SearchResult.success();
    }
    //给文章回复数统计+1
    @GetMapping("/commentnumber")
    @ResponseBody
    public SearchResult<?> commentnumber(String ids) {
        blogsArticleInfo.AddBlogcommentnumber(Integer.parseInt(ids));
        return SearchResult.success();
    }
}

