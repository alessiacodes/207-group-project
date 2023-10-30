public class LoginInputData {

    private String name;
    private String gender;
    private int age;
    private Double height;
    private ArrayList<String> dietaryRestrictions;
    private Double weight; 

    public LoginInputData(String name,
                        String gender,
                        int age,
                        Double height,
                        ArrayList<String> dietaryRestrictions,
                        Double weight) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.dietaryRestrictions = dietaryRestrictions;
        this.weight = weight;
    }

    public String getName() { return name; }

    public String getGender() {
        return gender;
    }
    
    public int getAge() {
        return age;
    }
    
    public Double getHeight() {
        return height;
    }

    public ArrayList<String> getDietaryRestrictions() {
        return dietaryRestrictions;
    }

    public Double weight() {
        return weight;
    }
}