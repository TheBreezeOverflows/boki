package boke.boke.service;

import boke.boke.entity.Classify;

import java.util.List;

public interface ClassifyInfo {
    //查询默认显示的,状态为零的
    public List<Classify> calssifyInfo();
}
