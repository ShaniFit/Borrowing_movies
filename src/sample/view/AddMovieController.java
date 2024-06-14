package sample.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sample.db.Movie;

import java.io.File;

public class AddMovieController {
// TODO - remove form fxml the director field
    @FXML
    private TextField addCategory;

    @FXML
    private TextField addDuration;

    @FXML
    private TextField addPrice;

    @FXML
    private TextField addReleaseDate;

    @FXML
    private TextField addTitle;

    @FXML
    private ImageView movieImage;

    @FXML
    void addImage(MouseEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif","*.jpeg")
        );
        File selectedFile = fileChooser.showOpenDialog(new Stage());

        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            movieImage.setImage(image);
        }
    }


    @FXML
    void pressSubmit(ActionEvent event) {
        String category = addCategory.getText();
        String duration = addDuration.getText();
        String price = addPrice.getText();
        String releaseDate = addReleaseDate.getText();
        String title = addTitle.getText();
        Movie movie = new Movie(-1,
                title, "", releaseDate, duration, Integer.parseInt(category), 1);
//        Movie movie = new Movie(-1,
//                title, "", releaseDate, Integer.parseInt(duration), Integer.parseInt(category), 1,
//                Integer.parseInt(price));
//        movie.addMovieToDB();
        // TODO - add to db
        // TODO - UI - pass to the main page
    }

}
