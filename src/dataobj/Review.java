package src.dataobj;

public class Review {
    int rateId;
    int rate;
    String review;
    int movieId;
    int userId;
    static int idCounter = 0;

    public Review(int rate, String review, int movieId, int userId){
        this.rate = rate;
        this.review = review;
        this.movieId = movieId;
        this.userId = userId;
        this.rateId = idCounter++;
    }

    public int getRate(){
        return rate;
    }
    public String getReview(){
        return review;
    }
    public void setRate(int rate){
        this.rate = rate;
    }
    public void setReview(String review){
        this.review = review;
    }
    public int getMovieId(){
        return movieId;
    }
    public int getUserId(){
        return userId;
    }
    public void setMovieId(int movieId){
        this.movieId = movieId;
    }
    public void setUserId(int userId){
        this.userId = userId;
    }

    public static Review loadreviewfromDBbyID(int rateId){
        return new Review(5, "Great movie", 1, 1);
    }
    public static Review loadreviewfromDBbyMovie(int movieId){
        return new Review(5, "Great movie", 1, 1);
    }
    public void savereviewtoDB(){
        System.out.println("Review saved to DB");
    }
    public void deletereviewfromDB(){
        System.out.println("Review deleted from DB");
    }

}
