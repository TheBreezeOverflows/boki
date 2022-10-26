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
    //查询当前文章的标签id
    Blogandclassify selectByByPrimaryClassid(int id);
    //修改文章id
    int UpdablogClassKey(@Param("blogid") int blogid, @Param("classid") int classid);
    //删除当前文章与标签关联
    int deleteblogclass(@Param("blogid") int blogid);
    //因大标签变小标签所修改标签id
    int UpdaClassByid(@Param("classid") int blogid, @Param("alterid") int alterid);
}