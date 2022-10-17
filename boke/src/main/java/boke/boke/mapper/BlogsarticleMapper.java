package boke.boke.mapper;

import boke.boke.entity.Blogandclassify;
import boke.boke.entity.Blogsarticle;
import boke.boke.entity.BlogsarticleExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BlogsarticleMapper {
    int countByExample(BlogsarticleExample example);

    int deleteByExample(BlogsarticleExample example);

    int deleteByPrimaryKey(Integer blogsarticleId);

    int insert(Blogsarticle record);

    int insertSelective(Blogsarticle record);

    List<Blogsarticle> selectByExample(BlogsarticleExample example);
    //根据用户id查询用户所编写的文章
    List<Blogsarticle> selectByExampleusername(BlogsarticleExample example);
    //根据列表id查询文章信息集合
    List<Blogsarticle> selectByClassifExample(Integer blogsarticleId);
    //根据文章名称查询文章信息集合
    List<Blogsarticle> selectByNameifExample(String name);

    Blogsarticle selectByPrimaryKey(Integer blogsarticleId);

    int updateByExampleSelective(@Param("record") Blogsarticle record, @Param("example") BlogsarticleExample example);

    int updateByExample(@Param("record") Blogsarticle record, @Param("example") BlogsarticleExample example);

    int updateByPrimaryKeySelective(Blogsarticle record);

    int updateByPrimaryKey(Blogsarticle record);

    int insertstr(Blogsarticle record);
    //根据文章id查询文章信息
    Blogsarticle selectByblogclasscontent(@Param("blogid") Integer blogid);
    //给文章添加一次浏览次数
    int AddBlogAccessnumber(@Param("blogid") int id);
    //给文章点赞
    int AddBlogLikenumber(@Param("blogid") int id);
    //给文章回复数统计加1
    int AddBlogcommentnumber(@Param("blogid") int id);
    //给文章回复数统计-n
    int delBlogcommentnumber(@Param("blogid") int id,@Param("number") int number);
}