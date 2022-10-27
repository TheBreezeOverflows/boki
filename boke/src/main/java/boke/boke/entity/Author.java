package boke.boke.entity;

import java.io.Serializable;

public class Author implements Serializable {
    private Integer authorId;

    private String authorContent;

    private Integer authorUser;

    private static final long serialVersionUID = 1L;

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getAuthorContent() {
        return authorContent;
    }

    public void setAuthorContent(String authorContent) {
        this.authorContent = authorContent == null ? null : authorContent.trim();
    }

    public Integer getAuthorUser() {
        return authorUser;
    }

    public void setAuthorUser(Integer authorUser) {
        this.authorUser = authorUser;
    }
}