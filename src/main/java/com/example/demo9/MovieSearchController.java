package com.example.demo9;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

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
        handleNextScreenButton("movieOrder.fxml");
    }

}
