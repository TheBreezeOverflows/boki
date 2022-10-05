package boke.boke.service.Impl;

import boke.boke.entity.Blogandclassify;
import boke.boke.entity.Classify;
import boke.boke.mapper.BlogandclassifyMapper;
import boke.boke.mapper.ClassifyMapper;
import boke.boke.service.ClassifyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClassifyInfoImpl implements ClassifyInfo {

    //依赖mapper
    @Autowired(required = false)
    private ClassifyMapper classifyMapper;
    @Autowired(required = false)
    private BlogandclassifyMapper blogandclassifyMapper;

    //查询默认显示的,状态为零的
    @Override
    public List<Classify> calssifyInfo() {
        return classifyMapper.selectByPrimarydatakey();
    }

    //查询当前文章的标签名称
    @Override
    public String selectByByPrimaryClassid(int id) {
        return classifyMapper.selectByByPrimaryClassname(id).getClassifyName();
    }
    //根据当前文章名称查询标签id
    @Override
    public int selectByByPrimaryClass(String name) {
        return classifyMapper.selectByByClassname(name).getClassifyId();
    }




}
