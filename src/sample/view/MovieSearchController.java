package com.example.demo9;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import java.net.URL;
import java.util.ResourceBundle;

public class MovieSearchController extends MainPageController{

    @FXML
    private GridPane grid;

    @FXML
    void enterMovie(MouseEvent event) {
        handleNextScreenButton("movieOrder.fxml");
    }
    @FXML
    void enterHome(MouseEvent event) {
        handleNextScreenButton("mainPage.fxml");
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        createScreen(1,4, "movieOrder.fxml",true);
    }
}
