package boke.boke.entity;

import java.io.Serializable;

/**
 * 用户账号信息
 */
public class User implements Serializable {
    //用户编号
    private Integer userId;
    //名称
    private String userName;
    //密码
    private String userUserPassword;
    //权限
    private String permission;
    //用户详细信息
    private Userdatainfo userdatainfo;

    private static final long serialVersionUID = 1L;

    public void setUserdatainfo(Userdatainfo userdatainfo){
        this.userdatainfo=userdatainfo;
    }
    public Userdatainfo getUserdatainfo(){
        return userdatainfo;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserUserPassword() {
        return userUserPassword;
    }

    public void setUserUserPassword(String userUserPassword) {
        this.userUserPassword = userUserPassword == null ? null : userUserPassword.trim();
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }
}