package use_case.recommend;

import java.util.ArrayList;

import entity.Recommend;

public interface RecommendDataAccessInterface {
    // data access objects must have a method to get a link to a recommended recipe as per the use case
    String getRecommendLink(Recommend identifier);

}
