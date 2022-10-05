package boke.boke.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户详细信息
 */
public class Userdatainfo implements Serializable {
    private Integer userinfoId;

    private Integer userId;

    private Date userTime;

    private Date userBirthdaydate;

    private String userEmail;

    private String userRelevance;

    private String userIntro;

    private String userImage;

    private String userBoki;

    private String userdatanames;

    public String getUserdatanames() {
        return userdatanames;
    }

    public void setUserdatanames(String userdatanames) {
        this.userdatanames = userdatanames;
    }

    private static final long serialVersionUID = 1L;

    public Integer getUserinfoId() {
        return userinfoId;
    }

    public void setUserinfoId(Integer userinfoId) {
        this.userinfoId = userinfoId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getUserTime() {
        return userTime;
    }

    public void setUserTime(Date userTime) {
        this.userTime = userTime;
    }

    public Date getUserBirthdaydate() {
        return userBirthdaydate;
    }

    public void setUserBirthdaydate(Date userBirthdaydate) {
        this.userBirthdaydate = userBirthdaydate;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserRelevance() {
        return userRelevance;
    }

    public void setUserRelevance(String userRelevance) {
        this.userRelevance = userRelevance == null ? null : userRelevance.trim();
    }

    public String getUserIntro() {
        return userIntro;
    }

    public void setUserIntro(String userIntro) {
        this.userIntro = userIntro == null ? null : userIntro.trim();
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage == null ? null : userImage.trim();
    }

    public String getUserBoki() {
        return userBoki;
    }

    public void setUserBoki(String userBoki) {
        this.userBoki = userBoki == null ? null : userBoki.trim();
    }
}