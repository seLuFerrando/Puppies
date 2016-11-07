package com.selumobileapps.puppies;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Puppy> puppies;
    FloatingActionButton fab;
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

        fab = (FloatingActionButton) findViewById(R.id.fabCamera);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO fab click
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemFavorites:
                Intent intent = new Intent(this, FavoritesActivity.class);
                startActivity(intent);
                return true;
            case R.id.itemContact:
                Intent intent2 = new Intent(this, ContactActivity.class);
                startActivity(intent2);
                return true;
            case R.id.itemAbout:
                showAlert();
                return true;
        }

        return super.onOptionsItemSelected(item);
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

    private void showAlert(){
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
        alertBuilder.setTitle(R.string.itemAbout);
        LayoutInflater inflater = this.getLayoutInflater();
        alertBuilder.setView(inflater.inflate(R.layout.dialog_about, null))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        alertBuilder.create();
        alertBuilder.show();
    }
}
