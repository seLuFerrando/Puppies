package com.selumobileapps.puppies.model;

/**
 * Created by selu on 8/11/16.
 */

public class ImagePuppy {
    private int id;
    private int idPuppy;
    private String img;
    private int raiting;

    public ImagePuppy(String img, int raiting){
        this.img = img;
        this.raiting = raiting;
    }
    public ImagePuppy(){};
/*
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPuppy() {
        return idPuppy;
    }

    public void setIdPuppy(int idPuppy) {
        this.idPuppy = idPuppy;
    }
*/
    public String getImage() {
        return img;
    }

    public void setImage(String img) {
        this.img = img;
    }

    public int getRaiting() {
        return raiting;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }
}
