package data_access;

import entity.Recommend;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import entity.Food;
import use_case.recipe.RecipeDataAccessInterface;

class EdamamApiAccess implements RecipeDataAccessInterface {
    private static final String APP_ID = "64984032"; //this is for food lookup
    private static final String APP_KEY = "47ecdbab5b1aa48bcbd2c622f83c8006"; //this is for food lookup

    private static final String APP_ID_REC = "cd905d5f"; //for recommending recipes
    private static final String APP_KEY_REC = "19dbdd026906aa90c7a5ca301942a30d"; //for recommending recipes


    /*public static JSONObject apiHelper(Food identifier) {
        String foodName = identifier.getName();
        OkHttpClient client = new OkHttpClient();

        try {
            // Build correct URL with appropriate parameters, in this case I'm using the API to find the nutritional
            // content of rice.
            HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.edamam.com/api/nutrition-data").newBuilder();
            urlBuilder.addQueryParameter("app_id", APP_ID);
            urlBuilder.addQueryParameter("app_key", APP_KEY);
            urlBuilder.addQueryParameter("ingr", foodName);
            String apiURL = urlBuilder.build().toString();

            // Making the actual request
            Request request = new Request.Builder()
                    .url(apiURL)
                    .build();

            // Getting the response
            Response response = client.newCall(request).execute();
            JSONObject responseBody = new JSONObject(response.body().string());
            return responseBody;
        }

        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/

    public Integer getCalories(Food identifier) {
        String foodName = identifier.getName();
        OkHttpClient client = new OkHttpClient();

        try {
            // Build correct URL with appropriate parameters, in this case I'm using the API to find the nutritional
            // content of rice.
            HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.edamam.com/api/nutrition-data").newBuilder();
            urlBuilder.addQueryParameter("app_id", APP_ID);
            urlBuilder.addQueryParameter("app_key", APP_KEY);
            urlBuilder.addQueryParameter("ingr", foodName);
            String apiURL = urlBuilder.build().toString();

            // Making the actual request
            Request request = new Request.Builder()
                    .url(apiURL)
                    .build();

            // Getting the response
            Response response = client.newCall(request).execute();
            JSONObject responseBody = new JSONObject(response.body().string());
            return (Integer) responseBody.get("calories");
        }

        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public HashMap<String, Double> getTotalNutrients(Food identifier) {
        String foodName = identifier.getName();
        OkHttpClient client = new OkHttpClient();

        try {
            // Build correct URL with appropriate parameters, in this case I'm using the API to find the nutritional
            // content of rice.
            HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.edamam.com/api/nutrition-data").newBuilder();
            urlBuilder.addQueryParameter("app_id", APP_ID);
            urlBuilder.addQueryParameter("app_key", APP_KEY);
            urlBuilder.addQueryParameter("ingr", foodName);
            String apiURL = urlBuilder.build().toString();

            // Making the actual request
            Request request = new Request.Builder()
                    .url(apiURL)
                    .build();

            // Getting the response
            Response response = client.newCall(request).execute();
            JSONObject responseBody = new JSONObject(response.body().string());
            Map<String, Object> totalNutrients = responseBody.getJSONObject("totalNutrients").toMap();
            HashMap<String, Double> nutrients = new HashMap<String, Double>();

            Set<String> nutrientNames = totalNutrients.keySet();
            for (String nutrient : nutrientNames) {
                Double doubleNutrient = (Double) totalNutrients.get(nutrient);
                nutrients.put(nutrient, doubleNutrient);
            }
            return nutrients;
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
//    public static tuple getFoodData(String food, String Quantity){
//
//    }


    public String getRecommendation(Recommend identifier){
        ArrayList<String> diet = identifier.getDiet();
        ArrayList<String> health = identifier.getHealth();
        String mealType = identifier.getMealType();
        OkHttpClient client = new OkHttpClient();

        try {
            // Build correct URL with appropriate parameters

            HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.edamam.com/api/recipes/v2").newBuilder();
            urlBuilder.addQueryParameter("app_id", APP_ID_REC);
            urlBuilder.addQueryParameter("app_key", APP_KEY_REC);

            // add all diet tags
            for (String item : diet) {
                urlBuilder.addQueryParameter("diet", item); //adds each tag
            }

            // add all health tags
            for (String item : health) {
                urlBuilder.addQueryParameter("health", item); //adds each tag
            }

            // add mealType tag
            urlBuilder.addQueryParameter("mealType", mealType);
            String apiURL = urlBuilder.build().toString();


            // Making the actual request
            Request request = new Request.Builder()
                    .url(apiURL)
                    .build();

            // Getting the response
            Response response = client.newCall(request).execute();
            JSONObject responseBody = new JSONObject(response.body().string());

            //change to recommend use case
            String recommendLink = responseBody.getJSONObject("shareAs").toString();


            return recommendLink;
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}