package com.katishev.anotherunnecessarystore;

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
    private static final String SHOP_HOST = "http://oem-17680eaf.localhost.run";
    private static final String GET_ALL_VEHICLE = "/shop/get-ship";
    private static final String GET_ALL_SHIPS = "/shop/all-ships";
    private static final String ITEM_ID = "id";

    public static URL generateAllVehicleURL() {

        Uri buildURri = Uri.parse(SHOP_HOST + GET_ALL_VEHICLE).buildUpon().build();

        URL urlAllVehicle = null;

        try {
            urlAllVehicle = new URL(buildURri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return urlAllVehicle;
    }

    public static URL generateAllShipsURL() {

        Uri buildURri = Uri.parse(SHOP_HOST + GET_ALL_SHIPS).buildUpon().build();
        URL urlAllShips = null;
        try {
            urlAllShips = new URL(buildURri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return urlAllShips;

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

        public interface onLoadComplete {
            void onLoadComplete(List<ItemAdapter.DataItem> dataList);
        }

        private onLoadComplete mListener;

        public void setListener(onLoadComplete listener) {
            mListener = listener;
        }

        @Override
        protected String doInBackground(Void... voids) {

            String responseFromURL = null;
            try {
                responseFromURL = getResponseFromURL(generateAllShipsURL());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return responseFromURL;
        }

        @Override
        protected void onPostExecute(String response) {


            try {
                JSONArray jsonResponse = new JSONArray(response);
                List<ItemAdapter.DataItem> dataList = new LinkedList<>();
                for (int i = 0; i < jsonResponse.length(); ++i) {
                    JSONObject obj = jsonResponse.getJSONObject(i);
                    ItemAdapter.DataItem item = new ItemAdapter.DataItem();
                    item.className = obj.getString("className");
                    item.name = obj.getString("name");
                    item.description = obj.getString("description");
                    item.price = obj.getString("price");
                    item.uriWhereImage = obj.getString("uri");
                    dataList.add(item);
                }

                mListener.onLoadComplete(dataList);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

}