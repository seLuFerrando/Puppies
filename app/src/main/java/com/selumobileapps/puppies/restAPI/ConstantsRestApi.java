package com.selumobileapps.puppies.restAPI;

import android.content.Context;

import com.selumobileapps.puppies.database.Preferences;

/**
 * Created by selu on 11/12/16.
 */

public class ConstantsRestApi {
    //https://api.instagram.com/v1/
    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com" + VERSION;
    public static final String ACCESS_TOKEN = "2622532309.223bc43.d00cc0ef4e6b45c38eac74a930a944ca";
    public static final String KEY_ACCESS_TOKEN = "access_token=";
    public static final String KEY_USER = "users/";
    public static final String USER_ID = "2622532309";
    public static final String KEY_SEARCH = "search?q=";
    public static final String SEARCH = "seluferrando";
    public static final String KEY_GET_RECENT_MEDIA_USER = "/media/recent/?";
    public static final String URL_GET_RECENT_MEDIA_USER = KEY_USER + USER_ID + KEY_GET_RECENT_MEDIA_USER
                                                        + KEY_ACCESS_TOKEN + ACCESS_TOKEN;
    public static final String URL_GET_RECENT_MEDIA_USER1 = KEY_USER;
    public static final String URL_GET_RECENT_MEDIA_USER2 = KEY_GET_RECENT_MEDIA_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;
    //https://api.instagram.com/v1/users/{user-id}/media/recent/?access_token=ACCESS-TOKEN

    public static final String URL_SEARCH_USER_PROFILE1 = KEY_USER+ KEY_SEARCH ;
    public static final String URL_SEARCH_USER_PROFILE2 = "&" + KEY_ACCESS_TOKEN + ACCESS_TOKEN;
    public static final String URL_SEARCH_USER_PROFILE = KEY_USER + KEY_SEARCH + SEARCH + "&"
            + KEY_ACCESS_TOKEN + ACCESS_TOKEN;
    //https://api.instagram.com/v1/users/search?q=jack&access_token=ACCESS-TOKEN

}
