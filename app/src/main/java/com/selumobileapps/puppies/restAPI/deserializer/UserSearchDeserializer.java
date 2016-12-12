package com.selumobileapps.puppies.restAPI.deserializer;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.selumobileapps.puppies.model.ImagePuppy;
import com.selumobileapps.puppies.model.InstagramUserID;
import com.selumobileapps.puppies.restAPI.JsonKeys;
import com.selumobileapps.puppies.restAPI.model.InstagramUserIDResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by selu on 11/12/16.
 */

public class UserSearchDeserializer implements JsonDeserializer<InstagramUserIDResponse> {
    @Override
    public InstagramUserIDResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        InstagramUserIDResponse instagramUserIDResponse = gson.fromJson(json, InstagramUserIDResponse.class);
        JsonArray instagramUserIDResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);

        instagramUserIDResponse.setInstagramUserID(instagramUserIDJsonDeserializer(instagramUserIDResponseData));
        Log.e("DESERIALIZER", "Esta en el user deserialize");
        return instagramUserIDResponse;
    }

    private ArrayList<InstagramUserID> instagramUserIDJsonDeserializer(JsonArray instagramUserIDResponseData) {
        ArrayList<InstagramUserID> instagramUserID = new ArrayList<>();
        for(int i=0; i<instagramUserIDResponseData.size(); i++) {
            JsonObject instagramUserIDResponseDataObject = instagramUserIDResponseData.get(i).getAsJsonObject();
            String id           = instagramUserIDResponseDataObject.get(JsonKeys.USER_ID).getAsString();
            String userName     = instagramUserIDResponseDataObject.get(JsonKeys.USERNAME).getAsString();
            String fullName     = instagramUserIDResponseDataObject.get(JsonKeys.USER_FULLNAME).getAsString();
            String imgProfile   = instagramUserIDResponseDataObject.get(JsonKeys.PROFILE_PICTURE).getAsString();

            InstagramUserID user = new InstagramUserID();
            user.setId(id);
            user.setUserName(userName);
            user.setFullName(fullName);
            user.setImgProfile(imgProfile);
            Log.e("DESERIALIZER", "user "+i+" name "+userName+" "+id);
            instagramUserID.add(user);

        }
        return instagramUserID;
    }
}
