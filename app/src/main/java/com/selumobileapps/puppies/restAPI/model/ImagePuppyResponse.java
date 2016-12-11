package com.selumobileapps.puppies.restAPI.model;

import com.selumobileapps.puppies.model.ImagePuppy;

import java.util.ArrayList;

/**
 * Created by selu on 11/12/16.
 */

public class ImagePuppyResponse {

    ArrayList<ImagePuppy> imagePuppy;

    public ArrayList<ImagePuppy> getImagePuppy() {
        return imagePuppy;
    }

    public void setImgPuppy(ArrayList<ImagePuppy> imagePuppy) {
        this.imagePuppy = imagePuppy;
    }


}
