package boke.boke.service.Impl;

import boke.boke.entity.Comment;
import boke.boke.entity.dto.CommentResult;
import boke.boke.mapper.CommentMapper;
import boke.boke.service.CommentInfo;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentInfoImpl implements CommentInfo {
    //依赖mapper
    @Autowired(required = false)
    private CommentMapper commentMapper;

    public CommentInfoImpl(){
    }


    @Override
    public List<CommentResult<Comment>> selectCommentblog(int blogId) {
        CommentResult<Comment> commentResult=null;
        List<CommentResult<Comment>> commentResultList=new ArrayList<>();
        //根据文章id查询到本篇文章所有的父级评论
        List<Comment> comfather = commentMapper.selectCommentblogExample(blogId);
        //根据父级评论查询底下的回复型评论
        for (Comment com:comfather) {
            List<Comment> comments=new ArrayList<>();
            List<Comment> reply = selectCommentparent(com.getCommentId(),comments);
            commentResult=new CommentResult<>();
            String comJson = JSON.toJSONString(com);
            commentResult.setData(com);
            commentResult.setList(reply);
            commentResultList.add(commentResult);
        }
        
        return commentResultList;
    }

    @Override
    public List<Comment> selectCommentparent(int ReplyId,List<Comment> comments) {
        //查询当前层级的数据
        List<Comment> comme1 = commentMapper.selectCommentparentExample(ReplyId);
        comments.addAll(comme1);
        //判断当传入前父id是否有子数据,有则再调用查看是否有下层
        int size = comme1.size();
        if (size>0){
            //循环调用
            for (Comment com:comme1) {
                this.selectCommentparent(com.getCommentId(),comments);
            }
        }
        return comments;
    }

    @Override
    public boolean AddCommentparent(Comment comment) {
        boolean fal =false;
        int in = commentMapper.insert(comment);
        if (in!=0){
            fal=true;
        }
        return fal;
    }
}
