package boke.boke.service;

import boke.boke.entity.Classify;

import java.util.List;

public interface ClassifyInfo {
    //查询默认显示的,状态为零的
    public List<Classify> calssifyInfo();
    //查询当前文章的标签名称
    public String selectByByPrimaryClassid(int id);
    //查询当前文章的标签id
    int selectByByPrimaryClass(String name);

}
