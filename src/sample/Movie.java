package sample;

public class Movie extends DBimport{
    private int movieID;
    private String movieTitle;
    private String description;
    private String releaseDate;
    private int duration;
    private int categoryID;
    private boolean isAvailable;

    public Movie(int movieID, String movieTitle, String description, String releaseDate, int duration, int categoryID, boolean isAvailable) {
        this.movieID = movieID;
        this.movieTitle = movieTitle;
        this.description = description;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.categoryID = categoryID;
        this.isAvailable = isAvailable;
    }
    public void newMovie()
    {
        try {
            insertNewMovie(movieID, movieTitle, description, releaseDate,
            duration, categoryID, isAvailable);
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
}
