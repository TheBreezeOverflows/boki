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
    Classify selectByByPrimaryClassname(int id);
    //根据当前文章名称查询标签id
    Classify selectByByClassname(@Param("classname") String name);
}