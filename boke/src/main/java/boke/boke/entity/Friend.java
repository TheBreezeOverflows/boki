package boke.boke.entity;

import java.io.Serializable;

/**
 * 友人帐
 */
public class Friend implements Serializable {
    private Integer friendId;

    private String friendName;

    private String selfIntroduce;

    private String directSite;

    private String portrait;

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
}