package boke.boke.service;

import boke.boke.entity.Link;
import boke.boke.entity.dto.SearchParam;
import boke.boke.entity.dto.SearchResult;

public interface Linkinfo {

    //后台分页查询用户资源信息
    public SearchResult<Link> AllLinkdmessage(SearchParam searchParam);
    //根据名称查询
    public SearchResult<Link> commentNameifyIdInfo( SearchParam searchParam,String name);
    //添加友链
    public boolean save(Link link);
    //修改友人帐信息
    public boolean updateBylink(Link link);
    //根据id删除友人帐信息
    public boolean Deltelinkmessage(int id);
}
