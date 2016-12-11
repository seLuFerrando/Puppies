package com.selumobileapps.puppies.restAPI.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.selumobileapps.puppies.model.ImagePuppy;
import com.selumobileapps.puppies.restAPI.ConstantsRestApi;
import com.selumobileapps.puppies.restAPI.IEndpointsApi;
import com.selumobileapps.puppies.restAPI.deserializer.MediaRecentDeserializer;
import com.selumobileapps.puppies.restAPI.deserializer.UserSearchDeserializer;
import com.selumobileapps.puppies.restAPI.model.ImagePuppyResponse;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by selu on 11/12/16.
 */

public class RestApiAdapter {
    public IEndpointsApi establishInstagramApiConexion(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantsRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(IEndpointsApi.class);
    }

    public Gson gsonMediaRecentDeserializer(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ImagePuppyResponse.class, new MediaRecentDeserializer());
        return gsonBuilder.create();
    }

    public Gson gsonUserSearchDeserializer(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ImagePuppyResponse.class, new UserSearchDeserializer());
        return gsonBuilder.create();
    }

}
