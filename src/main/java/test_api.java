import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Arrays;

public class test_api {
    private static final String API_URL = "https://api.edamam.com/api/nutrition-data";
    private static final String app_id = "57bf3341";
    private static final String app_key = "62b9cb97f94e3ad1448ca14336ecd0a1";

    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");

        JSONObject requestBody = new JSONObject();
        requestBody.put("app_id", app_id);
        requestBody.put("app_key", app_key);
        requestBody.put("ingr", "rice (1 cup)");

        RequestBody body = RequestBody.create(mediaType, requestBody.toString());

        Request request = new Request.Builder()
                .url(API_URL)
                .method("GET", body)
                .build();

        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
            JSONObject responseBody = new JSONObject(response.body().string());

            if (response.isSuccessful()) {
                System.out.println(responseBody.get("calories"));
                System.out.println(responseBody.get("totalWeight"));

                JSONArray totalNutrients = responseBody.getJSONArray("totalNutrients");
                System.out.println((totalNutrients.toString()));
            }

            else {
                System.err.println("Request failed with code: " + response.code());
            }
        }

        catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }
}

