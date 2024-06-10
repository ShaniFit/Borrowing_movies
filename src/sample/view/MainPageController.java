package sample.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import sample.db.Movie;
import sample.db.User;


public class MainPageController  extends HelloController implements Initializable {

    @FXML
    private ChoiceBox<String> choiceAll;

    @FXML
    private TextField searchWord;

    @FXML
    private AnchorPane movie2;

    @FXML
    private AnchorPane movie3;

    @FXML
    private AnchorPane movie4;

    @FXML
    private AnchorPane movie5;

    @FXML
    private AnchorPane movie6;

    @FXML
    private AnchorPane movie7;

    @FXML
    private AnchorPane movie8;

    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;

    @FXML
    private ImageView image3;

    @FXML
    private ImageView image4;

    @FXML
    private ImageView image5;

    @FXML
    private ImageView image6;

    @FXML
    private ImageView image7;

    @FXML
    private ImageView image8;
    @FXML
    private Label title1;

    @FXML
    private Label title2;

    @FXML
    private Label title3;

    @FXML
    private Label title4;

    @FXML
    private Label title5;

    @FXML
    private Label title6;

    @FXML
    private Label title7;

    @FXML
    private Label title8;
    @FXML
    private Label category1;

    @FXML
    private Label category2;

    @FXML
    private Label category3;

    @FXML
    private Label category4;

    @FXML
    private Label category5;

    @FXML
    private Label category6;

    @FXML
    private Label category7;

    @FXML
    private Label category8;

    @FXML
    private Button addMovie;

    @FXML
    private Button viewOrders;

    void loadMovies() {
        // Load the movies from the database and display them in movie1, movie2, ..., movie8.
        // For each movie, set the title, category, and image.
        // If there are fewer than 8 movies, hide the remaining movie panes.
        // get user choice
        String choice = choiceAll.getValue();
        Movie[] movies;
        switch (choice) {
        case "Title":
            movies = Movie.loadAvailableMoviesByTitle(searchWord.getText());
        case "Category":
            movies = Movie.loadAvailableMoviesByCategory(searchWord.getText());
        case "Duration":
            movies = Movie.loadAvailableMoviesByDuration(Integer.parseInt(searchWord.getText()));
        default:
            movies = Movie.loadAvailableMovies();}
        // TODO - UI - Load the movies into the UI - 8 movies
        for (int i = 0; i < movies.length; i++) {
            AnchorPane movie = (AnchorPane) movie2.getParent().getChildrenUnmodifiable().get(i);
            ImageView image = (ImageView) movie.getChildren().get(0);
            Label title = (Label) movie.getChildren().get(1);
            Label category = (Label) movie.getChildren().get(2);
            image.setImage(movies[i].getImage());
            title.setText(movies[i].getMovieTitle());
            category.setText(movies[i].getCategory());
        }
    }

    @FXML
    void pressViewOrders(ActionEvent event) {
        handleNextScreenButton("resources/ordersView.fxml");
    }

    @FXML
    void pressAddMovie(ActionEvent event) {
        handleNextScreenButton("resources/addMovie.fxml");
    }

    @FXML
    private void searchButton(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
                String text = searchWord.getText();
                handleNextScreenButton("resources/movieSearch.fxml");
            }
    }
    @FXML
    void enterMovie(MouseEvent event) {
        handleNextScreenButton("resources/movieSearch.fxml");
    }

    private String[] choice={"Title","Category","Duration"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(!isAdmin) {
            addMovie.setVisible(false);
            viewOrders.setVisible(false);
        }
        choiceAll.getItems().addAll(choice);
    }


}
