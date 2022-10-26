package boke.boke.mapper;

import boke.boke.entity.Blogandclassify;
import boke.boke.entity.Classify;
import boke.boke.entity.ClassifyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassifyMapper {
    int countByExample(ClassifyExample example);

    int deleteByExample(ClassifyExample example);

    int deleteByPrimaryKey(Integer classifyId);

    int insert(Classify record);

    int insertSelective(Classify record);

    List<Classify> selectByExample(ClassifyExample example);

    Classify selectByPrimaryKey(Integer classifyId);

    int updateByExampleSelective(@Param("record") Classify record, @Param("example") ClassifyExample example);

    int updateByExample(@Param("record") Classify record, @Param("example") ClassifyExample example);

    int updateByPrimaryKeySelective(Classify record);

    int updateByPrimaryKey(Classify record);
    //查询状态为零的数据
    List<Classify> selectByPrimarydatakey();
    //查询当前文章的标签id
    Classify selectByByPrimaryClassname(@Param("blogsarticleId") int id);
    //查询当前文章的标签-大标签
    Classify selectByByPrimaryClassbigname(@Param("blogsarticleId") int id);
    //根据当前名称与id查询是否有重复的数据
    Integer selectByClassnameid(@Param("classname") String name, @Param("classid") int id);
    //根据当前文章名称查询标签id
    Classify selectByByClassname(@Param("classname") String name);
    //根据上级id修改上级标签名称
    int  updatetagnameByid(@Param("classupname") String name, @Param("classupid") int id);
    //根据上级id修改上级标签名称和id
    int  updatetagnameandid(@Param("classupname") String name, @Param("classupid") int id,@Param("alterid") int alterid);
    //根据标签名称查询标签id
    Integer selectByclassName(@Param("classname") String name);
}