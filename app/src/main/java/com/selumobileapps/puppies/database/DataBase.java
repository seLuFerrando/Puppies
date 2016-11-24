package com.selumobileapps.puppies.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.selumobileapps.puppies.R;
import com.selumobileapps.puppies.model.Puppy;

import java.util.ArrayList;

/**
 * Created by selu on 23/11/16.
 */

public class DataBase extends SQLiteOpenHelper {

    private Context context;

    public DataBase(Context context) {
        super(context, DatabaseContstants.DATABASE_NAME, null, DatabaseContstants.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCreateTablePuppies = "CREATE TABLE " + DatabaseContstants.TABLE_PUPPIES + "(" +
                DatabaseContstants.TABLE_PUPPIES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DatabaseContstants.TABLE_PUPPIES_PUPPY_ID + " INTEGER, " +
                DatabaseContstants.TABLE_PUPPIES_IMAGE + " INTEGER, " +
                DatabaseContstants.TABLE_PUPPIES_NAME + " TEXT, " +
                DatabaseContstants.TABLE_PUPPIES_RAITING + " INTEGER" +
                ")";
        db.execSQL(queryCreateTablePuppies);
        iniPuppies(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + DatabaseContstants.TABLE_PUPPIES);
        onCreate(db);
    }

    public void iniPuppies(SQLiteDatabase db){
        ContentValues values = new ContentValues();
        values.put(DatabaseContstants.TABLE_PUPPIES_PUPPY_ID, 1);
        values.put(DatabaseContstants.TABLE_PUPPIES_IMAGE, R.drawable.puppy3);
        values.put(DatabaseContstants.TABLE_PUPPIES_NAME, "Satcha");
        values.put(DatabaseContstants.TABLE_PUPPIES_RAITING, 3);

        db.insert(DatabaseContstants.TABLE_PUPPIES,
                null,
                values);;

        values = new ContentValues();
        values.put(DatabaseContstants.TABLE_PUPPIES_PUPPY_ID, 2);
        values.put(DatabaseContstants.TABLE_PUPPIES_IMAGE, R.drawable.puppy4);
        values.put(DatabaseContstants.TABLE_PUPPIES_NAME, "Rocko");
        values.put(DatabaseContstants.TABLE_PUPPIES_RAITING, 2);

        db.insert(DatabaseContstants.TABLE_PUPPIES,
                null,
                values);

        values = new ContentValues();
        values.put(DatabaseContstants.TABLE_PUPPIES_PUPPY_ID, 3);
        values.put(DatabaseContstants.TABLE_PUPPIES_IMAGE, R.drawable.puppy5);
        values.put(DatabaseContstants.TABLE_PUPPIES_NAME, "Kuka");
        values.put(DatabaseContstants.TABLE_PUPPIES_RAITING, 1);

        db.insert(DatabaseContstants.TABLE_PUPPIES,
                null,
                values);
    }

    public ArrayList<Puppy> getFavoritePuppies(){
        ArrayList<Puppy> puppies = new ArrayList<>();

        String query = "SELECT * FROM " + DatabaseContstants.TABLE_PUPPIES;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor records = db.rawQuery(query, null);

        while (records.moveToNext()) {
            Puppy puppy = new Puppy(
                    records.getInt(1),
                    records.getInt(2),
                    records.getString(3),
                    records.getInt(4)
            );
            puppies.add(puppy);
        }
        db.close();
        return puppies;
    }

    public long insertPuppy(ContentValues values){
        SQLiteDatabase db = this.getWritableDatabase();
        long i = db.insert(DatabaseContstants.TABLE_PUPPIES,
                null,
                values);
        db.close();
        return i;
    }

    public int deletePuppy(Puppy puppy){
        SQLiteDatabase db = this.getWritableDatabase();
        int i =db.delete(DatabaseContstants.TABLE_PUPPIES,
                DatabaseContstants.TABLE_PUPPIES_PUPPY_ID + "=" + puppy.getId(),
                null);
        db.close();
        return i;
    }

    public void increaseRaiting(ContentValues values){
        SQLiteDatabase db = this.getWritableDatabase();

        int i = db.update(DatabaseContstants.TABLE_PUPPIES,
                values,
                DatabaseContstants.TABLE_PUPPIES_PUPPY_ID + "=" + values.getAsInteger(DatabaseContstants.TABLE_PUPPIES_PUPPY_ID),
                null);
        if (i<1){
            long n = insertPuppy(values);
            if (n>DatabaseContstants.NUM_PUPPIES){
                Puppy mPuppy = new Puppy((int)n-DatabaseContstants.NUM_PUPPIES,
                        0,
                        "");
                deletePuppy(mPuppy);
            }
        }
        db.close();
    }
}
