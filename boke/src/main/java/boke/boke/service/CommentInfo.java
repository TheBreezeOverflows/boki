package boke.boke.service;

import boke.boke.entity.Comment;
import boke.boke.entity.dto.SearchParam;
import boke.boke.entity.dto.SearchResult;
import boke.boke.entity.dto.CommentResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CommentInfo {
    //根据文章id搜索回复信息
    SearchResult<CommentResult<Comment>> selectCommentblog(SearchParam searchParam,int blogId);
    //查询留言板
    SearchResult<CommentResult<Comment>> selectblogmessage(SearchParam searchParam);
    //根据父级id搜索回复信息
    List<Comment> selectCommentparent(int audit,int ReplyId,List<Comment> comments);
    //发布评论
    boolean AddCommentparent(Comment comment);
    //查询所有评论
    public SearchResult<Comment> AllCommentmessage(SearchParam searchParam);
    //根据评论内容搜寻评论
    public SearchResult<Comment> commentNameifyIdInfo( SearchParam searchParam,String name);
    //删除评论
    public int DelteCommentmessage(int id);
    //审核
    public boolean AuditCommentmessage(int id);

}
