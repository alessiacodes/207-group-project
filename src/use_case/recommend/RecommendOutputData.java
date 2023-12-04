package use_case.recommend;


public class RecommendOutputData {

    private final String recommendLink;


    public RecommendOutputData(String recommendLink){
        this.recommendLink = recommendLink;
    }


    public String getRecommendLink(){
        return recommendLink;
    }

}
