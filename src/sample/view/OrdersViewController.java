package sample.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class OrdersViewController extends MainPageController {

    @FXML
    private GridPane grid;


    @FXML
    void enterHome(MouseEvent event) {
        handleNextScreenButton("mainPage.fxml");
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        createScreen(3,6, "resources/movieOrder.fxml",false);
    }
}


