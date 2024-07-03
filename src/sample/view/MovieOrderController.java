package sample.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import sample.db.Movie;
import sample.db.Order;

public class MovieOrderController extends HelloController {

    private int movieId;

    @FXML
    private Label categoryLabel;

    @FXML
    private Label price;

    @FXML
    private Label dateLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label durationLabel;

    @FXML
    private ImageView movieImage;

    @FXML
    private Label titleLabel;

    @FXML
    private Text order;

    @FXML
    private Text remove;

    @FXML
    private Button orderButton;

    @FXML
    private Button removeButton;

    @FXML
    private Button reviewButton;

    @FXML
    private Text reviewText;

    @FXML
    void orderPress(ActionEvent event) {
        Order order = new Order(-1, selectedMovie.getPrice(), dateLabel.getText(),currentUser.getId(), selectedMovie.getMovieID());
        order.addNewOrderToDB();
        selectedMovie.updateIsAvilable(0);
        // TODO - shani check this

        handleNextScreenButton("endOrder.fxml");
    }
    @FXML
    void removePress(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Remove movie");
        alert.setHeaderText(null);
        alert.setContentText("Movie removed successfully!");
        alert.showAndWait();
    }

    @FXML
    void reviewPress(ActionEvent event) {
        handleNextScreenButton("resources/reviewPage.fxml");
    }

    @FXML
    void enterSearch(MouseEvent event) {
        handleNextScreenButton("movieSearch.fxml");
    }
    @FXML
    void enterHome(MouseEvent event) {
        handleNextScreenButton("mainPage.fxml");
    }

    public void initialize(){
        categoryLabel.setText(selectedMovie.getCategory());
        dateLabel.setText(selectedMovie.getReleaseDate());
        descriptionLabel.setText(selectedMovie.getDescription());
        durationLabel.setText(selectedMovie.getDuration());
        titleLabel.setText(selectedMovie.getMovieTitle());
        price.setText(Integer.toString(selectedMovie.getPrice()));
        Image image = new Image(getClass().getResourceAsStream(selectedMovie.getImagePath()));
        movieImage.setImage(image);

        if(isAdmin){
            order.setVisible(false);
            orderButton.setVisible(false);
            reviewButton.setVisible(false);
            reviewText.setVisible(false);

        }
        else{
            remove.setVisible(false);
            removeButton.setVisible(false);
        }
    }

}
