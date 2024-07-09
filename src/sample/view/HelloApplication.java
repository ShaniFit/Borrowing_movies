package sample.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class HelloApplication extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.initStyle(StageStyle.UNDECORATED);
        HelloApplication.primaryStage = primaryStage;
        loadScene("resources/hello-view.fxml");
    }

    public static void loadScene(String fxmlPath) throws Exception {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource(fxmlPath));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.setX((Screen.getPrimary().getVisualBounds().getWidth() - primaryStage.getWidth()) / 2);
        primaryStage.setY((Screen.getPrimary().getVisualBounds().getHeight() - primaryStage.getHeight()) / 2);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
        String email= "";
    }
}