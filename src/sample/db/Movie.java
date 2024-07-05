package sample.db;


import javafx.scene.image.Image;

import java.sql.PreparedStatement;
import java.util.Random;

public class Movie extends DBimport{
    private int movieID;
    private String movieTitle;
    private String description;
    private String releaseDate;
    private String duration;
    private int categoryID;
    private int isAvailable;
    private int price;

    public Movie(int movieID, String movieTitle, String description, String releaseDate,
                 String duration, int categoryID, int isAvailable, int price) {
        if (movieID == -1) {
            Random rand = new Random();
            this.movieID = rand.nextInt(9999);
        } else {
            this.movieID = movieID;
        }
        this.movieTitle = movieTitle;
        this.description = description;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.categoryID = categoryID;
        this.isAvailable = isAvailable;
        this.price = price;

    }
    public Movie(){
        this.movieID = -1;
        this.movieTitle = null;
        this.description = null;
        this.releaseDate = null;
        this.duration ="";
        this.categoryID = 0;
        this.isAvailable = 0;
        this.price = 0;
    }

    public int getPrice() {
        return price;
    }

    public void addNewMovieToDB()
    {
        try {
            insertNewMovie(movieID, movieTitle, description, releaseDate, duration, categoryID, isAvailable, price);
            System.out.println("add successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Movie exportMovieById(int movieId) {
        return super.exportMovieById(movieId);
    }

    public Movie[] exportMovieByCategory(String categoryName)
    {   Category c = new Category();
        Category newC = c.getCategoryByName(categoryName);
        return super.exportMovieByCategory(newC.getCategoryID());
    }

    public Movie[] exportMovie()
    {
        return super.exportMovie();
    }
    public Movie[] exportMovieByTitle(String movieTitle)
    {
        return super.exportMovieByTitle(movieTitle);
    }public Movie[] exportMovieByDuration(String duration)
    {
        return super.exportMovieByDuration(duration);
    }

    public int getMovieID() {
    return movieID;
}

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getIsAvailable() {
        return isAvailable;
    }
    public void setAvailable(int available) {
        isAvailable = available;
    }

    public String getCategory() {
        Category c = new Category();
        return c.getCategoryByID(categoryID).getCategoryName();
    }

    public String  getImagePath() {
        return "resources/movie_images/" +movieID+".jpeg";
    }

    public void updateMovieInDB() {
        // TODO - update the movie in the db
    }
    public void updateIsAvilable(int isAvilable)
    {
        this.isAvailable = isAvilable;
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE movie SET isAvailable = ? WHERE MovieID = ?");
            statement.setInt(1, isAvilable); // Set the value for the first placeholder to the value of the userName variable
            statement.setInt(2, movieID);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
