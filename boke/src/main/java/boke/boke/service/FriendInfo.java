package boke.boke.service;

import boke.boke.entity.Comment;
import boke.boke.entity.Friend;
import boke.boke.entity.dto.CommentResult;
import boke.boke.entity.dto.SearchParam;
import boke.boke.entity.dto.SearchResult;

import java.util.List;

public interface FriendInfo {
    //查询友人帐信息
    List<CommentResult<Friend>> selectFriendmessage();
    //后台分页查询友人帐信息
    public SearchResult<Friend> AllFriendmessage(SearchParam searchParam);
    //根据名称查询
    public SearchResult<Friend> commentNameifyIdInfo( SearchParam searchParam,String name);
    //添加友链
    public boolean save(Friend friend);
    //修改友人帐信息
    public boolean updateByFriend(Friend friend);
    //根据id删除友人帐信息
    public boolean DelteFriendmessage(int id);

}
