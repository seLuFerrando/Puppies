package com.selumobileapps.puppies.database;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.selumobileapps.puppies.model.InstagramUserID;

/**
 * Created by selu on 11/12/16.
 */

public class Preferences {
    private SharedPreferences prefs = null;
    private Editor editor = null;
    private InstagramUserID instagramUserID;
    private String id;
    private String userName;
    private String fullName;
    private String imgProfile;

    public Preferences(Context context){
        prefs = context.getSharedPreferences("User_Preferences", Context.MODE_PRIVATE);
        editor = prefs.edit();

    }

    public InstagramUserID getInstagramUserID() {
        instagramUserID = new InstagramUserID(getId(), getUserName(), getFullName(), getImgProfile());
        return instagramUserID;
    }

    public void setInstagramUserID(InstagramUserID instagramUserID) {
        editor.putString("ID" ,instagramUserID.getId());
        editor.putString("USERNAME", instagramUserID.getUserName());
        editor.putString("FULLNAME", instagramUserID.getFullName());
        editor.putString("IMAGEPROFILE", instagramUserID.getImgProfile());
        editor.commit();
    }

    public String getId() {
        return prefs.getString("ID", "2622532309");
    }

    public void setId(String id) {
        editor.putString("ID", id);
        editor.commit();
    }

    public String getUserName() {
        return prefs.getString("USERNAME", "seluferrando");
    }

    public void setUserName(String userName) {
        editor.putString("USERNAME", userName);
        editor.commit();
    }

    public String getFullName() {
        return prefs.getString("FULLNAME", "seLu Ferrando");
    }

    public void setFullName(String fullName) {
        editor.putString("FULLNAME", fullName);
        editor.commit();
    }

    public String getImgProfile() {
        return prefs.getString("IMAGEPROFILE", "https://scontent.cdninstagram.com/t51.2885-19/s150x150/15276768_1288005131272341_6274475786665721856_a.jpg");
    }

    public void setImgProfile(String imgProfile) {
        editor.putString("IMAGEPROFILE", imgProfile);
        editor.commit();
    }

}
