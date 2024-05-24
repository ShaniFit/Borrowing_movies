package com.example.demo9;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class MovieOrderController extends HelloController {

    @FXML
    private Label categoryLabel;

    @FXML
    private Label categoryLabel11;

    @FXML
    private Label dateLabel;

    @FXML
    private Label directorLabel;

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

    }
    @FXML
    void removePress(ActionEvent event) {

    }

    @FXML
    void reviewPress(ActionEvent event) {
        handleNextScreenButton("reviewPage.fxml");
    }

    public void initialize(){
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
