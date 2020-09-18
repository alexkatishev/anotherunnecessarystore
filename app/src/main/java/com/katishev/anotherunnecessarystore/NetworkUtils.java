package com.katishev.anotherunnecessarystore;

import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.Scanner;

public class NetworkUtils {
    private static final String SHOP_HOST = "http://localhost:8080";
    private static final String GET_TEST = "/shop/get-ship/";
    private static final String ITEM_ID = "";


    public static URL generateURL(String itemId) {

        Uri buildURri = Uri.parse(SHOP_HOST + GET_TEST)
                .buildUpon()
                .appendQueryParameter(ITEM_ID, itemId)
                .build();

        URL url = null;
        try {
            url = new URL(buildURri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    public static String getResponseFromURL(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        try {
            InputStream in = urlConnection.getInputStream();
            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");
            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();


        }

    }
}