package boke.boke.controller;

import boke.boke.entity.Comment;
import boke.boke.entity.Friend;
import boke.boke.entity.dto.CommentResult;
import boke.boke.entity.dto.SearchParam;
import boke.boke.entity.dto.SearchResult;
import boke.boke.service.FriendInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 友人帐页面
 */
@RestController
@RequestMapping("/neighbor")
public class FriendController {

    //依赖mapper
    @Autowired
    private FriendInfo friendInfo;

    //查询留言板
    @GetMapping("/Friendmessage")
    @ResponseBody
    public List<CommentResult<Friend>> selectblogmessage(){
        return friendInfo.selectFriendmessage();
    }

    //后台
    //查询所有评论
    @GetMapping("/AllFriendmessage")
    @ResponseBody
    public  SearchResult selectAllFriend(SearchParam params){
        return friendInfo.AllFriendmessage(params);
    }
    //根据名称信息查询信息
    @GetMapping("/NamePage")
    @ResponseBody
    public SearchResult NamefindPage(SearchParam para,String search){
        SearchResult<Friend> CommentSearchResult = friendInfo.commentNameifyIdInfo(para,search);;
        return CommentSearchResult;
    }

    //添加批评论
    @PostMapping("/FriendOper")
    @ResponseBody
    public SearchResult<?> save(@RequestBody Friend friend){
        boolean flg =friendInfo.save(friend);
        if (flg){
            return SearchResult.success();
        }
        return SearchResult.success("500");
    }

    //修改评论
    @PutMapping("/FriendOper")
    @ResponseBody
    public SearchResult<?> update(@RequestBody Friend friend){
        boolean flg = friendInfo.updateByFriend(friend);
        if (flg){
            return SearchResult.success();
        }
        return SearchResult.success("500");
    }

    //删除评论
    @GetMapping("/delteComment")
    @ResponseBody
    public SearchResult<?> deleteFriend(int id) {
        System.out.print("id="+id);
        friendInfo.DelteFriendmessage(id);
        return SearchResult.success();
    }

}
