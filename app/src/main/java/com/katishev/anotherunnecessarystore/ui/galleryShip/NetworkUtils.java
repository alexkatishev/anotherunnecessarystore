package com.katishev.anotherunnecessarystore.ui.galleryShip;

import android.net.Uri;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class NetworkUtils {
    private static final String SHOP_HOST = "https://oem-8b591964.localhost.run";
    private static final String GET_ONE_ITEM = "/shop/get-ship";
    private static final String GET_ALL = "/shop/all-ships";
    private static final String ITEM_ID = "id";

    public static URL generateURL(String itemId) {

         Uri buildURri = Uri.parse(SHOP_HOST + GET_ONE_ITEM)
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

    public static URL generateAllURL() {

        Uri buildURri = Uri.parse(SHOP_HOST + GET_ALL).buildUpon().build();
        URL urlAll = null;
        try {
            urlAll = new URL(buildURri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return urlAll;
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

    // паралельный поток выполнения
    public static class QueryTask extends AsyncTask<Void, Void, String> {

        interface onLoadComplete {
            void onLoadComplete(List<ItemAdapter.DataItem> dataList);
        }

        private onLoadComplete mListener;

        void setListener(onLoadComplete listener) {
            mListener = listener;
        }

        @Override
        protected String doInBackground(Void... voids) {
//            List<URL> urls = new LinkedList<>();
//            for (int i = 0; i < itemsCound; ++i) {
//                urls.add(generateURL("TODO: add id here"));
//            }

            String response = null;
            try {
                response = getResponseFromURL(generateAllURL());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return response;
        }

        @Override
        protected void onPostExecute(String response) {
            String className = null;
            String name = null;
            String description = null;
            String uriWhereImage = null;

            try {
                JSONArray jsonResponse = new JSONArray(response);
                List<ItemAdapter.DataItem> dataList = new LinkedList<>();
                for (int i = 0; i < jsonResponse.length(); ++i) {
                    JSONObject obj = jsonResponse.getJSONObject(i);
                    ItemAdapter.DataItem item = new ItemAdapter.DataItem();
                    item.className = obj.getString("className");
                    item.name = obj.getString("name");
                    item.description = obj.getString("description");
                    dataList.add(item);
                }

                mListener.onLoadComplete(dataList);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }

}