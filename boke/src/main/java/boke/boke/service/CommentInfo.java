package boke.boke.service;

import boke.boke.entity.Comment;
import boke.boke.entity.dto.CommentResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CommentInfo {
    //根据文章id搜索回复信息
    List<CommentResult<Comment>> selectCommentblog(int blogId);
    //根据父级id搜索回复信息
    List<Comment> selectCommentparent(int ReplyId,List<Comment> comments);
    boolean AddCommentparent(Comment comment);
}
