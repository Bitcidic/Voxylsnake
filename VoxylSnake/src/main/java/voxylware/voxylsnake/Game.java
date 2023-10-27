package voxylware.voxylsnake;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Game {
    private Snake snake;
    private Point food;
    private Grid grid;
    public Game(Snake snake, Point food, Grid grid) {
        this.snake = snake;
        this.grid = grid;
        this.food = food;
    }

    public void setup() {
        spawnFood();
        grid.getCanvas().setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case W -> {
                    if (snake.getVelocity().getyV() != 1) snake.setVelocity(new Velocity(0, -1));
                }
                case A -> {
                    if (snake.getVelocity().getxV() != 1) snake.setVelocity(new Velocity(-1, 0));
                }
                case S -> {
                    if (snake.getVelocity().getyV() != -1) snake.setVelocity(new Velocity(0, 1));
                }
                case D -> {
                    if (snake.getVelocity().getxV() != -1) snake.setVelocity(new Velocity(1, 0));
                }
                case ESCAPE -> snake.setAlive(false);
            }
        });
    }

    // I am not familiar with event-based programming yet
    public void tick() {
        // Move the snake
        snake.move();
        for(Point point : snake.getBodyPoints()) {
            grid.wrapPoint(point);
        }

        // Logic that runs if the snake eats food
        if(snake.getHead().equals(food)) eatFood();

        // Draw the snake and the food
        grid.clearPoints();
        grid.drawPoint(food, Color.RED);
        grid.drawSnake(snake);
        grid.drawScore(snake);
    }

    public void eatFood() {
        snake.setGrowToLength(1);
        while(snake.getHead().equals(food)) {
            food = grid.getRandomPoint();
        }
    }

    public void spawnFood() {
        do {
            food = grid.getRandomPoint();
        } while (snake.getBodyPoints().contains(food));
    }

    public boolean gameOver() {
        return !snake.isAlive();
    }
}
