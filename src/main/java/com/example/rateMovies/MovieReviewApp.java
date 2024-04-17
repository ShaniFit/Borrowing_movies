package com.example.rateMovies;

import dataobjects.Review;
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
        Stars ratingBox = new Stars();

        // Review Input
        TextArea reviewTextArea = new TextArea();
        reviewTextArea.setPromptText("Write your review here");

        // Submit Button
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(event -> {
            int rating = ratingBox.getRating();
            String review = reviewTextArea.getText();

            if (!review.isEmpty()) {
                Review newReview = new Review("Avengers: Endgame", rating, review);
                newReview.savereviewtoDB();
                String fullReview = "Movie: Avengers: Endgame\nRating: " + rating + "/5\n" + review;
                System.out.println(fullReview); // For demo, print the review to console
                reviewTextArea.clear();
                ratingBox.setRating(0); // Clear selected rating
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
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
