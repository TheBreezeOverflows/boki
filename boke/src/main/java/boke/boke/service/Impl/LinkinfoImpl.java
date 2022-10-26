package boke.boke.service.Impl;

import boke.boke.entity.Friend;
import boke.boke.entity.FriendExample;
import boke.boke.entity.Link;
import boke.boke.entity.dto.SearchParam;
import boke.boke.entity.dto.SearchResult;
import boke.boke.mapper.LinkMapper;
import boke.boke.mapper.UserMapper;
import boke.boke.service.Linkinfo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkinfoImpl implements Linkinfo {
    //依赖mapper
    @Autowired(required = false)
    private LinkMapper linkMapper;

    @Autowired(required = false)
    private UserMapper userMapper;


    @Override
    public SearchResult<Link> AllLinkdmessage(SearchParam searchParam) {
        //设置分页信息
        PageHelper.startPage(searchParam.getPageNum(), searchParam.getPageSize());
        List<Link> brands =linkMapper.AllLinkdmessage();
        //查询
        Page page =new Page();
        if (brands instanceof Page){
            page = (Page) brands;
            return new SearchResult<>(page.getTotal(), page.getResult());
        }
        return new SearchResult<Link>((long)brands.size(),brands);
    }

    @Override
    public SearchResult<Link> commentNameifyIdInfo(SearchParam searchParam, String name) {
        //设置分页信息
        PageHelper.startPage(searchParam.getPageNum(), searchParam.getPageSize());
        List<Link> brands =linkMapper.commentNameifyIdInfo(name);
        //查询
        Page page =new Page();
        if (brands instanceof Page){
            page = (Page) brands;
            return new SearchResult<>(page.getTotal(), page.getResult());
        }
        return new SearchResult<Link>((long)brands.size(),brands);
    }

    @Override
    public boolean save(Link link) {
        boolean fal =false;
        int in =  linkMapper.insert(link);
        if (in!=0){
            fal=true;
        }
        return fal;
    }

    @Override
    public boolean updateBylink(Link link) {
        boolean fal =false;
        int in =  linkMapper.updateByPrimaryKey(link);
        if (in!=0){
            fal=true;
        }
        return fal;
    }

    @Override
    public boolean Deltelinkmessage(int id) {
        boolean fal =false;
        int in =  linkMapper.deleteByPrimaryKey(id);
        if (in!=0){
            fal=true;
        }
        return fal;
    }
}
