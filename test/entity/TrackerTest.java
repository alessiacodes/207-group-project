package entity;

import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class TrackerTest {

    private Tracker tracker;

    @Before
    public void init(){
        tracker = new Tracker();
        Food apple = new Food("apple", 1.0F);
        tracker.addFood(apple);
    }

    @Test
    public void getTotalCalories() {
        assertEquals(Optional.of(94.64), tracker.getTotalCalories());
    }

    @Test
    public void getWaterDiary() {

    }

    @Test
    public void getDiary() {

    }

    @Test
    public void updateFoodEntry() {

    }

    @Test
    public void getNutrientContent() {

    }

    @Test
    public void getTotalNutrition() {

    }

    @Test
    public void addFood() {
    }

    @Test
    public void removeFood() {
    }

    @Test
    public void isEmpty() {
    }
}