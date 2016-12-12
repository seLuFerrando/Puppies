package com.selumobileapps.puppies;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.selumobileapps.puppies.database.Preferences;
import com.selumobileapps.puppies.model.InstagramUserID;
import com.selumobileapps.puppies.restAPI.ConstantsRestApi;
import com.selumobileapps.puppies.restAPI.IEndpointsApi;
import com.selumobileapps.puppies.restAPI.adapter.RestApiAdapter;
import com.selumobileapps.puppies.restAPI.model.InstagramUserIDResponse;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by selu on 11/12/16.
 */

public class SetUpAccountActivity extends AppCompatActivity {

    TextView tvId;
    TextView tvFullName;
    TextInputLayout tilSearch;
    TextInputEditText etSearch;
    CircularImageView civProfile;
    ImageButton ibSearch;
    Button btSave;
    Preferences prefs;
    InstagramUserID instagramUserID;
    ArrayList<InstagramUserID> usersList;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_setupaccount);

        Toolbar actionBar = (Toolbar) findViewById(R.id.actionBar);
        setSupportActionBar(actionBar);
        getSupportActionBar().setIcon(R.drawable.footprint);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        prefs = new Preferences(this);
        usersList = new ArrayList<InstagramUserID>();
        tvId = (TextView) findViewById(R.id.tvId);
        tvFullName = (TextView)findViewById(R.id.tvFullName);
        tilSearch = (TextInputLayout)findViewById(R.id.tilSearch);
        etSearch = (TextInputEditText)findViewById(R.id.etSearch);
        civProfile = (CircularImageView)findViewById(R.id.civProfile);
        ibSearch = (ImageButton)findViewById(R.id.ibSearch);
        ibSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDataProfile();
            }
        });
        btSave = (Button)findViewById(R.id.btSave);
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prefs.setInstagramUserID(instagramUserID);
                //onBackPressed();
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        instagramUserID = prefs.getInstagramUserID();
        Picasso.with(this)
                .load(instagramUserID.getImgProfile())
                .placeholder(R.drawable.dogsilhouette)
                .into(civProfile);
        tvId.setText(instagramUserID.getId());
        tvFullName.setText(instagramUserID.getFullName());
        etSearch.setText(instagramUserID.getUserName());

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
            case R.id.itemSettings:
                Intent intent3 = new Intent(this, SetUpAccountActivity.class);
                startActivity(intent3);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void showAlert(){
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(SetUpAccountActivity.this);
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
    public void getDataProfile() {
        String url = ConstantsRestApi.URL_SEARCH_USER_PROFILE1
                + etSearch.getText().toString()
                + ConstantsRestApi.URL_SEARCH_USER_PROFILE2;
        Log.d("URL USER", url);
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonSearchUser = restApiAdapter.gsonUserSearchDeserializer();
        IEndpointsApi iEndpointsApi = restApiAdapter.establishInstagramApiConexion(gsonSearchUser);
        Call<InstagramUserIDResponse> instagramUserIDResponseCall = iEndpointsApi.getUserProfile(url);
        instagramUserIDResponseCall.enqueue(new Callback<InstagramUserIDResponse>() {
            @Override
            public void onResponse(Call<InstagramUserIDResponse> call, Response<InstagramUserIDResponse> response) {
                InstagramUserIDResponse instagramUserIDResponse = response.body();

                usersList = instagramUserIDResponse.getInstagramUserID();
                showDataProfile();
            }

            @Override
            public void onFailure(Call<InstagramUserIDResponse> call, Throwable t) {
                Toast.makeText(SetUpAccountActivity.this, "Fallo en al conexion Perfil, intentelo de nuevo", Toast.LENGTH_LONG).show();
                Log.e("ERROR CONEXION PERFIL", t.toString());
            }
        });
    }

    public void showDataProfile(){
        if(!usersList.isEmpty()) {
            instagramUserID = usersList.get(0);
            Picasso.with(this)
                    .load(instagramUserID.getImgProfile())
                    .placeholder(R.drawable.dogsilhouette)
                    .into(civProfile);
            tvId.setText(instagramUserID.getId());
            tvFullName.setText(instagramUserID.getFullName());
        }else{
            Toast.makeText(getApplicationContext(),"NO se ha podido encontrar el Usuario", Toast.LENGTH_LONG).show();
        }
    }


}