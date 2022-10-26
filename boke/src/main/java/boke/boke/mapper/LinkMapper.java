package boke.boke.mapper;

import boke.boke.entity.Link;
import boke.boke.entity.LinkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LinkMapper {
    int countByExample(LinkExample example);

    int deleteByExample(LinkExample example);

    int deleteByPrimaryKey(Integer linkId);

    int insert(Link record);

    int insertSelective(Link record);

    List<Link> selectByExample(LinkExample example);

    Link selectByPrimaryKey(Integer linkId);

    int updateByExampleSelective(@Param("record") Link record, @Param("example") LinkExample example);

    int updateByExample(@Param("record") Link record, @Param("example") LinkExample example);

    int updateByPrimaryKeySelective(Link record);

    int updateByPrimaryKey(Link record);
    //根据用户编号查询关联资源
    List<Link> selectByUserType(@Param("usertype") int usertype);
    //分页查询用户资源信息
    List<Link> AllLinkdmessage();
    //根据名称分页查询用户资源信息
    List<Link> commentNameifyIdInfo(String name);
}