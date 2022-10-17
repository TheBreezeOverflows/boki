package boke.boke.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 博客文章信息
 */
public class Blogsarticle implements Serializable {
    //博文id
    private Integer blogsarticleId;
    //发布用户id
    private Integer blogsarticleUserId;
    //博文标题
    private String blogsarticleHeadline;
    //发布时间
    private Date blogsarticleDate;
    //显示图片(JSON格式存储文章所有图片)
    private String blogsarticleImage;
    //博文内容
    private String blogsarticleContent;
    //跳转连接(没什么用就用来存储标签了)
    private String blogsarticleInformation;
    //博客文章详细信息
    private String blogsarticleDetailedinformation;
    //浏览数
    private Integer accessnumber;
    //回复数
    private Integer commentnumber;
    //文章作者
    private String bloagUserNames;
    //点赞
    private Integer likenumber;

    public String getBloagUserNames() {
        return bloagUserNames;
    }

    public void setBloagUserNames(String bloagUserNames) {
        this.bloagUserNames = bloagUserNames;
    }

    private static final long serialVersionUID = 1L;

    public Integer getBlogsarticleId() {
        return blogsarticleId;
    }

    public void setBlogsarticleId(Integer blogsarticleId) {
        this.blogsarticleId = blogsarticleId;
    }

    public Integer getBlogsarticleUserId() {
        return blogsarticleUserId;
    }

    public void setBlogsarticleUserId(Integer blogsarticleUserId) {
        this.blogsarticleUserId = blogsarticleUserId;
    }

    public String getBlogsarticleHeadline() {
        return blogsarticleHeadline;
    }

    public void setBlogsarticleHeadline(String blogsarticleHeadline) {
        this.blogsarticleHeadline = blogsarticleHeadline == null ? null : blogsarticleHeadline.trim();
    }

    public Date getBlogsarticleDate() {
        return blogsarticleDate;
    }

    public void setBlogsarticleDate(Date blogsarticleDate) {
        this.blogsarticleDate = blogsarticleDate;
    }

    public String getBlogsarticleImage() {
        return blogsarticleImage;
    }

    public void setBlogsarticleImage(String blogsarticleImage) {
        this.blogsarticleImage = blogsarticleImage == null ? null : blogsarticleImage.trim();
    }

    public String getBlogsarticleContent() {
        return blogsarticleContent;
    }

    public void setBlogsarticleContent(String blogsarticleContent) {
        this.blogsarticleContent = blogsarticleContent == null ? null : blogsarticleContent.trim();
    }

    public String getBlogsarticleInformation() {
        return blogsarticleInformation;
    }

    public void setBlogsarticleInformation(String blogsarticleInformation) {
        this.blogsarticleInformation = blogsarticleInformation == null ? null : blogsarticleInformation.trim();
    }

    public String getBlogsarticleDetailedinformation() {
        return blogsarticleDetailedinformation;
    }

    public void setBlogsarticleDetailedinformation(String blogsarticleDetailedinformation) {
        this.blogsarticleDetailedinformation = blogsarticleDetailedinformation == null ? null : blogsarticleDetailedinformation.trim();
    }

    public Integer getAccessnumber() {
        return accessnumber;
    }

    public void setAccessnumber(Integer accessnumber) {
        this.accessnumber = accessnumber;
    }

    public Integer getCommentnumber() {
        return commentnumber;
    }

    public void setCommentnumber(Integer commentnumber) {
        this.commentnumber = commentnumber;
    }

    public Integer getLikenumber() {
        return likenumber;
    }

    public void setLikenumber(Integer likenumber) {
        this.likenumber = likenumber;
    }
}