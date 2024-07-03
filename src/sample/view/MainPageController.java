package sample.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import sample.db.Category;
import sample.db.Movie;
import sample.db.User;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MainPageController  extends HelloController implements Initializable {




    @FXML
    private AnchorPane rootAnchor;

    @FXML
    private ChoiceBox<String> choiceAll;

    @FXML
    private TextField searchWord;

    @FXML
    private GridPane grid;

    @FXML
    private Button addMovie;

    @FXML
    private Button viewOrders;
// TODO - UI - shir - fix the problem that before searching we can select movie
    private void AAAAloadMoviesByKey() {
        // Load the movies from the database and display them in movie1, movie2, ..., movie8.
        // For each movie, set the title, category, and image.
        // If there are fewer than 8 movies, hide the remaining movie panes.
        // get user choice
        Movie m  = new Movie();
        String choice = choiceAll.getSelectionModel().getSelectedItem();
        Movie[] movies;

        switch (choice) {
            case "Title":
                System.out.println(searchWord.getText());
                movies = m.exportMovieByTitle(searchWord.getText());
            case "Category":
                Category c = new Category();
                Category category = c.getCategoryByName(searchWord.getText());
                movies = m.exportMovieByCategory(searchWord.getText());
            case "Duration":
                movies = m.exportMovieByDuration(searchWord.getText());
            case "All":
                movies = m.exportMovie();
            }

        // TODO - UI - Load the movies into the UI - 8 movies
//        title1.setText("movies[0].getMovieTitle()");
//        for (int i = 0; i < movies.length; i++) {
//            AnchorPane movie = (AnchorPane) movie2.getParent().getChildrenUnmodifiable().get(i);
//            ImageView image = (ImageView) movie.getChildren().get(0);
//            Label title = (Label) movie.getChildren().get(1);
//            Label category = (Label) movie.getChildren().get(2);
////            image.setImage(movies[i].getImage());
//            title.setText(movies[i].getMovieTitle());
////            category.setText(movies[i].getCategory());
//        }
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
                userSearchWord = searchWord.getText();
                userSearchFilter = choiceAll.getSelectionModel().getSelectedItem();
                handleNextScreenButton("resources/movieSearch.fxml");
            }
    }

    @FXML
    void enterMovie(MouseEvent event) {
        handleNextScreenButton("resources/movieSearch.fxml");
    }

    private String[] choice={"All","Title","Category","Duration"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        if (selectedMovie != null) {
            System.out.println("Clicked on " + selectedMovie.getMovieTitle());
            createScreen(2,4,"resources/movieOrder.fxml",false);
        }
        createScreen(2,4,"resources/movieSearch.fxml",true);

        if (!isAdmin) {
            addMovie.setVisible(false);
            viewOrders.setVisible(false);
        }
        choiceAll.getItems().addAll(choice);
        choiceAll.setValue("All");
    }

    protected void createScreen(int rows, int cols, String toMove, boolean hasImage){
        // movie grid
        Movie[] movies;
        Movie m  = new Movie();
        movies = m.exportMovie();
        int movieNum=0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                AnchorPane newPane = createAnchorPane(hasImage,movies[movieNum],toMove);
                grid.setVgap(10);
                grid.add(newPane, j, i);
                movieNum++;
            }
        }
    }

    private AnchorPane createAnchorPane(boolean hasImage, Movie movie, String toMove) {
        AnchorPane anchorPane = new AnchorPane();
        System.out.println(movie.getMovieTitle());
        Label title= createLabel(movie.getMovieTitle());
        Label category= createLabel(movie.getCategory());
        Label orderId= createLabel(Integer.toString(selectedOrder.getOrderID()));
        Label userName= createLabel(currentUser.getUserName());
        Label price = createLabel(Integer.toString(movie.getPrice()));
        Label returnDate=createLabel(selectedOrder.getDate());


        VBox vbox = new VBox(5);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(5);

        if(hasImage) {
            Image image = new Image(getClass().getResourceAsStream(movie.getImagePath()));
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(300); // image size
            imageView.setFitHeight(250);
            imageView.setPreserveRatio(true);
            vbox.getChildren().addAll(imageView, title, category);
        }
        else {
            vbox.setPadding(new Insets(10)); // ריווח פנימי
            vbox.setBorder(new Border(new BorderStroke(
                    Color.WHITE,
                    BorderStrokeStyle.SOLID,
                    new CornerRadii(5),
                    new BorderWidths(2))));
            vbox.getChildren().addAll(orderId,userName, title, price,returnDate);
        }

        // Add click event to the AnchorPane
        anchorPane.setOnMouseClicked(event -> {
            try {
                selectedMovie = movie;
                // Load the next scene
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("resources/movieOrder.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = (Stage) anchorPane.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        anchorPane.getChildren().add(vbox);
        //place the anchor in vbox
        AnchorPane.setTopAnchor(vbox, 10.0);
        AnchorPane.setLeftAnchor(vbox, 10.0);
        AnchorPane.setRightAnchor(vbox, 10.0);
        AnchorPane.setBottomAnchor(vbox, 10.0);


        return anchorPane;
    }

    private Label createLabel(String str){
        Label label = new Label(str);
        label.setStyle("-fx-text-fill: white;");
        return label;
    }
}
