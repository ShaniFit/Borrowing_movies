package com.example.demo9;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class AddMovieController {

    @FXML
    private TextField addCategory;

    @FXML
    private TextField addDirector;

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

    }

}
