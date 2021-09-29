package boke.boke.mapper;

import boke.boke.entity.Adtvs;
import boke.boke.entity.AdtvsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdtvsMapper {
    int countByExample(AdtvsExample example);

    int deleteByExample(AdtvsExample example);

    int deleteByPrimaryKey(Integer advtsId);

    int insert(Adtvs record);

    int insertSelective(Adtvs record);

    List<Adtvs> selectByExample(AdtvsExample example);

    Adtvs selectByPrimaryKey(Integer advtsId);

    int updateByExampleSelective(@Param("record") Adtvs record, @Param("example") AdtvsExample example);

    int updateByExample(@Param("record") Adtvs record, @Param("example") AdtvsExample example);

    int updateByPrimaryKeySelective(Adtvs record);

    int updateByPrimaryKey(Adtvs record);
}