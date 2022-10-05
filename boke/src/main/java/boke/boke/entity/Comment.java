package boke.boke.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 评论管理
 */
public class Comment implements Serializable {
    //评论id
    private Integer commentId;
    //评论名称
    private String messageName;
    //评论人名称
    private String messageEmail;
    //评论人个人站点
    private String directSite;
    //评论时间
    private Date commentDate;
    //留言信息
    private String voiceMessage;
    //博客文章id
    private Integer blogsarticleId;
    //回复信息id(上级id)
    private Integer messageReply;

    private static final long serialVersionUID = 1L;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getMessageName() {
        return messageName;
    }

    public void setMessageName(String messageName) {
        this.messageName = messageName == null ? null : messageName.trim();
    }

    public String getMessageEmail() {
        return messageEmail;
    }

    public void setMessageEmail(String messageEmail) {
        this.messageEmail = messageEmail == null ? null : messageEmail.trim();
    }

    public String getDirectSite() {
        return directSite;
    }

    public void setDirectSite(String directSite) {
        this.directSite = directSite == null ? null : directSite.trim();
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public String getVoiceMessage() {
        return voiceMessage;
    }

    public void setVoiceMessage(String voiceMessage) {
        this.voiceMessage = voiceMessage == null ? null : voiceMessage.trim();
    }

    public Integer getBlogsarticleId() {
        return blogsarticleId;
    }

    public void setBlogsarticleId(Integer blogsarticleId) {
        this.blogsarticleId = blogsarticleId;
    }

    public Integer getMessageReply() {
        return messageReply;
    }

    public void setMessageReply(Integer messageReply) {
        this.messageReply = messageReply;
    }
}