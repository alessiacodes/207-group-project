package org.example;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class EdamamAPIClient {

    private static final String API_KEY = "ufTOPTeyFjBSK7gHo7NEZ6fIMZHSEvER";
    private static final String API_APP_ID = "d1b1e5f1";

    public static void run(){

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url("https://api.edamam.com/search?q=" + "apple" + "&app_id=" + API_APP_ID + "&app_key=" + API_KEY)
                .build();
        try {
            // Execute the HTTP request and get the response
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
