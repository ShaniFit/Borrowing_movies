package sample.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import sample.db.Movie;
import sample.db.Order;
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
            createScreen(2,4,"resources/movieOrder.fxml",false,null);
        }
        createScreen(2,4,"resources/movieSearch.fxml",true,null);

        if (!isAdmin) {
            addMovie.setVisible(false);
            viewOrders.setVisible(false);
        }
        choiceAll.getItems().addAll(choice);
        choiceAll.setValue("All");
    }

    protected void createScreen(int rows, int cols, String toMove, boolean isMovie, Movie[] filterdMovies){
        // movie grid
        Movie[] movies = null;
        Order[] orders = null;
        Order o = new Order();
        Movie m  = new Movie();
        AnchorPane newPane;
        if (isMovie){
            if (filterdMovies==null){
                movies = m.exportMovie();
            }
            else{
                movies = filterdMovies;
            }
        }
        else{
            if (currentUser.isAdmin()) {
                orders = o.exportOrders();
            }
            else{
            orders= o.exportSpesificOrder(currentUser.getId());
            }
        }
        int counter=0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (movies!=null && counter < movies.length) {
                    newPane = createAnchorPane(isMovie,movies[counter],toMove, null);
                    grid.setVgap(10);
                    grid.add(newPane, j, i);
                }
                else if(orders!=null && counter < orders.length){
                    newPane = createAnchorPane(isMovie,null,toMove, orders[counter]);
                    grid.setVgap(10);
                    grid.add(newPane, j, i);
                }
                counter++;

            }
        }
    }

    private AnchorPane createAnchorPane(boolean isMovie, Movie movie, String toMove, Order order) {
        AnchorPane anchorPane = new AnchorPane();
        VBox vbox = new VBox(5);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(5);
        String nextPage;
        Movie m = new Movie();
        if (isMovie) {
            nextPage = "resources/movieOrder.fxml";
            Label title = createLabel(movie.getMovieTitle());
            Label category = createLabel(movie.getCategory());
            Image image = new Image(getClass().getResourceAsStream(movie.getImagePath()));
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(300); // image size
            imageView.setFitHeight(250);
            imageView.setPreserveRatio(true);
            vbox.getChildren().addAll(imageView, title, category);
        }
        else {
            m.exportMovieById(order.getMovieID());
            Label userName = createLabel(Integer.toString(order.getUserID()));
            Label price = createLabel(Integer.toString(m.getPrice()));
            Label returnDate = createLabel(order.getDate());
            Label orderId = createLabel(Integer.toString(order.getOrderID()));
            Label movieTitle = createLabel(m.getMovieTitle());
            nextPage = "resources/mainPage.fxml";

            vbox.setPadding(new Insets(10)); // ריווח פנימי
            vbox.setBorder(new Border(new BorderStroke(
                    Color.WHITE,
                    BorderStrokeStyle.SOLID,
                    new CornerRadii(5),
                    new BorderWidths(2))));
            vbox.getChildren().addAll(orderId,userName, price, movieTitle);
        }

        // Add click event to the AnchorPane
        anchorPane.setOnMouseClicked(event -> {
            try {
                if (isMovie) {
                    selectedMovie = movie;
                    // Load the next scene
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(nextPage));
                    Parent root = fxmlLoader.load();
                    Stage stage = (Stage) anchorPane.getScene().getWindow();
                    stage.setScene(new Scene(root));
                    stage.show();
                }
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
