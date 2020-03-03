package com.stepanyan;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MovingBall extends Application {

    //2*) нарисовать шар, который сам двигается и отбивается от краев экрана

    private static final int BOARD_WIDTH = 800;
    private static final int BOARD_HEIGHT = 800;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane canvas = new Pane();
        Scene scene = new Scene(canvas, BOARD_WIDTH, BOARD_HEIGHT, Color.PAPAYAWHIP);
        Circle ball = new Circle(30, Color.TOMATO);
        ball.relocate(5, 5);

        canvas.getChildren().add(ball);

        primaryStage.setTitle("Moving ball is scared of walls");
        primaryStage.setScene(scene);
        primaryStage.show();

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(25),
                new EventHandler<ActionEvent>() {

                    double dx = 8;//Step on x or velocity
                    double dy = 3;//Step on y

                    @Override
                    public void handle(ActionEvent t) {
                        //move the ball
                        ball.setLayoutX(ball.getLayoutX() + dx);
                        ball.setLayoutY(ball.getLayoutY() + dy);

                        Bounds bounds = canvas.getBoundsInLocal();

                        //If the ball reaches the left or right border make the step negative
                        if (ball.getLayoutX() <= (bounds.getMinX() + ball.getRadius()) ||
                                ball.getLayoutX() >= (bounds.getMaxX() - ball.getRadius())) {

                            dx = -dx;

                        }

                        //If the ball reaches the bottom or top border make the step negative
                        if ((ball.getLayoutY() >= (bounds.getMaxY() - ball.getRadius())) ||
                                (ball.getLayoutY() <= (bounds.getMinY() + ball.getRadius()))) {

                            dy = -dy;

                        }

                    }
                }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

}
