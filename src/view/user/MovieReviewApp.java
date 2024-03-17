package src.view.user;
        
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MovieReviewApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Movie Review App");

        // Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        // Movie Name Label
        Label movieLabel = new Label("Movie: Avengers: Endgame"); // Change the movie name as needed

        // Rating Input
        Label ratingLabel = new Label("Rate the movie:");
        HBox ratingBox = new HBox(5);
        System.out.println(ratingBox.getCssMetaData());
        ToggleGroup ratingGroup = new ToggleGroup();
        for (int i = 1; i <= 5; i++) {
            ToggleButton starButton = new ToggleButton();
            starButton.setId("star-button");
            final int rating = i;
            starButton.setOnAction(event -> {
                if (starButton.isSelected()) {
                    System.out.println("Rated: " + rating);
                } else {
                    System.out.println("Unrated: " + rating);
                }
            });
        }

        // Review Input
        TextArea reviewTextArea = new TextArea();
        reviewTextArea.setPromptText("Write your review here");

        // Submit Button
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(event -> {
            ToggleButton selectedButton = (ToggleButton) ratingGroup.getSelectedToggle();
            String rating = selectedButton != null ? String.valueOf(ratingGroup.getToggles().indexOf(selectedButton) + 1) : "N/A";
            String review = reviewTextArea.getText();

            if (!review.isEmpty()) {
                String fullReview = "Movie: Avengers: Endgame\nRating: " + rating + "/5\n" + review;
                System.out.println(fullReview); // For demo, print the review to console
                reviewTextArea.clear();
                ratingGroup.selectToggle(null); // Clear selected rating
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Incomplete Fields");
                alert.setHeaderText(null);
                alert.setContentText("Please write your review.");
                alert.showAndWait();
            }
        });

        // Adding components to layout
        layout.getChildren().addAll(movieLabel, ratingLabel, ratingBox, reviewTextArea, submitButton);

        // Scene
        Scene scene = new Scene(layout, 400, 300);
//        scene.getStylesheets().add(getClass().getResource("src/view/user/styles.css").toExternalForm()); // Load CSS file
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
