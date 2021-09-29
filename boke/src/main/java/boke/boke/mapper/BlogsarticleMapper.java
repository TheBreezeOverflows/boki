package boke.boke.mapper;

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

    Blogsarticle selectByPrimaryKey(Integer blogsarticleId);

    int updateByExampleSelective(@Param("record") Blogsarticle record, @Param("example") BlogsarticleExample example);

    int updateByExample(@Param("record") Blogsarticle record, @Param("example") BlogsarticleExample example);

    int updateByPrimaryKeySelective(Blogsarticle record);

    int updateByPrimaryKey(Blogsarticle record);
}