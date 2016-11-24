package com.selumobileapps.puppies.model;

/**
 * Created by selu on 5/11/16.
 */

public class Puppy {
    private int id;
    private int img;
    private String name;
    private int raiting;

    public Puppy(int id, int img, String name, int raiting){
        this.id = id;
        this.img = img;
        this.name = name;
        this.raiting = raiting;
    }

    public Puppy(int img, String name, int raiting){
        this.img = img;
        this.name = name;
        this.raiting = raiting;
    }


    public Puppy(int id, int img, String name){
        this.id = id;
        this.img = img;
        this.name = name;
        this.raiting = 0;
    }

    public Puppy(int img, String name){
        this.img = img;
        this.name = name;
        this.raiting = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

}
