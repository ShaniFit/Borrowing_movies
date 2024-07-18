package sample.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class EndOrderController extends HelloController{

    @FXML
    private Text text;
    @FXML
    private TextField CVV;

    @FXML
    private TextField ID;

    @FXML
    private TextField creditNum;

    @FXML
    void enterHome(MouseEvent event) {
        handleNextScreenButton("resources/mainPage.fxml");
    }

    @FXML
    void enterPay(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Pay");
        alert.setHeaderText(null);
        alert.setContentText("Payment is done successfully!\n");
        alert.showAndWait();
        handleNextScreenButton("resources/mainPage.fxml");
    }


}