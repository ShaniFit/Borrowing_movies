package sample.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.layout.AnchorPane;
import sample.db.Category;
import sample.db.Movie;

public class MovieSearchController extends MainPageController{

    @FXML
    private GridPane grid;

    @FXML
    void enterMovie(MouseEvent event) {
        selectedMovie = new Movie();
        handleNextScreenButton("resources/movieOrder.fxml");
    }
    @FXML
    void enterHome(MouseEvent event) {
        handleNextScreenButton("resources/mainPage.fxml");
    }
    private Movie[] loadMoviesByKey() {
        Movie m  = new Movie();
        Movie[] movies = null;
        // TODO  fix those export methods
        if(userSearchFilter.equals("Category")){
            movies = m.exportMovieByCategory(userSearchWord);
        } else if (userSearchFilter.equals("Title")){
            movies = m.exportMovieByTitle(userSearchWord);
        } else if (userSearchFilter.equals("Duration")){
            movies = m.exportMovieByDuration(userSearchWord);
        } else {
            movies = m.exportMovie();
        }
        return movies;
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        Movie[] movies = loadMoviesByKey();//?
        createScreen(1,4, "resources/movieOrder.fxml",true, movies);
    }
}
