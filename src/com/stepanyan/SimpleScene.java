package com.stepanyan;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class SimpleScene extends Application  {

    //1) Нарисовать простую сцену - домик, солнце

    private static final int BOARD_WIDTH = 1000;
    private static final int BOARD_HEIGHT = 500;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Just a simple static scene: a house, the sun");
        Canvas canvas = new Canvas();
        canvas.setWidth(BOARD_WIDTH);
        canvas.setHeight(BOARD_HEIGHT);
        BorderPane group = new BorderPane(canvas);
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.show();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        test(gc);
    }

    private void test(GraphicsContext gc) {
        gc.setFill(Color.PAPAYAWHIP);
        gc.fillRect(0, 0, 1000, 250);
        gc.setFill(Color.CORAL);
        gc.fillRect(0, 100, 1000, 150);
        gc.setFill(Color.RED);
        gc.fillRect(0, 200, 1000, 50);
        gc.setFill(Color.FIREBRICK);
        gc.fillArc(750, 220, 60, 60, 0, 180, ArcType.CHORD);
        gc.setFill(Color.MAROON);
        gc.fillRect(0, 250, 1000, 20);
        gc.setFill(Color.DARKMAGENTA);
        gc.fillRect(0, 270, 1000, 20);
        gc.setFill(Color.INDIGO);
        gc.fillRect(0, 290, 1000, 50);
        gc.setFill(Color.DARKBLUE);
        gc.fillRect(0, 340, 1000, 50);
        gc.setFill(Color.MEDIUMBLUE);
        gc.fillRect(0, 390, 1000, 110);
        gc.setFill(Color.BLACK);
        gc.fillPolygon(new double[]{90, 10, 170}, new double[]{190, 260, 260}, 3);
        gc.fillPolygon(new double[]{30, 130, 130, 30}, new double[]{260, 260, 310, 310}, 4);
        gc.setLineWidth(5);
        gc.strokeLine(150, 260, 150, 310);
        gc.fillPolygon(new double[]{0, 300, 300, 0}, new double[]{310, 310, 340, 340}, 4);
        gc.setLineWidth(8);
        gc.strokeLine(0, 340, 0, 360);
        gc.strokeLine(30, 340, 30, 360);
        gc.strokeLine(60, 340, 60, 360);
        gc.strokeLine(90, 340, 90, 360);
        gc.strokeLine(120, 340, 120, 360);
        gc.strokeLine(150, 340, 150, 360);
        gc.strokeLine(180, 340, 180, 360);
        gc.strokeLine(210, 340, 210, 360);
        gc.strokeLine(240, 340, 240, 360);
        gc.strokeLine(270, 340, 270, 360);
    }

}