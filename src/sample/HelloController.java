package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.db.User;

public class HelloController extends User {
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
    public HelloController() {
        super();
    }
    @FXML
    void pressRegister(ActionEvent event) {
        String email = emailField.getText();
        String password =passwordRegister.getText();
        String password_validation= repeatPassword.getText();
        String username=usernameRegister.getText();
        if (!addUserValidation(username, password, password_validation, email)) {
            return;
        }
        User new_user = new User(1, username, password, 0);
        new_user.addNewUserInDB();
    }
    private boolean addUserValidation(String username, String password, String repeatPassword, String email) {
        if (username.isEmpty() || password.isEmpty() || repeatPassword.isEmpty() || email.isEmpty()) {
            showAlert("Empty Fields", "Please fill in all fields.");
            return false;
        }
        if (!isValidEmail(email)) {
            showAlert("Invalid Email", "Please enter a valid email address.");
            return false;
        }
        if (!password.equals(repeatPassword)) {
            showAlert("Password", "Please enter matching passwords.");
            return false;
        }
        return true;
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
        User user = User.login(username, password);
        if (user != null) {
            System.out.println("Login successful");
            // TODO: UI - Open new window if login successful
        } else {
            System.out.println("Login failed");
            showAlert("Login Failed", "Invalid username or password");
        }
    }
}
