package boke.boke.service.Impl;

import boke.boke.entity.*;
import boke.boke.entity.dto.SearchParam;
import boke.boke.entity.dto.SearchResult;
import boke.boke.mapper.BlogandclassifyMapper;
import boke.boke.mapper.BlogsarticleMapper;
import boke.boke.service.BlogsArticleInfo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BlogsArticleInfoImpl implements BlogsArticleInfo {
    //依赖mapper
    @Autowired(required = false)
    private BlogsarticleMapper blogsarticleMapper;
    @Autowired(required = false)
    private BlogandclassifyMapper blogandclassifyMapper;

    public BlogsArticleInfoImpl() {
    }

    //根据用户id查询用户所编写的文章
    @Override
    public SearchResult<Blogsarticle> BlogsArticleUserIdInfo(SearchParam searchParam) {
       //设置分页信息
        PageHelper.startPage(searchParam.getPageNum(), searchParam.getPageSize());
        //查询
        Page page =new Page();
        List<Blogsarticle> brands = blogsarticleMapper.selectByExampleusername(null);
        if (brands instanceof Page){
            page = (Page) brands;
            return new SearchResult<>(page.getTotal(), page.getResult());
        }
        return new SearchResult<Blogsarticle>((long)brands.size(),brands);
    }


    //根据文章分类id查询用户所写文章
    @Override
    public SearchResult<Blogsarticle> BlogsArticleClassifyIdInfo(int id, SearchParam searchParam) {
        //设置分页信息
        PageHelper.startPage(searchParam.getPageNum(), searchParam.getPageSize());
        //查询
        Page page =new Page();
        //获取根据文章标签查询的文章信息集合
        List<Blogsarticle> brands = blogsarticleMapper.selectByClassifExample(id);
        if (null!=brands) {
            if (brands instanceof Page) {
                page = (Page) brands;
                return new SearchResult<>(page.getTotal(), page.getResult());
            }
        }
        return new SearchResult<Blogsarticle>((long)brands.size(),brands);
    }
    //根据文章分类id查询用户所写文章
    @Override
    public SearchResult<Blogsarticle> BlogsArticleNameifyIdInfo(SearchParam searchParam,String name) {
        //设置分页信息
        PageHelper.startPage(searchParam.getPageNum(), searchParam.getPageSize());
        //查询
        Page page =new Page();
        //获取根据文章标签查询的文章信息集合
        List<Blogsarticle> brands = blogsarticleMapper.selectByNameifExample(name);
        if (null!=brands) {
            if (brands instanceof Page) {
                page = (Page) brands;
                return new SearchResult<>(page.getTotal(), page.getResult());
            }
        }
        return new SearchResult<Blogsarticle>((long)brands.size(),brands);
    }

    //根据文章id查询文章内容
    @Override
    public Blogsarticle BlogsArticleContentInfo(int id) {
        return blogsarticleMapper.selectByblogclasscontent(id);
    }

    //根据创建时间查询文章分类信息
    @Override
    public SearchResult<Blogsarticle> BlogsArticleCreationTime(Date time, SearchParam searchParam) {
        BlogsarticleExample example=new BlogsarticleExample();
        example.createCriteria().andBlogsarticleDateEqualTo(time);
        //设置分页信息
        PageHelper.startPage(searchParam.getPageNum(), searchParam.getPageSize());
        //查询
        Page page = (Page) blogsarticleMapper.selectByExample(example);
        return new SearchResult<>(page.getTotal(), page.getResult());
    }
    //根据文章id查询文章标签id
    @Override
    public List<Blogandclassify> LableRelevanceLableid(int id) {
        BlogandclassifyExample example=new BlogandclassifyExample();
        example.createCriteria().andBlogsarticleIdEqualTo(id);
        return blogandclassifyMapper.selectByExample(example);
    }

    //保存文章信息
    @Override
    public int save(Blogsarticle blog) {
        int in=-1;
        blogsarticleMapper.insertstr(blog);
        in =blog.getBlogsarticleId();
        return in;
    }

    //修改文章信息
    @Override
    public boolean updateById(Blogsarticle blog) {
        boolean fal =false;
        int in = blogsarticleMapper.updateByPrimaryKey(blog);
        if (in!=0){
            fal=true;
        }
        return fal;
    }

    @Override
    public boolean removeById(int id) {
        boolean fal =false;
        int in =  blogsarticleMapper.deleteByPrimaryKey(id);
        if (in!=0){
            fal=true;
        }
        return fal;
    }

    //添加文章与标签关联信息
    @Override
    public boolean AddblogClassify(int blogid,int classid){
        boolean fal =false;
        int in =  blogandclassifyMapper.insert(new Blogandclassify(blogid,classid));
        if (in!=0){
            fal=true;
        }
        return fal;
    }

    //修改文章与标签关联信息
    @Override
    public boolean UpdablogClassify(int blogid,int classid) {
        boolean fal =false;
        int in =  blogandclassifyMapper.UpdablogClassKey(blogid,classid);
        if (in!=0){
            fal=true;
        }
        return fal;
    }

    @Override
    public boolean removeblogIdClass(int id) {

        boolean fal =false;
        int in = blogandclassifyMapper.deleteblogclass(id);
        if (in!=0){
            fal=true;
        }
        return fal;
    }

    //给文章添加一次浏览次数
    @Override
    public boolean AddBlogAccessnumber(int id) {
        blogsarticleMapper.AddBlogAccessnumber(id);
        return false;
    }
    //给文章点赞
    @Override
    public boolean AddBlogLikenumber(int id) {
        blogsarticleMapper.AddBlogLikenumber(id);
        return false;
    }
    //给文章回复数统计+1
    @Override
    public boolean AddBlogcommentnumber(int id) {
        blogsarticleMapper.AddBlogcommentnumber(id);
        return false;
    }

    @Override
    public boolean delBlogcommentnumber(int id,int number) {
        blogsarticleMapper.delBlogcommentnumber(id,number);
        return false;
    }
}
