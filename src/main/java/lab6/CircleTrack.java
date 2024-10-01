package lab6;

import javafx.scene.shape.Rectangle;

class CircleTrack {
    private final Rectangle shape;
    private final double radius;
    private double angle;

    CircleTrack(Rectangle shape, double radius) {
        this.shape = shape;
        this.radius = radius;
        this.angle = RaceController.START_ANGLE;
    }

    public Rectangle getShape() {
        return shape;
    }

    public void updatePosition() {
        angle += 0.03;
        double x = 300 + radius * Math.cos(angle);
        double y = 300 + radius * Math.sin(angle);
        shape.setX(x);
        shape.setY(y);
    }
}
