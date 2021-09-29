package boke.boke.mapper;

import boke.boke.entity.Userdatainfo;
import boke.boke.entity.UserdatainfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserdatainfoMapper {
    int countByExample(UserdatainfoExample example);

    int deleteByExample(UserdatainfoExample example);

    int deleteByPrimaryKey(Integer userinfoId);

    int insert(Userdatainfo record);

    int insertSelective(Userdatainfo record);

    List<Userdatainfo> selectByExample(UserdatainfoExample example);

    Userdatainfo selectByPrimaryKey(Integer userinfoId);

    Userdatainfo selectByusernamePrimaryKey(Integer userinfoId);

    int updateByExampleSelective(@Param("record") Userdatainfo record, @Param("example") UserdatainfoExample example);

    int updateByExample(@Param("record") Userdatainfo record, @Param("example") UserdatainfoExample example);

    int updateByPrimaryKeySelective(Userdatainfo record);

    int updateByPrimaryKey(Userdatainfo record);
}