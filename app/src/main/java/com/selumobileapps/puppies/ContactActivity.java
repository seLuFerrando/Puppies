package com.selumobileapps.puppies;

import android.content.DialogInterface;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ContactActivity extends AppCompatActivity {

    TextInputEditText etName;
    TextInputEditText etEmail;
    TextInputEditText etMsg;
    Button btSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        Toolbar actionBar = (Toolbar) findViewById(R.id.actionBar);
        setSupportActionBar(actionBar);
        getSupportActionBar().setIcon(R.drawable.footprint);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etName = (TextInputEditText) findViewById(R.id.etName);
        etEmail = (TextInputEditText) findViewById(R.id.etEmail);
        etMsg = (TextInputEditText) findViewById(R.id.etDescription);
        btSend = (Button) findViewById(R.id.btSend);
        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString().trim();
                String name = etName.getText().toString().trim();
                String message = etMsg.getText().toString().trim() + "\ncontacto: " + name + " " + email;
                String subject = "Peticion de contacto de " + name;

                SendMail sm = new SendMail(ContactActivity.this, getResources().getString(R.string.emailAccount), subject, message);
                sm.execute();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_contact, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemAbout:
                showAlert();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showAlert(){
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(ContactActivity.this);
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
