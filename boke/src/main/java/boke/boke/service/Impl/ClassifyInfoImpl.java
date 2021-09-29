package boke.boke.service.Impl;

import boke.boke.entity.Classify;
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

    //查询默认显示的,状态为零的
    @Override
    public List<Classify> calssifyInfo() {
        return classifyMapper.selectByPrimarydatakey();
    }
}
