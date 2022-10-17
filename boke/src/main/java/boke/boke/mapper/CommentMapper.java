package boke.boke.mapper;

import boke.boke.entity.Comment;
import boke.boke.entity.CommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentMapper {
    int countByExample(CommentExample example);

    int deleteByExample(CommentExample example);

    int deleteByPrimaryKey(Integer commentId);

    int insert(Comment record);

    int insertSelective(Comment record);

    List<Comment> selectByExample(CommentExample example);

    Comment selectByPrimaryKey(Integer commentId);

    int updateByExampleSelective(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByExample(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
    //根据文章id搜索回复信息
    List<Comment> selectCommentblogExample(@Param("blogId") Integer blogId);
    //查询留言板页面信息
    List<Comment> selectBlogMessageExample();
    //根据父级id搜索回复信息
    List<Comment> selectCommentparentExample(@Param("ReplyId") Integer ReplyId);
    //根据父级id搜索回复信息
    List<Comment> selectMessageparentExample(@Param("ReplyId") Integer ReplyId);
    //查询子评论信息
    public int selCommentmessageslave(@Param("commentid") int id);
    //删除子评论信息
    public int DelteCommentmessageslave(@Param("commentid") int id);
    //修改文章审核状态
    int updateByAuditComment(@Param("commentid") int commentid);
}