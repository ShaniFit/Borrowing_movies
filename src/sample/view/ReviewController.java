package com.example.demo9;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;


public class ReviewController extends HelloController {

    @FXML
    private Label categoryLabel;

    @FXML
    private Label dateLabel;

    @FXML
    private Label directorLabel;

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
    private Label titleLabel;

    @FXML
    void handleRating(ActionEvent event) {
        if(rate2.isSelected()){
            rate1.setSelected(true);
        }
        else if(rate3.isSelected()){
            rate1.setSelected(true);
            rate2.setSelected(true);
        }
        else if(rate4.isSelected()){
            rate1.setSelected(true);
            rate2.setSelected(true);
            rate3.setSelected(true);
        }
        else if(rate5.isSelected()){
            rate1.setSelected(true);
            rate2.setSelected(true);
            rate3.setSelected(true);
            rate4.setSelected(true);
        }
    }

    @FXML
    void enterHome(MouseEvent event) {
        handleNextScreenButton("mainPage.fxml");
    }
}
