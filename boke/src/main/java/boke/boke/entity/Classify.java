package boke.boke.entity;

import java.io.Serializable;

public class Classify implements Serializable {
    private Integer classifyId;

    private String classifyName;

    private String classifyCategory;

    private Integer superclassId;

    private static final long serialVersionUID = 1L;

    public Integer getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(Integer classifyId) {
        this.classifyId = classifyId;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName == null ? null : classifyName.trim();
    }

    public String getClassifyCategory() {
        return classifyCategory;
    }

    public void setClassifyCategory(String classifyCategory) {
        this.classifyCategory = classifyCategory == null ? null : classifyCategory.trim();
    }

    public Integer getSuperclassId() {
        return superclassId;
    }

    public void setSuperclassId(Integer superclassId) {
        this.superclassId = superclassId;
    }
}