package ua.tasks.task5.proxy;

import ua.tasks.task5.entity.Ellipse;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class EllipseProxy implements InvocationHandler {
    private final Ellipse ellipse;


    public static Object newInstance(Ellipse ellipse) {
        return java.lang.reflect.Proxy.newProxyInstance(
                ellipse.getClass().getClassLoader(),
                ellipse.getClass().getInterfaces(),
                new EllipseProxy(ellipse));
    }

    public EllipseProxy(Ellipse ellipse) {
        this.ellipse = ellipse;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().startsWith("set")) {
            throw new UnsupportedOperationException("Access denied");
        }
        return method.invoke(ellipse, args);
    }
}
