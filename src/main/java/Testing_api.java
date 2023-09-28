import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class Testing_api {
    private static final String APP_ID  = "64984032";
    private static final String APP_KEY  = "47ecdbab5b1aa48bcbd2c622f83c8006";

    public static void main(String[] args) {

        OkHttpClient client = new OkHttpClient();

        try {
            // Build correct URL with appropriate parameters, in this case I'm using the API to find the nutritional
            // content of rice.
            HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.edamam.com/api/nutrition-data").newBuilder();
            urlBuilder.addQueryParameter("app_id", APP_ID);
            urlBuilder.addQueryParameter("app_key", APP_KEY);
            urlBuilder.addQueryParameter("ingr", "rice (1 cup)");
            String apiURL = urlBuilder.build().toString();

            // Making the actual request
            Request request = new Request.Builder()
                    .url(apiURL)
                    .build();

            // Getting the response
            Response response = client.newCall(request).execute();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
