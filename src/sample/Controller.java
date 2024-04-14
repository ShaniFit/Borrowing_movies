package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller extends DBimport{

    @FXML
    private TextField firstName;

    @FXML
    void byClick(ActionEvent event) {
//        insertToTable(firstName.getText(),firstName.getText());
    }

}
