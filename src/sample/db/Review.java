package sample.db;

public class Review extends DBimport {

    private int reviewID;
    private int rating;
    private String text;
    private int userID;
    private int movieID;

    public Review(int reviewID, int rating, String text, int userID, int movieID) {
        this.reviewID = reviewID;
        this.rating = rating;
        this.text = text;
        this.userID = userID;
        this.movieID = movieID;
    }
    public void newReview()
    {
        try {
            insertNewReview(reviewID, rating, text, userID, movieID);
            System.out.println("add successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int getReviewID() {
        return reviewID;
    }

    public int getRating() {
        return rating;
    }

    public String getText() {
        return text;
    }

    public int getUserID() {
        return userID;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public Review getReviewByMoovie(int movieID) {
        // TODO: Implement this method
        // return the review of the movie
        return null;
    }
}