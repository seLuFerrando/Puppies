package com.selumobileapps.puppies.model;

/**
 * Created by selu on 11/12/16.
 */

public class InstagramUserID {
    private String id;
    private String userName;
    private String fullName;
    private String imgProfile;

    public InstagramUserID(){

    }

    public InstagramUserID(String id, String userName, String fullName, String imgProfile){
        this.id = id;
        this.userName = userName;
        this.fullName = fullName;
        this.imgProfile = imgProfile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getImgProfile() {
        return imgProfile;
    }

    public void setImgProfile(String imgProfile) {
        this.imgProfile = imgProfile;
    }
}
