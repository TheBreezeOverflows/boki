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

    //根据文章id查询文章内容
    @Override
    public Blogsarticle BlogsArticleContentInfo(int id) {
        return blogsarticleMapper.selectByPrimaryKey(id);
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
}
