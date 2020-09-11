package com.katishev.anotherunnecessarystore;

import android.net.Uri;

import java.net.URL;

public class NetworkUtils {
    private static final String SHOP_HOST = "http://localhost:8080";
    private static final String GET_TEST = "/shop/";
    private static final String PARAM_ITEM_ID = "test";


    public static URL generateURL (String itemId){

    Uri buildURri = Uri.parse(SHOP_HOST + GET_TEST)
            .buildUpon()
            .appendQueryParameter(PARAM_ITEM_ID,itemId)
            .build();

URL url = null;


}


}
