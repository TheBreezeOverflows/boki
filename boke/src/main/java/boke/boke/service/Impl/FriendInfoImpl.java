package boke.boke.service.Impl;

import boke.boke.entity.Comment;
import boke.boke.entity.CommentExample;
import boke.boke.entity.Friend;
import boke.boke.entity.FriendExample;
import boke.boke.entity.dto.CommentResult;
import boke.boke.entity.dto.SearchParam;
import boke.boke.entity.dto.SearchResult;
import boke.boke.mapper.FriendMapper;
import boke.boke.service.FriendInfo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class FriendInfoImpl implements FriendInfo {
    //依赖mapper
    @Autowired(required = false)
    private FriendMapper friendMapper;

    @Override
    public List<CommentResult<Friend>>  selectFriendmessage() {
        CommentResult<Friend> commentResult=null;
        List<CommentResult<Friend>> commentResultList=new ArrayList<CommentResult<Friend>>();
        Friend frie=null;
        Integer type=0;
        //查询友链的所有类型
        List<Integer> friendType = friendMapper.selectType();
        if (friendType.size()>0){
            for (Integer com:friendType) {
                FriendExample friendExample =new FriendExample();
                friendExample.createCriteria().andFriendTypeEqualTo(com);
                List<Friend> reply = friendMapper.selectByExample(friendExample);
                commentResult=new CommentResult<>();
                frie=new Friend();
                frie.setFriendType(com);
                commentResult.setData(frie);
                commentResult.setList(reply);
                commentResultList.add(commentResult);
            }
        }
        return commentResultList;
    }

    //后台分页查询友人帐信息
    @Override
    public SearchResult<Friend> AllFriendmessage(SearchParam searchParam) {
        //设置分页信息
        PageHelper.startPage(searchParam.getPageNum(), searchParam.getPageSize());
        FriendExample fri=new FriendExample();
        fri.setOrderByClause("Friend_type");
        List<Friend> brands =friendMapper.selectByExample(fri);
        //查询
        Page page =new Page();
        if (brands instanceof Page){
            page = (Page) brands;
            return new SearchResult<>(page.getTotal(), page.getResult());
        }
        return new SearchResult<Friend>((long)brands.size(),brands);
    }

    //根据名称查询
    @Override
    public SearchResult<Friend> commentNameifyIdInfo(SearchParam searchParam, String name) {
        PageHelper.clearPage();
        //设置分页信息
        PageHelper.startPage(searchParam.getPageNum(), searchParam.getPageSize());
        FriendExample fri=new FriendExample();
        fri.createCriteria().andFriendNameLike("%" +name+ "%");
        fri.setOrderByClause("Friend_type");
        List<Friend> brands = friendMapper.selectByExample(fri);
        //查询
        Page page =new Page();
        if (brands instanceof Page){
            page = (Page) brands;
            return new SearchResult<>(page.getTotal(), page.getResult());
        }
        return new SearchResult<Friend>((long)brands.size(),brands);
    }

    //添加友链
    @Override
    public boolean save(Friend friend) {
        boolean fal =false;
        int in =  friendMapper.insert(friend);
        if (in!=0){
            fal=true;
        }
        return fal;
    }
    //修改友人帐信息
    @Override
    public boolean updateByFriend(Friend friend) {
        boolean fal =false;
        int in =  friendMapper.updateByPrimaryKey(friend);
        if (in!=0){
            fal=true;
        }
        return fal;
    }

    //根据id删除友人帐信息
    @Override
    public boolean DelteFriendmessage(int id) {
        boolean fal =false;
        int in =  friendMapper.deleteByPrimaryKey(id);
        if (in!=0){
            fal=true;
        }
        return fal;
    }
}
