package data_access;

import entity.Recommend;
import okhttp3.*;
import org.json.JSONArray;


import org.json.JSONObject;
import java.io.IOException;
import java.util.*;

import entity.Food;
import use_case.food.FoodDataAccessInterface;
import use_case.recipe.RecipeDataAccessInterface;
import use_case.recommend.RecommendDataAccessInterface;
import use_case.track.TrackDataAccessInterface;

public class EdamamApiAccess implements RecipeDataAccessInterface, RecommendDataAccessInterface, FoodDataAccessInterface, TrackDataAccessInterface {
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

    public float getCalories(Food identifier) {
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

    public HashMap<String, Float> getTotalNutrients(Food identifier) {
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
            HashMap<String, Float> nutrients = new HashMap<String, Float>();

            Set<String> nutrientNames = totalNutrients.keySet();
            for (String nutrient : nutrientNames) {
                Float FloatNutrient = (Float) totalNutrients.get(nutrient);
                nutrients.put(nutrient, FloatNutrient);
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


    public String getRecommendLink(Recommend identifier){
        //api call to get the link to a recipe based off of the user's input

        ArrayList<String> diet = identifier.getDiet();
        ArrayList<String> health = identifier.getHealth();
        String mealType = identifier.getMealType();
        OkHttpClient client = new OkHttpClient();

        System.out.println(identifier.getDiet());
        System.out.println(identifier.getHealth());
        System.out.println(identifier.getMealType());

        try {
            // Build correct URL with appropriate parameters

            HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.edamam.com/api/recipes/v2").newBuilder();
            urlBuilder.addQueryParameter("app_id", APP_ID_REC);
            urlBuilder.addQueryParameter("app_key", APP_KEY_REC);

            if (!diet.isEmpty()) {
                // add all diet tags
                for (String item : diet) {
                    urlBuilder.addQueryParameter("diet", item); //adds each tag
                }
            }

            if (!health.isEmpty()) {
                // add all health tags
                for (String item : health) {
                    urlBuilder.addQueryParameter("health", item); //adds each tag
                }
            }

            ArrayList<String> mealTypeList = new ArrayList<>();
            mealTypeList.add(mealType);

            // add mealType tag
            urlBuilder.addQueryParameter("mealType", mealType);
            urlBuilder.addQueryParameter("type", "public");
            String apiURL = urlBuilder.build().toString();

            // Making the actual request
            Request request = new Request.Builder()
                    .url(apiURL)
                    .build();

            // Getting the response
            Response response = client.newCall(request).execute();
            JSONObject responseBody = new JSONObject(response.body().string());
            // determine number of recipes in response
            int count = responseBody.getInt("to");

            // generate random number to pick recipe out of those recommended (to offer more variety)
            Random rand = new Random();
            int randRecipe = rand.nextInt(count - 1);


            //sort through JSON object to return only the link for the recipe
            JSONArray hits = responseBody.getJSONArray("hits");
            JSONObject recipeObject = hits.getJSONObject(randRecipe);
            JSONObject recipeData = recipeObject.getJSONObject("recipe");

            return recipeData.getString("shareAs");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public HashMap<String, Float> getFoodNutritionalValues(String foodName, Float quantity) {
        OkHttpClient client = new OkHttpClient();

        String foodParameter;

        foodParameter = String.valueOf(quantity) + foodName;



        try {
            // Build correct URL with appropriate parameters, in this case I'm using the API to find the nutritional
            // content of rice.
            HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.edamam.com/api/nutrition-data").newBuilder();
            urlBuilder.addQueryParameter("app_id", APP_ID);
            urlBuilder.addQueryParameter("app_key", APP_KEY);
            urlBuilder.addQueryParameter("ingr", foodParameter);
            String apiURL = urlBuilder.build().toString();

            // Making the actual request
            Request request = new Request.Builder()
                    .url(apiURL)
                    .build();

            // Getting the response
            Response response = client.newCall(request).execute();

            JSONObject responseBody = new JSONObject(response.body().string());
            Map<String, Object> totalNutrients = responseBody.getJSONObject("totalNutrients").toMap();
            HashMap<String, Float> nutrients = new HashMap<>();
            Set<String> nutrientNames = totalNutrients.keySet();
            for (String nutrient : nutrientNames) {
                Map nutrientInfo = (Map) totalNutrients.get(nutrient);
                if (nutrientInfo.containsKey("quantity")) {
                    Object quantityObj = nutrientInfo.get("quantity");

                    // Check if the quantity is a Number and cast it to Float
                    if (quantityObj instanceof Number) {
                        Float nutrientQuantity = ((Number) quantityObj).floatValue();
                        nutrients.put(nutrient, nutrientQuantity);
                    }
                }
            }
            HashMap<String, Float> nutrientsFRFR = new HashMap<>();
            nutrientsFRFR.put("Calories", nutrients.get("ENERC_KCAL"));
            nutrientsFRFR.put("Carbs", nutrients.get("CHOCDF"));
            nutrientsFRFR.put("Protein", nutrients.get("PROCNT"));
            nutrientsFRFR.put("Fat", nutrients.get("FAT"));
            return nutrientsFRFR;
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Integer getFoodCalories(String foodName, Float quantity) {

        String foodParameter;

        foodParameter = String.valueOf(quantity) + foodName;

        OkHttpClient client = new OkHttpClient();

        try {
            // Build correct URL with appropriate parameters, in this case I'm using the API to find the nutritional
            // content of rice.
            HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.edamam.com/api/nutrition-data").newBuilder();
            urlBuilder.addQueryParameter("app_id", APP_ID);
            urlBuilder.addQueryParameter("app_key", APP_KEY);
            urlBuilder.addQueryParameter("ingr", foodParameter);
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
}