package boke.boke.mapper;

import boke.boke.entity.Blogandclassify;
import boke.boke.entity.BlogandclassifyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlogandclassifyMapper {
    int countByExample(BlogandclassifyExample example);

    int deleteByExample(BlogandclassifyExample example);

    int insert(Blogandclassify record);

    int insertSelective(Blogandclassify record);

    List<Blogandclassify> selectByExample(BlogandclassifyExample example);

    int updateByExampleSelective(@Param("record") Blogandclassify record, @Param("example") BlogandclassifyExample example);

    int updateByExample(@Param("record") Blogandclassify record, @Param("example") BlogandclassifyExample example);
}