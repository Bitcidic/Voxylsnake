package voxylware.voxylsnake;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 600;
    public static final int CONVERSION_CONSTANT = 20;

    @Override
    public void start(Stage stage) {
        StackPane root = new StackPane();
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext context = canvas.getGraphicsContext2D();
        canvas.setFocusTraversable(true);
        root.getChildren().add(canvas);
        Scene scene = new Scene(root);

        stage.setResizable(false);
        stage.setTitle("VoxylSnake");
        stage.setOnCloseRequest(e -> System.exit(0));
        stage.setScene(scene);
        stage.show();

        Loop loop = new Loop(new Game(
                new Snake(new Point(
                        WIDTH / (2 * CONVERSION_CONSTANT),
                        HEIGHT / (2 * CONVERSION_CONSTANT)
                ), new Velocity(0, -1), 5),
                new Point(0, 0),
                new Grid(context, canvas,WIDTH / CONVERSION_CONSTANT, HEIGHT / CONVERSION_CONSTANT)), 20);

        (new Thread(loop)).start();
    }

    public static void main(String[] args) {
        launch();
    }
}