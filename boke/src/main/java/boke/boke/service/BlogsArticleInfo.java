package boke.boke.service;

import boke.boke.entity.Blogandclassify;
import boke.boke.entity.Blogsarticle;
import boke.boke.entity.User;
import boke.boke.entity.dto.SearchParam;
import boke.boke.entity.dto.SearchResult;

import java.util.Date;
import java.util.List;

public interface BlogsArticleInfo {
    //根据用户id查询用户所编写的文章
    public SearchResult<Blogsarticle> BlogsArticleUserIdInfo(SearchParam searchParam);
    //根据文章分类id查询用户所写文章
    public SearchResult<Blogsarticle> BlogsArticleClassifyIdInfo(int id, SearchParam searchParam);
    //根据文章名称查询文章相关信息
    public SearchResult<Blogsarticle> BlogsArticleNameifyIdInfo( SearchParam searchParam,String name);
    //根据文章id查询文章内容
    public Blogsarticle BlogsArticleContentInfo(int id);
    //根据时间查询文章
    public  SearchResult<Blogsarticle>  BlogsArticleCreationTime(Date time, SearchParam searchParam);
    //根据文章id查询文章标签信息
    public List<Blogandclassify> LableRelevanceLableid(int id);
    //保存文章信息
    public int save(Blogsarticle blog);
    //修改文章信息
    public boolean updateById(Blogsarticle blog);
    //根据id删除文章
    public boolean removeById(int id);
    //添加文章与标签关联信息
    public boolean AddblogClassify(int blogid,int classid);
    //修改文章与标签关联信息
    public boolean UpdablogClassify(int blogid,int classid);
    //删除当前文章与标签关联
    public boolean removeblogIdClass(int id);
    //给文章添加一次浏览次数
    public boolean AddBlogAccessnumber(int id);
    //给文章点赞
    public boolean AddBlogLikenumber(int id);
    //给文章回复数统计+1
    public boolean AddBlogcommentnumber(int id);
    //给文章回复数统计-n
    public boolean delBlogcommentnumber(int id,int number);
}
