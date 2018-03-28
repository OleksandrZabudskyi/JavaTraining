package ua.tasks.task5.proxy;

import ua.tasks.task5.entity.Point;

public interface EllipseAccess {
    double getBigHalfAxle();

    void setBigHalfAxle(double bigHalfAxle);

    double getSmallHalfAxle();

    void setSmallHalfAxle(double smallHalfAxle);

    Point getCenter();

    void setCenter(Point center);

}
