package com.example.demo9;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        HelloApplication.primaryStage = primaryStage;
        loadScene("hello-view.fxml");
    }

    public static void loadScene(String fxmlPath) throws Exception {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource(fxmlPath));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    /*
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 460, 400);
        stage.setTitle("Movie Rent");
        stage.setScene(scene);
        stage.show();

    }
*/
    public static void main(String[] args) {
        launch();
        String email= "";
    }
}