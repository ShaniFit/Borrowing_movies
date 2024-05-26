package com.example.demo9;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


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
        primaryAddMovieControllerStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
        String email= "";
    }
}