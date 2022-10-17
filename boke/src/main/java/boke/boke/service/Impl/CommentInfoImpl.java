package boke.boke.service.Impl;

import boke.boke.controller.pHelper;
import boke.boke.entity.Comment;
import boke.boke.entity.CommentExample;
import boke.boke.entity.dto.CommentResult;
import boke.boke.entity.dto.SearchParam;
import boke.boke.entity.dto.SearchResult;
import boke.boke.mapper.CommentMapper;
import boke.boke.service.CommentInfo;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public SearchResult<CommentResult<Comment>> selectCommentblog(SearchParam searchParam, int blogId) {
        CommentResult<Comment> commentResult=null;
        List<CommentResult<Comment>> commentResultList=new ArrayList<CommentResult<Comment>>();
        //根据文章id查询到本篇文章所有的父级评论
        List<Comment> comfather = commentMapper.selectCommentblogExample(blogId);
        //根据父级评论查询底下的回复型评论
        for (Comment com:comfather) {
            List<Comment> comments=new ArrayList<>();
            List<Comment> reply = selectCommentparent(0,com.getCommentId(),comments);
            commentResult=new CommentResult<>();
            //String comJson = JSON.toJSONString(com);
            commentResult.setData(com);
            commentResult.setList(reply);
            commentResultList.add(commentResult);
        }
        PageInfo<?> pageInfo = pHelper.pageHelper(commentResultList, searchParam.getPageNum(), searchParam.getPageSize());
        return new SearchResult<>(pageInfo.getTotal(),pageInfo.getList());
    }

    //留言栏
    @Override
    public SearchResult<CommentResult<Comment>> selectblogmessage(SearchParam searchParam) {
        CommentResult<Comment> commentResult=null;
        List<CommentResult<Comment>> commentResultList=new ArrayList<>();
        //根据文章id查询到本篇文章所有的父级评论
        List<Comment> comfather = commentMapper.selectBlogMessageExample();
        //根据父级评论查询底下的回复型评论
        for (Comment com:comfather) {
            List<Comment> comments=new ArrayList<>();
            List<Comment> reply = selectCommentparent(1,com.getCommentId(),comments);
            commentResult=new CommentResult<>();
            //String comJson = JSON.toJSONString(com);
            commentResult.setData(com);
            commentResult.setList(reply);
            commentResultList.add(commentResult);
        }
        PageInfo<?> pageInfo = pHelper.pageHelper(commentResultList, searchParam.getPageNum(), searchParam.getPageSize());
        return new SearchResult<>(pageInfo.getTotal(),pageInfo.getList());
    }

    @Override
    public List<Comment> selectCommentparent(int audit,int ReplyId,List<Comment> comments) {
        List<Comment> comme1 =new ArrayList<>();
        //查询当前层级的数据
        if (audit==1){
            comme1 = commentMapper.selectMessageparentExample(ReplyId);
        }else {
            comme1 =  commentMapper.selectCommentparentExample(ReplyId);
        }

        comments.addAll(comme1);
        //判断当传入前父id是否有子数据,有则再调用查看是否有下层
        int size = comme1.size();
        if (size>0){
            //循环调用
            for (Comment com:comme1) {
                this.selectCommentparent(audit,com.getCommentId(),comments);
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

    //查询所有评论
    @Override
    public SearchResult<Comment> AllCommentmessage(SearchParam searchParam) {
        PageHelper.clearPage();
        //设置分页信息
        PageHelper.startPage(searchParam.getPageNum(), searchParam.getPageSize());
        CommentExample com=new CommentExample();
        com.setOrderByClause("Comment_audit,Comment_id");
        List<Comment> brands = commentMapper.selectByExample(com);
        //查询
        Page page =new Page();
        if (brands instanceof Page){
            page = (Page) brands;
            return new SearchResult<>(page.getTotal(), page.getResult());
        }
        return new SearchResult<Comment>((long)brands.size(),brands);
    }

    @Override
    public SearchResult<Comment> commentNameifyIdInfo(SearchParam searchParam, String name) {
        PageHelper.clearPage();
        //设置分页信息
        PageHelper.startPage(searchParam.getPageNum(), searchParam.getPageSize());
        CommentExample com=new CommentExample();
        com.createCriteria().andVoiceMessageLike("%" +name+ "%");
        com.setOrderByClause("Comment_audit");
        List<Comment> brands = commentMapper.selectByExample(com);
        //查询
        Page page =new Page();
        if (brands instanceof Page){
            page = (Page) brands;
            return new SearchResult<>(page.getTotal(), page.getResult());
        }
        return new SearchResult<Comment>((long)brands.size(),brands);
    }

    //删除评论
    @Override
    public int DelteCommentmessage(int id) {
        int fal =0;
        int in =  commentMapper.deleteByPrimaryKey(id);
        if (in!=0){
            //查询子评论信息
            int selectslave = commentMapper.selCommentmessageslave(id);
            if (selectslave>0){
                //删除子评论信息
                int delslave = commentMapper.DelteCommentmessageslave(id);
                if (delslave>0){
                    fal=selectslave+1;
                }
            }else {
                fal=1;
            }
        }
        return fal;
    }
    //审核
    @Override
    public boolean AuditCommentmessage(int id) {
        boolean fal =false;
        int in = commentMapper.updateByAuditComment(id);
        if (in!=0){
            fal=true;
        }
        return fal;
    }
}
