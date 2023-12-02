package use_case.recommend;


public class RecommendOutputData {

    private final String recommendLink; //not sure if this would be strings


    public RecommendOutputData(String recommendLink){
        this.recommendLink = recommendLink;
    }


    public String getRecommendLink(){
        return recommendLink;
    }

}
