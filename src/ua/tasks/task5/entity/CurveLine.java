package ua.tasks.task5.entity;

import java.util.List;

public class CurveLine {
    private List<Point> listPoints;

    public CurveLine(List<Point> listPoints) {
        this.listPoints = listPoints;
    }

    public List<Point> getListPoints() {
        return listPoints;
    }

    public void setListPoints(List<Point> listPoints) {
        this.listPoints = listPoints;
    }

    public void moveCurveLine(double moveByX, double moveByY) {
        for (Point point : listPoints) {
            point.setX(point.getX() + moveByX);
            point.setY(point.getY() + moveByY);
        }
    }

    @Override
    public String toString() {
        return "CurveLine{" +
                "listPoints=" + listPoints +
                '}';
    }
}
