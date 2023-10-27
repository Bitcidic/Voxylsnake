package voxylware.voxylsnake;

import java.util.LinkedList;
import java.util.List;

public class Snake {
    private List<Point> bodyPoints;
    private Point headPoint;
    private boolean alive;
    private int growToLength;
    private Velocity velocity;
    private int startLength;
    public Snake(Point initialPoint, Velocity velocity, int length) {
        bodyPoints = new LinkedList<>();
        bodyPoints.add(initialPoint);
        headPoint = initialPoint;
        this.velocity = velocity;
        this.growToLength = length;
        this.alive = true;
        this.startLength = length;
    }

    public void move() {
        if(growToLength > 0) {
            growToLength--;
        } else {
            bodyPoints.remove(0);
        }

        Point newPoint = Velocity.getNextPoint(headPoint, velocity);
        if(bodyPoints.contains(newPoint)) {
            setAlive(false);
        } else {
            headPoint = newPoint;
            bodyPoints.add(newPoint);
        }
    }

    public Point getHead() {
        return headPoint;
    }
    public List<Point> getBodyPoints() {
        return bodyPoints;
    }

    public Velocity getVelocity() {
        return velocity;
    }

    public void setVelocity(Velocity velocity) {
        this.velocity = velocity;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void setGrowToLength(int growToLength) {
        this.growToLength = growToLength;
    }

    public int getStartLength() {
        return startLength;
    }
}
