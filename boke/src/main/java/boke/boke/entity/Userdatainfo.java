package boke.boke.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户详细信息
 */
public class Userdatainfo implements Serializable {
    //编号
    private Integer userinfoId;
    //用户表关联id
    private Integer userId;
    //注册时间
    private Date userTime;
    //用户出生日期
    private Date userBirthdaydate;
    //用户邮箱
    private String userEmail;
    //用户资源标签(json格式)
    private List<Link> userRelevance;
    //个人介绍
    private String userIntro;
    //用户主页图片
    private String userImage;
    //用户个人博客路径
    private String userBoki;
    //用户名称(数据库中不存在)
    private String userdatanames;
    //权限
    private String userpermission;
    //修改的密码
    private String userPassword;

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

    public List<Link> getUserRelevance() {
        return userRelevance;
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

    public String getUserpermission() {
        return userpermission;
    }

    public void setUserpermission(String userpermission) {
        this.userpermission = userpermission;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserRelevance(List<Link> userRelevance) {
        this.userRelevance = userRelevance;
    }
}