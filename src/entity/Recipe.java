package entity;

public class Recipe {
    private final String recipeName;

    private final Integer kCal;

    private final LinkedHashMap<Food, Integer> ingredients;

    Recipe(String recipeName, Integer kCal, LinkedHashMap<Food, Integer> ingredients) {
        this.recipeName = recipeName;
        this.kCal = kCal;
        this.ingredients = ingredients;
    }

    public double getTotalCalories() {
        ...;
    }

    public double getTotalNutrients() {
        ...;
    }

    public void addFood() {
        ...;
    }

    @Override
    public String getRecipeName() {return recipeName;}

    @Override
    public Integer getkCal() {return kCal;}

    @Override
    public LinkedHashMap<Food, Integer> getIngredients() {return ingredients;}

}
