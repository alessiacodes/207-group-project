package org.example;

import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class EdamamAPIClient {

    private static final String API_KEY = "40701b0a5656ead3e4ebcdd693df57e5";
    private static final String API_APP_ID = "d1b1e5f1";

    public static void run(){

        OkHttpClient client = new OkHttpClient().newBuilder().build();
//        Request request = new Request.Builder()
//                .url("https://api.edamam.com/api/food-database/v2/parser=" + "apple" + "&app_id=" + API_APP_ID + "&app_key=" + API_KEY)
//                .build();
        try {
            // Execute the HTTP request and get the response

            HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.edamam.com/api/nutrition-data").newBuilder();
            urlBuilder.addQueryParameter("app_id", API_APP_ID);
            urlBuilder.addQueryParameter("app_key", API_KEY);
            urlBuilder.addQueryParameter("ingr", "apple");
            String apiURL = urlBuilder.build().toString();

            Request request = new Request.Builder()
                    .url(apiURL)
                    .build();

            Response response = client.newCall(request).execute();

            // Check if the response is successful.
            if (response.isSuccessful()) {
                JSONObject responseBody = new JSONObject(response.body().string());
                JSONArray hits = responseBody.getJSONArray("hits");
                System.out.println(responseBody);
            } else {
                // Throw an exception if the API request is not successful.
                throw new RuntimeException("API request failed with status code: " + response.code());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
