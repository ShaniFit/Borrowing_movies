package sample.db;

import javafx.scene.image.Image;

import java.sql.PreparedStatement;
import java.util.Random;

public class Movie extends DBimport{
    private int movieID;
    private String movieTitle;
    private String description;
    private String releaseDate;
    private int duration;
    private int categoryID;
    private boolean isAvailable;
    private int price;

    public Movie(int movieID, String movieTitle, String description, String releaseDate, int duration, int categoryID, boolean isAvailable, int price) {
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
        this.duration = 0;
        this.categoryID = 0;
        this.isAvailable = false;
        this.price = 0;
    }

    public static Movie getMovieById(int i) {
        return Movie.exportMovieById(i);
    }

    public void addMovieToDB()
    {
        try {
            insertNewMovie(movieID, movieTitle, description, releaseDate,
            duration, categoryID, isAvailable, price);
            System.out.println("add successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    public static Movie[] loadAvailableMovies() {
        return Movie.exportAllAvilibleMovies();
    }
    public static Movie[] loadAvailableMoviesByCategory(String category)
    {
        return DBimport.exportMovieByCategory(Category.catgtoryNameToCategoryID(category));
    }
    public static Movie[] loadAvailableMoviesByDuration(int duration)
    {
        return Movie.exportMovieByDuration(duration);
    }
    public static Movie[] loadAvailableMoviesByTitle(String title)
    {
        return Movie.exportMovieByTitle(title);
    }

    public Image getImage() {
        return new Image("file:src/sample/images/"+movieID+".jpeg");
    }

    public String getCategory() {
        return Category.categoryIdToCategoryName(categoryID);
    }

    public void orderMovie(String text) {
        Order order = new Order(-1, price, text, 1, movieID);
        order.newOrder();
        // TODO - UI - show order success, or go to home page?
    }
    // TODO - fix the sql query
    protected static Movie[] exportMovieByDuration(int duration) {
        Movie[] movies = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM movie WHERE Duration = ?");
            statement.setInt(1, duration); // Set the value for the first placeholder to the value of the duration variable

            resultSet = statement.executeQuery();

            movies = new Movie[resultSet.getFetchSize()];
            while (resultSet.next()) {
                // add movie to the array
                movies[resultSet.getRow()] = new Movie(resultSet.getInt("MovieID"), resultSet.getString("MovieTitle"),
                        resultSet.getString("Description"), resultSet.getString("ReleaseDate"),
                        resultSet.getInt("Duration"), resultSet.getInt("CategoryID"), resultSet.getBoolean("IsAvailable"), resultSet.getInt("Price"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movies;
    }
    // TODO - fix the sql query
    protected static Movie[] exportMovieByTitle(String title) {
        Movie[] movies = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM movie WHERE MovieTitle = ?");
            statement.setString(1, title); // Set the value for the first placeholder to the value of the title variable

            resultSet = statement.executeQuery();

            movies = new Movie[resultSet.getFetchSize()];
            while (resultSet.next()) {
                // add movie to the array
                movies[resultSet.getRow()] = new Movie(resultSet.getInt("MovieID"), resultSet.getString("MovieTitle"),
                        resultSet.getString("Description"), resultSet.getString("ReleaseDate"),
                        resultSet.getInt("Duration"), resultSet.getInt("CategoryID"), resultSet.getBoolean("IsAvailable"), resultSet.getInt("Price"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movies;
    }
    // TODO - fix the sql query
    protected static Movie[] exportAllAvilibleMovies() {
        Movie[] movies = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM movie?");

            resultSet = statement.executeQuery("SELECT * FROM movie WHERE IsAvailable = true");

            movies = new Movie[resultSet.getFetchSize()];
            while (resultSet.next()) {
                // add movie to the array
                movies[resultSet.getRow()] = new Movie(resultSet.getInt("MovieID"), resultSet.getString("MovieTitle"),
                        resultSet.getString("Description"), resultSet.getString("ReleaseDate"),
                        resultSet.getInt("Duration"), resultSet.getInt("CategoryID"), resultSet.getBoolean("IsAvailable"), resultSet.getInt("Price"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            // TODO - temp
            Movie m = new Movie(1, "title", "description", "releaseDate", 120, 1, true, -1);
            return new Movie[]{m};
        }
        return movies;
    }
    protected static Movie exportMovieById(int i) {
        Movie movie = new Movie();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM movie WHERE MovieID = ?");
            statement.setInt(1, i); // Set the value for the first placeholder to the value of the i variable

            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                movie = new Movie(resultSet.getInt("MovieID"), resultSet.getString("MovieTitle"),
                        resultSet.getString("Description"), resultSet.getString("ReleaseDate"),
                        resultSet.getInt("Duration"), resultSet.getInt("CategoryID"), resultSet.getBoolean("IsAvailable"), resultSet.getInt("Price"));
            }
        } catch (Exception e) {
            e.printStackTrace();}
        return movie;
    }

}
