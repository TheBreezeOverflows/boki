package boke.boke.service;

import boke.boke.entity.Classify; 
import boke.boke.entity.dto.SearchParam;
import boke.boke.entity.dto.SearchResult;

import java.util.List;

public interface ClassifyInfo {
    //查询默认显示的,状态为零的
    public List<Classify> calssifyInfo();
    //查询默认显示的,状态为零的
    public List<Classify> calssifyInfos();
    //查询当前文章的标签名称
    public String selectByByPrimaryClassid(int id);
    //查询当前文章的标签id
    Classify selectByByPrimaryClass(String name);
    //分页查询所有标签
    public SearchResult<Classify> AllClassMessage(SearchParam searchParam);
    //根据名称分页查询所有标签
    public SearchResult<Classify> AllClassNameMessage(SearchParam searchParam,String name);
    //修改类型标签
    public boolean updatebigByClass(Classify classdatainfo);
    //修改标签
    public boolean updateByClass(Classify classdatainfo);
    //保存标签
    public boolean saveByClass(Classify classdatainfo);
    //删除标签
    public boolean DelteByClassMessage(int id);

}
