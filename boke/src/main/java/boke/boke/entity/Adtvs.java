package boke.boke.entity;

import java.io.Serializable;

public class Adtvs implements Serializable {
    private Integer advtsId;

    private String advtsImagepath;

    private String adtvsPath;

    private String adtvsIntroduced;

    private static final long serialVersionUID = 1L;

    public Integer getAdvtsId() {
        return advtsId;
    }

    public void setAdvtsId(Integer advtsId) {
        this.advtsId = advtsId;
    }

    public String getAdvtsImagepath() {
        return advtsImagepath;
    }

    public void setAdvtsImagepath(String advtsImagepath) {
        this.advtsImagepath = advtsImagepath == null ? null : advtsImagepath.trim();
    }

    public String getAdtvsPath() {
        return adtvsPath;
    }

    public void setAdtvsPath(String adtvsPath) {
        this.adtvsPath = adtvsPath == null ? null : adtvsPath.trim();
    }

    public String getAdtvsIntroduced() {
        return adtvsIntroduced;
    }

    public void setAdtvsIntroduced(String adtvsIntroduced) {
        this.adtvsIntroduced = adtvsIntroduced == null ? null : adtvsIntroduced.trim();
    }
}