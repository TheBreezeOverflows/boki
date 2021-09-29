package boke.boke.controller;


import boke.boke.entity.Blogsarticle;
import boke.boke.entity.dto.SearchParam;
import boke.boke.entity.dto.SearchResult;
import boke.boke.service.BlogsArticleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 首页博客文章查询
 */
@Controller
public class bokeController {
    //依赖mapper
    @Autowired
    private BlogsArticleInfo blogsArticleInfo;

    //根据用户id查询文章信息
    @GetMapping("/userPage")
    @ResponseBody
    public SearchResult userfindPage(SearchParam param){
        SearchResult<Blogsarticle> blogsarticleSearchResult = blogsArticleInfo.BlogsArticleUserIdInfo(param);
        return blogsarticleSearchResult;
    }


    //根据分类id查询文章信息
    @GetMapping("/classPage")
    @ResponseBody
    public SearchResult ClassifyfindPage(int id,SearchParam par){
        System.out.println("请求成功id="+id+"当前页数="+par.getPageNum()+"总："+par.getPageSize());
        return blogsArticleInfo.BlogsArticleClassifyIdInfo(id,par);
    }



    //根据文章id查询文章内容
    @GetMapping("/Classnameid")
    @ResponseBody
    public Blogsarticle ClassArticle(int id){
        Blogsarticle blogsarticle = blogsArticleInfo.BlogsArticleContentInfo(id);
        return blogsarticle;
    }

}
