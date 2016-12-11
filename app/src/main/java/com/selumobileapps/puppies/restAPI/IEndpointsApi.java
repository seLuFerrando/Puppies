package com.selumobileapps.puppies.restAPI;

import android.content.Context;

import com.selumobileapps.puppies.model.ImagePuppy;
import com.selumobileapps.puppies.model.InstagramUserID;
import com.selumobileapps.puppies.restAPI.model.ImagePuppyResponse;
import com.selumobileapps.puppies.restAPI.model.InstagramUserIDResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;


/**
 * Created by selu on 11/12/16.
 */

public interface IEndpointsApi{
/*
    @GET(ConstantsRestApi.URL_GET_RECENT_MEDIA_USER)
    Call<ImagePuppyResponse> getRecentMedia();

    @GET(ConstantsRestApi.URL_SEARCH_USER_PROFILE)
    Call<InstagramUserIDResponse> getUserProfile();
*/
    @GET
    Call<ImagePuppyResponse> getRecentMedia(@Url String url);

    @GET
    Call<InstagramUserIDResponse> getUserProfile(@Url String url);


}
