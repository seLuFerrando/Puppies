package com.selumobileapps.puppies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Puppy> puppies;
    private RecyclerView puppiesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar actionBar = (Toolbar) findViewById(R.id.actionBar);
        setSupportActionBar(actionBar);
        getSupportActionBar().setIcon(R.drawable.footprint);

        puppiesList = (RecyclerView) findViewById(R.id.rvPuppies);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        puppiesList.setLayoutManager(llm);
        iniPuppiesList();
        iniPuppiesAdapter();


    }

    public void iniPuppiesList(){
        puppies = new ArrayList<Puppy>();
        puppies.add(new Puppy(R.drawable.puppy, "Satcha", 5, false));
        puppies.add(new Puppy(R.drawable.puppy2, "Rocko"));
        puppies.add(new Puppy(R.drawable.puppy3, "Kuka", 3));
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
