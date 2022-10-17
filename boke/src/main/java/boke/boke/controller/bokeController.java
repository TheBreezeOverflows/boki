package boke.boke.controller;


import boke.boke.entity.Blogsarticle;
import boke.boke.entity.dto.SearchParam;
import boke.boke.entity.dto.SearchResult;
import boke.boke.service.BlogsArticleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 首页博客文章查询
 */
@RestController
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
    public SearchResult ClassifyfindPage(int id,int lab,SearchParam par){
        if (lab<0){
            par.setPageNum(1);
        }
        return blogsArticleInfo.BlogsArticleClassifyIdInfo(id,par);
    }

    //根据名称信息查询信息
    @GetMapping("/NamePage")
    @ResponseBody
    public SearchResult NamefindPage(SearchParam para,String search){
        SearchResult<Blogsarticle> blogsarticleSearchResult = blogsArticleInfo.BlogsArticleNameifyIdInfo(para,search);;
        return blogsarticleSearchResult;
    }

}
