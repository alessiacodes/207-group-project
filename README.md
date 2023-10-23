# 207-group-project
## Project domain: fitness and lifestyle
## Short description:
We aim to create a program that tracks macro and micro nutrients of the user throughout the day. Additionally, users can find the nutritional value of the recipe of their choice or get reccomended meals based on their dietary restrictions and/or fitness goals.
## API Information
Edamam is an API with lots of food-related functionalities. For testing purposes, we are using their nutritional data API.  
Documentation: https://developer.edamam.com/edamam-docs-nutrition-api

## Hoppscotch Output
![image](https://github.com/alessiacodes/207-group-project/assets/128920588/13a42df6-4c56-4403-8b3c-b0592efb3193)

## Java API Calls (Code and Results)
### Code
```java
import okhttp3.*;
import org.json.JSONArray;
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
            JSONObject responseBody = new JSONObject(response.body().string());

            // Process JSON File response
            if (response.isSuccessful()) {
                System.out.println("API connection successful");
                System.out.println("Calories in 1 cup of uncooked rice: " + responseBody.get("calories"));

                JSONArray dietLabels = responseBody.getJSONArray("dietLabels");
                System.out.println("Diet labels: " + dietLabels.toString());
            } else {
                System.err.println("Request failed with code: " + response.code());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
```

### Results
![image](https://github.com/alessiacodes/207-group-project/assets/128920588/82c93feb-4141-458a-a83d-1fc5ecceaaac)

