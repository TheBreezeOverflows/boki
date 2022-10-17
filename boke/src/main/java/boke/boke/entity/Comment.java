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
    //评论人邮箱
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
    //回复的人的名称
    private String messageReplyName;
    //审核留言板页面才有(0不通过，1通过)
    private Integer commentAudit;
    //头像路径
    private String headPortrait;

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


    public String getMessageReplyName() {
        return messageReplyName;
    }

    public Integer getCommentAudit() {
        return commentAudit;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setMessageReplyName(String messageReplyName) {
        this.messageReplyName = messageReplyName;
    }

    public void setCommentAudit(Integer commentAudit) {
        this.commentAudit = commentAudit;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }
}