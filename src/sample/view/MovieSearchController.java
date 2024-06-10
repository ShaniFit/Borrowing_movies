package sample.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import sample.db.Movie;

public class MovieSearchController extends HelloController{

    @FXML
    private Label category1;

    @FXML
    private Label category2;

    @FXML
    private Label category3;

    @FXML
    private Label category4;

    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;

    @FXML
    private ImageView image3;

    @FXML
    private ImageView image4;

    @FXML
    private AnchorPane movie1;

    @FXML
    private AnchorPane movie2;

    @FXML
    private AnchorPane movie3;

    @FXML
    private AnchorPane movie4;

    @FXML
    private Label title1;

    @FXML
    private Label title2;

    @FXML
    private Label title3;

    @FXML
    private Label title4;

    @FXML
    void enterMovie(MouseEvent event) {
        // TODO - pass id to the next screen instead of 1
        selectedMovie = Movie.getMovieById(1);
        handleNextScreenButton("resources/movieOrder.fxml");
    }

}
