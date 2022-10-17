package boke.boke.entity;

import java.io.Serializable;

/**
 * 友人帐
 */
public class Friend implements Serializable {
    //编号
    private Integer friendId;
    //名称
    private String friendName;
    //介绍
    private String selfIntroduce;
    //博客地址
    private String directSite;
    //头像路径
    private String portrait;
    //分类
    private Integer friendType;

    private static final long serialVersionUID = 1L;

    public Integer getFriendId() {
        return friendId;
    }

    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName == null ? null : friendName.trim();
    }

    public String getSelfIntroduce() {
        return selfIntroduce;
    }

    public void setSelfIntroduce(String selfIntroduce) {
        this.selfIntroduce = selfIntroduce == null ? null : selfIntroduce.trim();
    }

    public String getDirectSite() {
        return directSite;
    }

    public void setDirectSite(String directSite) {
        this.directSite = directSite == null ? null : directSite.trim();
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait == null ? null : portrait.trim();
    }

    public void setFriendType(Integer friendType) {
        this.friendType = friendType;
    }

    public Integer getFriendType() {
        return friendType;
    }
}