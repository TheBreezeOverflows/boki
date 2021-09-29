package boke.boke.entity;

import java.io.Serializable;
import java.util.Date;

public class Blogsarticle implements Serializable {
    private Integer blogsarticleId;

    private Integer blogsarticleUserId;

    private String blogsarticleHeadline;

    private Date blogsarticleDate;

    private String blogsarticleImage;

    private String blogsarticleContent;

    private String blogsarticleInformation;

    private String blogsarticleDetailedinformation;

    private Integer accessnumber;

    private Integer commentnumber;

    private String bloagUserNames;

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
}