package com.selumobileapps.puppies.restAPI.model;

import com.selumobileapps.puppies.model.InstagramUserID;

import java.util.ArrayList;

/**
 * Created by selu on 11/12/16.
 */

public class InstagramUserIDResponse {

    ArrayList<InstagramUserID> instagramUserID;

    public ArrayList<InstagramUserID> getInstagramUserID() {
        return instagramUserID;
    }

    public void setInstagramUserID(ArrayList<InstagramUserID> instagramUserID) {
        this.instagramUserID = instagramUserID;
    }

}
