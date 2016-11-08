package com.selumobileapps.puppies.pojo;

/**
 * Created by selu on 8/11/16.
 */

public class ImagePuppy {
    private int id;
    private int idPuppy;
    private int img;
    private int raiting;


    public ImagePuppy(int id, int idPuppy, int img, int raiting) {
        this.id = id;
        this.idPuppy = idPuppy;
        this.img = img;
        this.raiting = raiting;
    }

    public ImagePuppy(int img, int raiting){
        this.img = img;
        this.raiting = raiting;
    }

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

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getRaiting() {
        return raiting;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }
}
