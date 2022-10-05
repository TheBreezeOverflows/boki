package boke.boke.entity;

import java.io.Serializable;

/**
 * 项目展示
 */
public class Project implements Serializable {
    private Integer projectId;

    private String projectName;

    private String projectIntroduce;

    private String projectShow;

    private Integer projectStaic;

    private static final long serialVersionUID = 1L;

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getProjectIntroduce() {
        return projectIntroduce;
    }

    public void setProjectIntroduce(String projectIntroduce) {
        this.projectIntroduce = projectIntroduce == null ? null : projectIntroduce.trim();
    }

    public String getProjectShow() {
        return projectShow;
    }

    public void setProjectShow(String projectShow) {
        this.projectShow = projectShow == null ? null : projectShow.trim();
    }

    public Integer getProjectStaic() {
        return projectStaic;
    }

    public void setProjectStaic(Integer projectStaic) {
        this.projectStaic = projectStaic;
    }
}