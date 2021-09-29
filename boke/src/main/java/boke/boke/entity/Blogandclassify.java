package boke.boke.entity;

import java.io.Serializable;

public class Blogandclassify implements Serializable {
    private Integer blogsarticleId;

    private Integer classifyId;

    private static final long serialVersionUID = 1L;

    public Integer getBlogsarticleId() {
        return blogsarticleId;
    }

    public void setBlogsarticleId(Integer blogsarticleId) {
        this.blogsarticleId = blogsarticleId;
    }

    public Integer getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(Integer classifyId) {
        this.classifyId = classifyId;
    }
}