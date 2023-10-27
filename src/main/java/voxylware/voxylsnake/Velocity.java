package voxylware.voxylsnake;

public class Velocity {
    private int xV, yV;

    public Velocity(int xV, int yV) {
        this.xV = xV;
        this.yV = yV;
    }

    public int getxV() {
        return xV;
    }

    public void setxV(int xV) {
        this.xV = xV;
    }

    public int getyV() {
        return yV;
    }

    public void setyV(int yV) {
        this.yV = yV;
    }

    public static Point getNextPoint(Point point, Velocity velocity) {
        return new Point(point.getX() + velocity.getxV(), point.getY() + velocity.getyV());
    }
}
