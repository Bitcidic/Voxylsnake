package voxylware.voxylsnake;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class Grid {
    private final int rows, cols;
    private final GraphicsContext context;
    private final Canvas canvas;
    public Grid(final GraphicsContext context, final Canvas canvas, final int rows, final int cols) {
        this.rows = rows;
        this.cols = cols;
        this.context = context;
        this.canvas = canvas;
    }

    public Point getRandomPoint() {
        Random random = new Random();
        return new Point(random.nextInt(rows), random.nextInt(cols));
    }

    public void wrapPoint(Point point) {
        if(point.getX() >= rows) point.setX(0);
        if(point.getY() >= cols) point.setY(0);
        if(point.getX() < 0) point.setX(rows - 1);
        if(point.getY() < 0) point.setY(cols - 1);
    }

    public void clearPoints() {
        context.setFill(Color.BLACK);
        context.fillRect(0, 0, rows * Main.CONVERSION_CONSTANT, cols * Main.CONVERSION_CONSTANT);
    }

    public void drawPoint(Point point, Color color) {
        context.setFill(color);
        context.fillRect(point.getX() * Main.CONVERSION_CONSTANT, point.getY() * Main.CONVERSION_CONSTANT, Main.CONVERSION_CONSTANT, Main.CONVERSION_CONSTANT);
    }

    public void drawSnake(Snake snake) {
        if(snake.isAlive()) {
            snake.getBodyPoints().forEach(point -> drawPoint(point, Color.GREEN));
        } else {
            snake.getBodyPoints().forEach(point -> drawPoint(point, Color.DARKRED));
        }
    }

    public void drawScore(Snake snake) {
        context.setFill(Color.WHITE);
        context.fillText("Score " + (snake.getBodyPoints().size() - (snake.getStartLength() + 1)), Main.CONVERSION_CONSTANT, Main.HEIGHT - Main.CONVERSION_CONSTANT);
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Canvas getCanvas() {
        return canvas;
    }
}
