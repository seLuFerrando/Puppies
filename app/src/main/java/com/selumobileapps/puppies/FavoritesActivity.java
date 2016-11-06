package com.selumobileapps.puppies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

/**
 * Created by selu on 6/11/16.
 */

public class FavoritesActivity extends AppCompatActivity {
    ArrayList<Puppy> puppies;
    private RecyclerView puppiesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        Toolbar actionBar = (Toolbar) findViewById(R.id.actionBar);
        setSupportActionBar(actionBar);
        getSupportActionBar().setIcon(R.drawable.footprint);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        puppiesList = (RecyclerView) findViewById(R.id.rvPuppies);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        puppiesList.setLayoutManager(llm);
        iniPuppiesList();
        iniPuppiesAdapter();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_favorites, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemSettings:
                //TODO item click
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void iniPuppiesList(){
        puppies = new ArrayList<Puppy>();
        puppies.add(new Puppy(R.drawable.puppy4, "Tronk"));
        puppies.add(new Puppy(R.drawable.puppy5, "Drako"));
        puppies.add(new Puppy(R.drawable.puppy6, "Mari"));
        puppies.add(new Puppy(R.drawable.puppy7, "Trosky"));
        puppies.add(new Puppy(R.drawable.puppy8, "Blanca"));
    }

    public void iniPuppiesAdapter(){
        PuppyAdapter adapter = new PuppyAdapter(puppies);
        puppiesList.setAdapter(adapter);
    }


}
