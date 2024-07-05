package sample.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import sample.db.Review;


public class ReviewController extends HelloController {

    @FXML
    private Label categoryLabel;

    @FXML
    private Label dateLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label durationLabel;

    @FXML
    private ImageView movieImage;

    @FXML
    private RadioButton rate1;

    @FXML
    private RadioButton rate2;

    @FXML
    private RadioButton rate3;

    @FXML
    private RadioButton rate4;

    @FXML
    private RadioButton rate5;
    @FXML
    private TextArea reviewID;
    private int rate = 0;

    @FXML
    private Label titleLabel;

    void setMovieReview(){
        Review review = new Review(-1,rate, reviewID.getText(), currentUser.getId(), selectedMovie.getMovieID());
        review.insertNewReview();
        handleNextScreenButton("resources/mainPage.fxml");
    }
    @FXML
    void reviewPress(MouseEvent event) {
        setMovieReview();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Review");
        alert.setContentText("Thank you for your review!");
        alert.showAndWait();

    }
    @FXML
    void handleRating(ActionEvent event) {
        if (rate1.isSelected()){
            rate = 1;
        }
        else if(rate2.isSelected()){
            rate1.setSelected(true);
            rate = 2;
        }
        else if(rate3.isSelected()){
            rate1.setSelected(true);
            rate2.setSelected(true);
            rate = 3;
        }
        else if(rate4.isSelected()){
            rate1.setSelected(true);
            rate2.setSelected(true);
            rate3.setSelected(true);
            rate = 4;
        }
        else if(rate5.isSelected()){
            rate1.setSelected(true);
            rate2.setSelected(true);
            rate3.setSelected(true);
            rate4.setSelected(true);
            rate = 5;
        }
    }

    @FXML
    void enterHome(MouseEvent event) {
        handleNextScreenButton("resources/mainPage.fxml");
    }

    public void initialize(){
        categoryLabel.setText(selectedMovie.getCategory());
        dateLabel.setText(selectedMovie.getReleaseDate());
        descriptionLabel.setText(selectedMovie.getDescription());
        durationLabel.setText(selectedMovie.getDuration());
        titleLabel.setText(selectedMovie.getMovieTitle());
        Image image = new Image(getClass().getResourceAsStream(selectedMovie.getImagePath()));
        movieImage.setImage(image);
    }
}
