package com.selumobileapps.puppies.model;

import android.content.ContentValues;
import android.content.Context;

import com.selumobileapps.puppies.R;
import com.selumobileapps.puppies.database.DataBase;
import com.selumobileapps.puppies.database.DatabaseContstants;

import java.util.ArrayList;

/**
 * Created by selu on 23/11/16.
 */

public class PuppiesBuilder {
    private static final int RAITING = 1;
    private Context context;

    public PuppiesBuilder(Context context){
        this.context = context;
    }

    public ArrayList<Puppy> getAllPuppies(){
        ArrayList<Puppy> puppies = new ArrayList<>();
        puppies.add(new Puppy(1, R.drawable.puppy3, "Satcha", 3));
        puppies.add(new Puppy(2, R.drawable.puppy4, "Rocko", 2));
        puppies.add(new Puppy(3, R.drawable.puppy5, "Kuka", 1));
        puppies.add(new Puppy(4, R.drawable.puppy, "Tronk"));
        puppies.add(new Puppy(5, R.drawable.puppy2, "Drako"));
        puppies.add(new Puppy(6, R.drawable.puppy6, "Mari"));
        puppies.add(new Puppy(7, R.drawable.puppy7, "Trosky"));
        puppies.add(new Puppy(8, R.drawable.puppy8, "Blanca"));
        return puppies;
    }

    public ArrayList<Puppy> getFavoritePuppies(){
        DataBase db = new DataBase(context);
        return db.getFavoritePuppies();
    }

    public void increaseRaiting(Puppy puppy){
        int raiting = puppy.getRaiting() + RAITING;
        puppy.setRaiting(raiting);

        ContentValues values = new ContentValues();
        values.put(DatabaseContstants.TABLE_PUPPIES_PUPPY_ID, puppy.getId());
        values.put(DatabaseContstants.TABLE_PUPPIES_IMAGE, puppy.getImg());
        values.put(DatabaseContstants.TABLE_PUPPIES_NAME, puppy.getName());
        values.put(DatabaseContstants.TABLE_PUPPIES_RAITING, puppy.getRaiting());

        DataBase db = new DataBase(context);
        db.increaseRaiting(values);
    }

    public void insertPuppy(Puppy puppy){
        ContentValues values = new ContentValues();
        values.put(DatabaseContstants.TABLE_PUPPIES_PUPPY_ID, puppy.getId());
        values.put(DatabaseContstants.TABLE_PUPPIES_IMAGE, puppy.getImg());
        values.put(DatabaseContstants.TABLE_PUPPIES_NAME, puppy.getName());
        values.put(DatabaseContstants.TABLE_PUPPIES_RAITING, puppy.getRaiting());

        DataBase db = new DataBase(context);
        db.insertPuppy(values);
    }
}
