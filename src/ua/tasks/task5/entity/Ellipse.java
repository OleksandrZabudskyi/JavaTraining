package ua.tasks.task5.entity;

import ua.tasks.task5.CustomAnnotation;
import ua.tasks.task5.proxy.EllipseAccess;

import java.util.Arrays;

public class Ellipse extends CurveLine implements EllipseAccess {
    private double bigHalfAxle;
    private double smallHalfAxle;
    private Point center;

    public Ellipse() {
        this(10.0, 5.0, new Point(0, 0));
    }

    public Ellipse(double bigHalfAxle, double smallHalfAxle, Point center) {
        super(Arrays.asList(new Point((center.getX() + bigHalfAxle), center.getY()),
                new Point(center.getX(), (center.getY() + smallHalfAxle)),
                new Point((center.getX() - bigHalfAxle), center.getY()),
                new Point(center.getX(), (center.getY() - smallHalfAxle))));
        validateEllipse(bigHalfAxle, smallHalfAxle);
        this.bigHalfAxle = bigHalfAxle;
        this.smallHalfAxle = smallHalfAxle;
        this.center = center;
    }

    @CustomAnnotation(value = 10)
    private void validateEllipse(double bigHalfAxle, double smallHalfAxle) throws IllegalArgumentException {
        if (bigHalfAxle < smallHalfAxle) {
            throw new IllegalArgumentException("BigHalfAxle must be greater then smallHalfAxle");
        }
    }

    public double getBigHalfAxle() {
        return bigHalfAxle;
    }

    public void setBigHalfAxle(double bigHalfAxle) {
        this.bigHalfAxle = bigHalfAxle;
    }

    public double getSmallHalfAxle() {
        return smallHalfAxle;
    }

    public void setSmallHalfAxle(double smallHalfAxle) {
        this.smallHalfAxle = smallHalfAxle;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    @Override
    @CustomAnnotation(value = 10)
    public void moveCurveLine(double moveByX, double moveByY) {
        super.moveCurveLine(moveByX, moveByY);
    }

    @Override
    @CustomAnnotation(value = 10)
    public String toString() {
        return "Ellipse{" +
                "bigHalfAxle=" + bigHalfAxle +
                ", smallHalfAxle=" + smallHalfAxle +
                ", center=" + center +
                '}';
    }
}
