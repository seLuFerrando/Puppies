package com.selumobileapps.puppies.pojo;

/**
 * Created by selu on 5/11/16.
 */

public class Puppy {
    private int img;
    private String name;
    private int raiting;
    private boolean favorite;

    public Puppy(int img, String name, int raiting, boolean favorite){
        this.img = img;
        this.name = name;
        this.raiting = raiting;
        this.favorite = favorite;
    }

    public Puppy(int img, String name, int raiting){
        this.img = img;
        this.name = name;
        this.raiting = raiting;
        this.favorite = false;
    }

    public Puppy(int img, String name){
        this.img = img;
        this.name = name;
        this.raiting = 0;
        this.favorite = false;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRaiting() {
        return raiting;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite() {
        this.favorite = true;
    }
}
