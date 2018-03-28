package ua.tasks.task5.proxy;

import org.junit.BeforeClass;
import org.junit.Test;
import ua.tasks.task5.entity.Ellipse;
import ua.tasks.task5.entity.Point;

public class EllipseProxyTest {
    private static EllipseAccess ellipseProxy;

    @BeforeClass
    public static void setUp() {
        Ellipse ellipse = new Ellipse(10.0, 5.0, new Point(0.0, 0.0));
        ellipseProxy = (EllipseAccess) EllipseProxy.newInstance(ellipse);
    }

    @Test
    public void testGettersAccess() {
        ellipseProxy.getBigHalfAxle();
        ellipseProxy.getCenter();
        ellipseProxy.getSmallHalfAxle();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testSetBigHalfAxleAccess() {
        ellipseProxy.setBigHalfAxle(10.0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testSetSmallHalfAxleAccess() {
        ellipseProxy.setSmallHalfAxle(10.0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testSetCenterAccess() {
        ellipseProxy.setCenter(new Point(0, 0));
    }
}