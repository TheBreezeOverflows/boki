package boke.boke.service;

import boke.boke.entity.Blogandclassify;
import boke.boke.entity.Blogsarticle;
import boke.boke.entity.dto.SearchParam;
import boke.boke.entity.dto.SearchResult;

import java.util.Date;
import java.util.List;

public interface BlogsArticleInfo {
    //根据用户id查询用户所编写的文章
    public SearchResult<Blogsarticle> BlogsArticleUserIdInfo(SearchParam searchParam);
    //根据文章分类id查询用户所写文章
    public SearchResult<Blogsarticle> BlogsArticleClassifyIdInfo(int id, SearchParam searchParam);
    //根据文章id查询文章内容
    public Blogsarticle BlogsArticleContentInfo(int id);
    //根据时间查询文章
    public  SearchResult<Blogsarticle>  BlogsArticleCreationTime(Date time, SearchParam searchParam);

    //根据文章id查询文章标签信息
    public List<Blogandclassify> LableRelevanceLableid(int id);
}
