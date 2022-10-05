package boke.boke.entity;

import java.io.Serializable;

/**
 *文章分类关联表
 */
public class Blogandclassify implements Serializable {
    private Integer blogsarticleId;

    private Integer classifyId;

    private static final long serialVersionUID = 1L;

    public Blogandclassify(Integer blogsarticleId, Integer classifyId) {
        this.blogsarticleId = blogsarticleId;
        this.classifyId = classifyId;
    }

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