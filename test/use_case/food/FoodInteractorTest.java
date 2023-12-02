package use_case.food;

import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.*;

public class FoodInteractorTest {

    @Test
    public void execute() {
    }

    JSONObject multipleFoodObject = new JSONObject();
    JSONObject singularFoodObject = new JSONObject();
    JSONObject water = new JSONObject();
    JSONObject noQUantityObject = new JSONObject();
    JSONObject noFoodNameObject = new JSONObject();
    JSONObject noParameterObject = new JSONObject();

    String multipleFoodResponseString = "{\n" +
            "    \"uri\": \"http://www.edamam.com/ontologies/edamam.owl#recipe_8464ddd6d8e249ae893245fb7170c5a3\",\n" +
            "    \"calories\": 7020,\n" +
            "    \"totalCO2Emissions\": 2738.619,\n" +
            "    \"co2EmissionsClass\": \"C\",\n" +
            "    \"totalWeight\": 1950.0,\n" +
            "    \"dietLabels\": [\n" +
            "        \"LOW_FAT\",\n" +
            "        \"LOW_SODIUM\"\n" +
            "    ],\n" +
            "    \"healthLabels\": [\n" +
            "        \"LOW_FAT_ABS\",\n" +
            "        \"SUGAR_CONSCIOUS\",\n" +
            "        \"LOW_SUGAR\",\n" +
            "        \"LOW_POTASSIUM\",\n" +
            "        \"KIDNEY_FRIENDLY\",\n" +
            "        \"VEGAN\",\n" +
            "        \"VEGETARIAN\",\n" +
            "        \"PESCATARIAN\",\n" +
            "        \"MEDITERRANEAN\",\n" +
            "        \"DASH\",\n" +
            "        \"DAIRY_FREE\",\n" +
            "        \"GLUTEN_FREE\",\n" +
            "        \"WHEAT_FREE\",\n" +
            "        \"EGG_FREE\",\n" +
            "        \"MILK_FREE\",\n" +
            "        \"PEANUT_FREE\",\n" +
            "        \"TREE_NUT_FREE\",\n" +
            "        \"SOY_FREE\",\n" +
            "        \"FISH_FREE\",\n" +
            "        \"SHELLFISH_FREE\",\n" +
            "        \"PORK_FREE\",\n" +
            "        \"RED_MEAT_FREE\",\n" +
            "        \"CRUSTACEAN_FREE\",\n" +
            "        \"CELERY_FREE\",\n" +
            "        \"MUSTARD_FREE\",\n" +
            "        \"SESAME_FREE\",\n" +
            "        \"LUPINE_FREE\",\n" +
            "        \"MOLLUSK_FREE\",\n" +
            "        \"ALCOHOL_FREE\",\n" +
            "        \"NO_OIL_ADDED\",\n" +
            "        \"NO_SUGAR_ADDED\",\n" +
            "        \"SULPHITE_FREE\",\n" +
            "        \"FODMAP_FREE\",\n" +
            "        \"KOSHER\"\n" +
            "    ],\n" +
            "    \"cautions\": [],\n" +
            "    \"totalNutrients\": {\n" +
            "        \"ENERC_KCAL\": {\n" +
            "            \"label\": \"Energy\",\n" +
            "            \"quantity\": 7020.0,\n" +
            "            \"unit\": \"kcal\"\n" +
            "        },\n" +
            "        \"FAT\": {\n" +
            "            \"label\": \"Total lipid (fat)\",\n" +
            "            \"quantity\": 11.309999999999999,\n" +
            "            \"unit\": \"g\"\n" +
            "        },\n" +
            "        \"FASAT\": {\n" +
            "            \"label\": \"Fatty acids, total saturated\",\n" +
            "            \"quantity\": 3.081,\n" +
            "            \"unit\": \"g\"\n" +
            "        },\n" +
            "        \"FAMS\": {\n" +
            "            \"label\": \"Fatty acids, total monounsaturated\",\n" +
            "            \"quantity\": 3.5295,\n" +
            "            \"unit\": \"g\"\n" +
            "        },\n" +
            "        \"FAPU\": {\n" +
            "            \"label\": \"Fatty acids, total polyunsaturated\",\n" +
            "            \"quantity\": 3.0225,\n" +
            "            \"unit\": \"g\"\n" +
            "        },\n" +
            "        \"CHOCDF\": {\n" +
            "            \"label\": \"Carbohydrate, by difference\",\n" +
            "            \"quantity\": 1546.35,\n" +
            "            \"unit\": \"g\"\n" +
            "        },\n" +
            "        \"CHOCDF.net\": {\n" +
            "            \"label\": \"Carbohydrates (net)\",\n" +
            "            \"quantity\": 1546.35,\n" +
            "            \"unit\": \"g\"\n" +
            "        },\n" +
            "        \"PROCNT\": {\n" +
            "            \"label\": \"Protein\",\n" +
            "            \"quantity\": 128.895,\n" +
            "            \"unit\": \"g\"\n" +
            "        },\n" +
            "        \"CHOLE\": {\n" +
            "            \"label\": \"Cholesterol\",\n" +
            "            \"quantity\": 0.0,\n" +
            "            \"unit\": \"mg\"\n" +
            "        },\n" +
            "        \"NA\": {\n" +
            "            \"label\": \"Sodium, Na\",\n" +
            "            \"quantity\": 19.5,\n" +
            "            \"unit\": \"mg\"\n" +
            "        },\n" +
            "        \"CA\": {\n" +
            "            \"label\": \"Calcium, Ca\",\n" +
            "            \"quantity\": 175.5,\n" +
            "            \"unit\": \"mg\"\n" +
            "        },\n" +
            "        \"MG\": {\n" +
            "            \"label\": \"Magnesium, Mg\",\n" +
            "            \"quantity\": 682.5,\n" +
            "            \"unit\": \"mg\"\n" +
            "        },\n" +
            "        \"K\": {\n" +
            "            \"label\": \"Potassium, K\",\n" +
            "            \"quantity\": 1677.0,\n" +
            "            \"unit\": \"mg\"\n" +
            "        },\n" +
            "        \"FE\": {\n" +
            "            \"label\": \"Iron, Fe\",\n" +
            "            \"quantity\": 15.600000000000001,\n" +
            "            \"unit\": \"mg\"\n" +
            "        },\n" +
            "        \"ZN\": {\n" +
            "            \"label\": \"Zinc, Zn\",\n" +
            "            \"quantity\": 22.619999999999997,\n" +
            "            \"unit\": \"mg\"\n" +
            "        },\n" +
            "        \"P\": {\n" +
            "            \"label\": \"Phosphorus, P\",\n" +
            "            \"quantity\": 2106.0,\n" +
            "            \"unit\": \"mg\"\n" +
            "        },\n" +
            "        \"VITC\": {\n" +
            "            \"label\": \"Vitamin C, total ascorbic acid\",\n" +
            "            \"quantity\": 0.0,\n" +
            "            \"unit\": \"mg\"\n" +
            "        },\n" +
            "        \"THIA\": {\n" +
            "            \"label\": \"Thiamin\",\n" +
            "            \"quantity\": 1.3650000000000002,\n" +
            "            \"unit\": \"mg\"\n" +
            "        },\n" +
            "        \"RIBF\": {\n" +
            "            \"label\": \"Riboflavin\",\n" +
            "            \"quantity\": 0.936,\n" +
            "            \"unit\": \"mg\"\n" +
            "        },\n" +
            "        \"NIA\": {\n" +
            "            \"label\": \"Niacin\",\n" +
            "            \"quantity\": 31.200000000000003,\n" +
            "            \"unit\": \"mg\"\n" +
            "        },\n" +
            "        \"VITB6A\": {\n" +
            "            \"label\": \"Vitamin B-6\",\n" +
            "            \"quantity\": 2.8274999999999997,\n" +
            "            \"unit\": \"mg\"\n" +
            "        },\n" +
            "        \"FOLDFE\": {\n" +
            "            \"label\": \"Folate, DFE\",\n" +
            "            \"quantity\": 175.5,\n" +
            "            \"unit\": \"µg\"\n" +
            "        },\n" +
            "        \"FOLFD\": {\n" +
            "            \"label\": \"Folate, food\",\n" +
            "            \"quantity\": 175.5,\n" +
            "            \"unit\": \"µg\"\n" +
            "        },\n" +
            "        \"FOLAC\": {\n" +
            "            \"label\": \"Folic acid\",\n" +
            "            \"quantity\": 0.0,\n" +
            "            \"unit\": \"µg\"\n" +
            "        },\n" +
            "        \"VITB12\": {\n" +
            "            \"label\": \"Vitamin B-12\",\n" +
            "            \"quantity\": 0.0,\n" +
            "            \"unit\": \"µg\"\n" +
            "        },\n" +
            "        \"VITD\": {\n" +
            "            \"label\": \"Vitamin D (D2 + D3)\",\n" +
            "            \"quantity\": 0.0,\n" +
            "            \"unit\": \"µg\"\n" +
            "        },\n" +
            "        \"WATER\": {\n" +
            "            \"label\": \"Water\",\n" +
            "            \"quantity\": 251.55,\n" +
            "            \"unit\": \"g\"\n" +
            "        }\n" +
            "    },\n" +
            "    \"totalDaily\": {\n" +
            "        \"ENERC_KCAL\": {\n" +
            "            \"label\": \"Energy\",\n" +
            "            \"quantity\": 351.0,\n" +
            "            \"unit\": \"%\"\n" +
            "        },\n" +
            "        \"FAT\": {\n" +
            "            \"label\": \"Fat\",\n" +
            "            \"quantity\": 17.399999999999995,\n" +
            "            \"unit\": \"%\"\n" +
            "        },\n" +
            "        \"FASAT\": {\n" +
            "            \"label\": \"Saturated\",\n" +
            "            \"quantity\": 15.405000000000001,\n" +
            "            \"unit\": \"%\"\n" +
            "        },\n" +
            "        \"CHOCDF\": {\n" +
            "            \"label\": \"Carbs\",\n" +
            "            \"quantity\": 515.45,\n" +
            "            \"unit\": \"%\"\n" +
            "        },\n" +
            "        \"PROCNT\": {\n" +
            "            \"label\": \"Protein\",\n" +
            "            \"quantity\": 257.79,\n" +
            "            \"unit\": \"%\"\n" +
            "        },\n" +
            "        \"CHOLE\": {\n" +
            "            \"label\": \"Cholesterol\",\n" +
            "            \"quantity\": 0.0,\n" +
            "            \"unit\": \"%\"\n" +
            "        },\n" +
            "        \"NA\": {\n" +
            "            \"label\": \"Sodium\",\n" +
            "            \"quantity\": 0.8125,\n" +
            "            \"unit\": \"%\"\n" +
            "        },\n" +
            "        \"CA\": {\n" +
            "            \"label\": \"Calcium\",\n" +
            "            \"quantity\": 17.55,\n" +
            "            \"unit\": \"%\"\n" +
            "        },\n" +
            "        \"MG\": {\n" +
            "            \"label\": \"Magnesium\",\n" +
            "            \"quantity\": 162.5,\n" +
            "            \"unit\": \"%\"\n" +
            "        },\n" +
            "        \"K\": {\n" +
            "            \"label\": \"Potassium\",\n" +
            "            \"quantity\": 35.680851063829785,\n" +
            "            \"unit\": \"%\"\n" +
            "        },\n" +
            "        \"FE\": {\n" +
            "            \"label\": \"Iron\",\n" +
            "            \"quantity\": 86.66666666666669,\n" +
            "            \"unit\": \"%\"\n" +
            "        },\n" +
            "        \"ZN\": {\n" +
            "            \"label\": \"Zinc\",\n" +
            "            \"quantity\": 205.6363636363636,\n" +
            "            \"unit\": \"%\"\n" +
            "        },\n" +
            "        \"P\": {\n" +
            "            \"label\": \"Phosphorus\",\n" +
            "            \"quantity\": 300.85714285714283,\n" +
            "            \"unit\": \"%\"\n" +
            "        },\n" +
            "        \"VITC\": {\n" +
            "            \"label\": \"Vitamin C\",\n" +
            "            \"quantity\": 0.0,\n" +
            "            \"unit\": \"%\"\n" +
            "        },\n" +
            "        \"THIA\": {\n" +
            "            \"label\": \"Thiamin (B1)\",\n" +
            "            \"quantity\": 113.75000000000003,\n" +
            "            \"unit\": \"%\"\n" +
            "        },\n" +
            "        \"RIBF\": {\n" +
            "            \"label\": \"Riboflavin (B2)\",\n" +
            "            \"quantity\": 72.0,\n" +
            "            \"unit\": \"%\"\n" +
            "        },\n" +
            "        \"NIA\": {\n" +
            "            \"label\": \"Niacin (B3)\",\n" +
            "            \"quantity\": 195.00000000000003,\n" +
            "            \"unit\": \"%\"\n" +
            "        },\n" +
            "        \"VITB6A\": {\n" +
            "            \"label\": \"Vitamin B6\",\n" +
            "            \"quantity\": 217.49999999999994,\n" +
            "            \"unit\": \"%\"\n" +
            "        },\n" +
            "        \"FOLDFE\": {\n" +
            "            \"label\": \"Folate equivalent (total)\",\n" +
            "            \"quantity\": 43.875,\n" +
            "            \"unit\": \"%\"\n" +
            "        },\n" +
            "        \"VITB12\": {\n" +
            "            \"label\": \"Vitamin B12\",\n" +
            "            \"quantity\": 0.0,\n" +
            "            \"unit\": \"%\"\n" +
            "        },\n" +
            "        \"VITD\": {\n" +
            "            \"label\": \"Vitamin D\",\n" +
            "            \"quantity\": 0.0,\n" +
            "            \"unit\": \"%\"\n" +
            "        }\n" +
            "    },\n" +
            "    \"ingredients\": [\n" +
            "        {\n" +
            "            \"text\": \"10 cup coffee, 20 cup rice, 30 cup fried rice\",\n" +
            "            \"parsed\": [\n" +
            "                {\n" +
            "                    \"quantity\": 10.0,\n" +
            "                    \"measure\": \"cup\",\n" +
            "                    \"foodMatch\": \"rice\",\n" +
            "                    \"food\": \"rice\",\n" +
            "                    \"foodId\": \"food_bpumdjzb5rtqaeabb0kbgbcgr4t9\",\n" +
            "                    \"weight\": 1950.0,\n" +
            "                    \"retainedWeight\": 1950.0,\n" +
            "                    \"nutrients\": {\n" +
            "                        \"RIBF\": {\n" +
            "                            \"label\": \"Riboflavin\",\n" +
            "                            \"quantity\": 0.936,\n" +
            "                            \"unit\": \"mg\"\n" +
            "                        },\n" +
            "                        \"VITD\": {\n" +
            "                            \"label\": \"Vitamin D (D2 + D3), International Units\",\n" +
            "                            \"quantity\": 0.0,\n" +
            "                            \"unit\": \"IU\"\n" +
            "                        },\n" +
            "                        \"THIA\": {\n" +
            "                            \"label\": \"Thiamin\",\n" +
            "                            \"quantity\": 1.365,\n" +
            "                            \"unit\": \"mg\"\n" +
            "                        },\n" +
            "                        \"FAPU\": {\n" +
            "                            \"label\": \"Fatty acids, total polyunsaturated\",\n" +
            "                            \"quantity\": 3.0225,\n" +
            "                            \"unit\": \"g\"\n" +
            "                        },\n" +
            "                        \"NIA\": {\n" +
            "                            \"label\": \"Niacin\",\n" +
            "                            \"quantity\": 31.2,\n" +
            "                            \"unit\": \"mg\"\n" +
            "                        },\n" +
            "                        \"ENERC_KCAL\": {\n" +
            "                            \"label\": \"Energy\",\n" +
            "                            \"quantity\": 7020.0,\n" +
            "                            \"unit\": \"kcal\"\n" +
            "                        },\n" +
            "                        \"FASAT\": {\n" +
            "                            \"label\": \"Fatty acids, total saturated\",\n" +
            "                            \"quantity\": 3.0810000000000004,\n" +
            "                            \"unit\": \"g\"\n" +
            "                        },\n" +
            "                        \"VITC\": {\n" +
            "                            \"label\": \"Vitamin C, total ascorbic acid\",\n" +
            "                            \"quantity\": 0.0,\n" +
            "                            \"unit\": \"mg\"\n" +
            "                        },\n" +
            "                        \"PROCNT\": {\n" +
            "                            \"label\": \"Protein\",\n" +
            "                            \"quantity\": 128.895,\n" +
            "                            \"unit\": \"g\"\n" +
            "                        },\n" +
            "                        \"CHOLE\": {\n" +
            "                            \"label\": \"Cholesterol\",\n" +
            "                            \"quantity\": 0.0,\n" +
            "                            \"unit\": \"mg\"\n" +
            "                        },\n" +
            "                        \"FAMS\": {\n" +
            "                            \"label\": \"Fatty acids, total monounsaturated\",\n" +
            "                            \"quantity\": 3.5295,\n" +
            "                            \"unit\": \"g\"\n" +
            "                        },\n" +
            "                        \"CHOCDF\": {\n" +
            "                            \"label\": \"Carbohydrate, by difference\",\n" +
            "                            \"quantity\": 1546.35,\n" +
            "                            \"unit\": \"g\"\n" +
            "                        },\n" +
            "                        \"FAT\": {\n" +
            "                            \"label\": \"Total lipid (fat)\",\n" +
            "                            \"quantity\": 11.31,\n" +
            "                            \"unit\": \"g\"\n" +
            "                        },\n" +
            "                        \"VITB6A\": {\n" +
            "                            \"label\": \"Vitamin B-6\",\n" +
            "                            \"quantity\": 2.8275,\n" +
            "                            \"unit\": \"mg\"\n" +
            "                        },\n" +
            "                        \"VITB12\": {\n" +
            "                            \"label\": \"Vitamin B-12\",\n" +
            "                            \"quantity\": 0.0,\n" +
            "                            \"unit\": \"µg\"\n" +
            "                        },\n" +
            "                        \"WATER\": {\n" +
            "                            \"label\": \"Water\",\n" +
            "                            \"quantity\": 251.55,\n" +
            "                            \"unit\": \"g\"\n" +
            "                        },\n" +
            "                        \"K\": {\n" +
            "                            \"label\": \"Potassium, K\",\n" +
            "                            \"quantity\": 1677.0,\n" +
            "                            \"unit\": \"mg\"\n" +
            "                        },\n" +
            "                        \"P\": {\n" +
            "                            \"label\": \"Phosphorus, P\",\n" +
            "                            \"quantity\": 2106.0,\n" +
            "                            \"unit\": \"mg\"\n" +
            "                        },\n" +
            "                        \"NA\": {\n" +
            "                            \"label\": \"Sodium, Na\",\n" +
            "                            \"quantity\": 19.5,\n" +
            "                            \"unit\": \"mg\"\n" +
            "                        },\n" +
            "                        \"ZN\": {\n" +
            "                            \"label\": \"Zinc, Zn\",\n" +
            "                            \"quantity\": 22.62,\n" +
            "                            \"unit\": \"mg\"\n" +
            "                        },\n" +
            "                        \"CA\": {\n" +
            "                            \"label\": \"Calcium, Ca\",\n" +
            "                            \"quantity\": 175.5,\n" +
            "                            \"unit\": \"mg\"\n" +
            "                        },\n" +
            "                        \"MG\": {\n" +
            "                            \"label\": \"Magnesium, Mg\",\n" +
            "                            \"quantity\": 682.5,\n" +
            "                            \"unit\": \"mg\"\n" +
            "                        },\n" +
            "                        \"FE\": {\n" +
            "                            \"label\": \"Iron, Fe\",\n" +
            "                            \"quantity\": 15.6,\n" +
            "                            \"unit\": \"mg\"\n" +
            "                        },\n" +
            "                        \"FOLFD\": {\n" +
            "                            \"label\": \"Folate, food\",\n" +
            "                            \"quantity\": 175.5,\n" +
            "                            \"unit\": \"µg\"\n" +
            "                        },\n" +
            "                        \"FOLAC\": {\n" +
            "                            \"label\": \"Folic acid\",\n" +
            "                            \"quantity\": 0.0,\n" +
            "                            \"unit\": \"µg\"\n" +
            "                        },\n" +
            "                        \"FOLDFE\": {\n" +
            "                            \"label\": \"Folate, DFE\",\n" +
            "                            \"quantity\": 175.5,\n" +
            "                            \"unit\": \"µg\"\n" +
            "                        }\n" +
            "                    },\n" +
            "                    \"measureURI\": \"http://www.edamam.com/ontologies/edamam.owl#Measure_cup\",\n" +
            "                    \"status\": \"OK\"\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ],\n" +
            "    \"totalNutrientsKCal\": {\n" +
            "        \"ENERC_KCAL\": {\n" +
            "            \"label\": \"Energy\",\n" +
            "            \"quantity\": 7020,\n" +
            "            \"unit\": \"kcal\"\n" +
            "        },\n" +
            "        \"PROCNT_KCAL\": {\n" +
            "            \"label\": \"Calories from protein\",\n" +
            "            \"quantity\": 532,\n" +
            "            \"unit\": \"kcal\"\n" +
            "        },\n" +
            "        \"FAT_KCAL\": {\n" +
            "            \"label\": \"Calories from fat\",\n" +
            "            \"quantity\": 105,\n" +
            "            \"unit\": \"kcal\"\n" +
            "        },\n" +
            "        \"CHOCDF_KCAL\": {\n" +
            "            \"label\": \"Calories from carbohydrates\",\n" +
            "            \"quantity\": 6383,\n" +
            "            \"unit\": \"kcal\"\n" +
            "        }\n" +
            "    }\n" +
            "}";
}