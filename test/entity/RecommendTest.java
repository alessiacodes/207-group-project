package entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RecommendTest {

    private Recommend recommend;

    ArrayList<String> diet = new ArrayList<String>();

    ArrayList<String> health = new ArrayList<String>();

    @BeforeEach
    void init(){
        diet.add("vegan");
        health.add("high-proetin");
        recommend = new Recommend(diet, health, "dinner");
    }

    @Test
    public void getDiet() {
        assertEquals(diet, recommend.getDiet());
    }

    @Test
    public void getHealth() {
    }

    @Test
    public void getMealType() {
    }
}