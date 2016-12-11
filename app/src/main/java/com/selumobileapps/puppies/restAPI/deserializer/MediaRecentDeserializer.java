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
import com.selumobileapps.puppies.restAPI.JsonKeys;
import com.selumobileapps.puppies.restAPI.model.ImagePuppyResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by selu on 11/12/16.
 */

public class MediaRecentDeserializer implements JsonDeserializer<ImagePuppyResponse> {
    @Override
    public ImagePuppyResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        ImagePuppyResponse imagePuppyResponse = gson.fromJson(json, ImagePuppyResponse.class);
        JsonArray imagePuppyResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);

        imagePuppyResponse.setImgPuppy(imagePuppyJsonDeserializer(imagePuppyResponseData));
        return imagePuppyResponse;
    }

    private ArrayList<ImagePuppy> imagePuppyJsonDeserializer(JsonArray imagePuppiesResponseData){
        ArrayList<ImagePuppy> imagePuppies = new ArrayList<>();
        for (int i = 0; i < imagePuppiesResponseData.size() ; i++) {
            JsonObject imagePuppiesResponseDataObject = imagePuppiesResponseData.get(i).getAsJsonObject();

            JsonObject userJson     = imagePuppiesResponseDataObject.getAsJsonObject(JsonKeys.USER);
            String id               = userJson.get(JsonKeys.USER_ID).getAsString();
            String fullName         = userJson.get(JsonKeys.USER_FULLNAME).getAsString();

            JsonObject imageJson            = imagePuppiesResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_IMAGES);
            JsonObject stdResolutionJson    = imageJson.getAsJsonObject(JsonKeys.MEDIA_STANDARD_RESOLUTION);
            String urlImage                 = stdResolutionJson.get(JsonKeys.MEDIA_URL).getAsString();

            JsonObject likesJson = imagePuppiesResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_LIKES);
            int likes = likesJson.get(JsonKeys.MEDIA_LIKES_COUNT).getAsInt();

            ImagePuppy imagePuppy = new ImagePuppy();
//            imagePuppy.setId(id);
//            imagePuppy.setFullName(fullName);
            imagePuppy.setImage(urlImage);
            imagePuppy.setRaiting(likes);

            imagePuppies.add(imagePuppy);

        }

        return imagePuppies;
    }

}
