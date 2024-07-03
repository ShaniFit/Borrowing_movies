package com.example.demo9;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class HelloController{

    protected static Boolean isAdmin;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordLogin;

    @FXML
    private PasswordField passwordRegister;

    @FXML
    private PasswordField repeatPassword;

    @FXML
    private TextField usernameLogin;

    @FXML
    private TextField usernameRegister;


    @FXML
    void closeButton(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void pressRegister(ActionEvent event) {
        String email = emailField.getText();
        String password =passwordRegister.getText();
        String Password2= repeatPassword.getText();
        String username=usernameRegister.getText();
        if(!password.equals(Password2)) {
            showAlert("Password", "Please enter matching passwords");
            repeatPassword.clear();
        }
        if (!isValidEmail(email)) {
            showAlert("Invalid Email", "Please enter a valid email address.");
            emailField.clear();
        }
    }

    private boolean isValidEmail(String email) {
        return email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.com");
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    void pressLogin(ActionEvent event) {
        String username = usernameLogin.getText();
        String password = passwordLogin.getText();
        isAdmin=true;
        handleNextScreenButton("mainPage.fxml");
    }
    protected void handleNextScreenButton(String fxml) {
        try {
            HelloApplication.loadScene(fxml);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}