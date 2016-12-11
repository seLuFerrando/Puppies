package com.selumobileapps.puppies.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.selumobileapps.puppies.database.Preferences;
import com.selumobileapps.puppies.fragment.IProfileFragment;
import com.selumobileapps.puppies.model.ImagePuppy;
import com.selumobileapps.puppies.model.InstagramUserID;
import com.selumobileapps.puppies.restAPI.ConstantsRestApi;
import com.selumobileapps.puppies.restAPI.IEndpointsApi;
import com.selumobileapps.puppies.restAPI.adapter.RestApiAdapter;
import com.selumobileapps.puppies.restAPI.model.ImagePuppyResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by selu on 11/12/16.
 */

public class ProfileRecyclerFragmentPresenter implements IProfileRecyclerFragmentPresenter {

    Context context;
    IProfileFragment iProfileFragment;
    ArrayList<ImagePuppy> imagePuppies;
    InstagramUserID instagramUserID;
    Preferences pref;

    public ProfileRecyclerFragmentPresenter(IProfileFragment iProfileFragment, Context context){
        this.context = context;
        this.iProfileFragment = iProfileFragment;
        pref = new Preferences(context);
        getDataRV();
    }

    @Override
    public void getDataRV() {
        String url = ConstantsRestApi.URL_GET_RECENT_MEDIA_USER1 + pref.getId()
                +ConstantsRestApi.URL_GET_RECENT_MEDIA_USER2;
        Log.d("URL RECENT", url);
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.gsonMediaRecentDeserializer();
        IEndpointsApi iEndpointsApi = restApiAdapter.establishInstagramApiConexion(gsonMediaRecent);
        Call<ImagePuppyResponse> imagePuppyResponseCall = iEndpointsApi.getRecentMedia(url);
        imagePuppyResponseCall.enqueue(new Callback<ImagePuppyResponse>() {
            @Override
            public void onResponse(Call<ImagePuppyResponse> call, Response<ImagePuppyResponse> response) {
                ImagePuppyResponse imagePuppyResponse = response.body();
                imagePuppies = imagePuppyResponse.getImagePuppy();
                showDataRV();
            }

            @Override
            public void onFailure(Call<ImagePuppyResponse> call, Throwable t) {
                Toast.makeText(context, "Fallo en al conexion Instagram, intentelo de nuevo", Toast.LENGTH_LONG).show();
                Log.e("ERROR CONEXION INSTAGRA", t.toString());
            }
        });
    }

    @Override
    public void showDataRV() {
        iProfileFragment.iniAdapterRV(iProfileFragment.makeAdapter(imagePuppies));
        iProfileFragment.makeGridLayout();
    }
}
