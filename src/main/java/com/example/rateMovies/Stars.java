package com.example.rateMovies;


import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Stars extends HBox {

    private int rating = 0;
    private StackPane[] stars = new StackPane[5];
    private Color filledStarColor = Color.BLACK; // Define filled star color
    private Color emptyStarColor = Color.TRANSPARENT; // Define empty star color

    public Stars() {
        for (int i = 0; i < 5; i++) {
            StackPane star = createStar();
            final int index = i;
            star.setOnMouseClicked(event -> setRating(index + 1));
            stars[i] = star;
            getChildren().add(star);
        }
        setSpacing(10);
    }

    private StackPane createStar() {
        Polygon starShape = new Polygon(
                0, 0,
                5, 15,
                20, 20,
                10, 30,
                15, 45,
                0, 37.5,
                -15, 45,
                -10, 30,
                -20, 20,
                -5, 15
        );
        starShape.setFill(Color.TRANSPARENT);
        starShape.setStroke(Color.BLACK);
        StackPane starPane = new StackPane();
        starPane.getChildren().add(starShape);
        return starPane;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int newRating) {
        rating = Math.min(Math.max(newRating, 0), 5); // Ensure rating is between 0 and 5
        updateStarColors();
    }

    private void updateStarColors() {
        for (int i = 0; i < 5; i++) {
            Color starColor = (i < rating) ? filledStarColor : emptyStarColor;
            ((Polygon) stars[i].getChildren().get(0)).setFill(starColor);
        }
    }

    // Methods to set filled and empty star colors
    public void setFilledStarColor(Color filledStarColor) {
        this.filledStarColor = filledStarColor;
        updateStarColors(); // Update star colors when color is changed
    }

    public void setEmptyStarColor(Color emptyStarColor) {
        this.emptyStarColor = emptyStarColor;
        updateStarColors(); // Update star colors when color is changed
    }
}

