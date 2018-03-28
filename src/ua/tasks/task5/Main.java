package ua.tasks.task5;

import ua.tasks.task5.entity.Ellipse;
import ua.tasks.task5.entity.Point;
import ua.tasks.task5.proxy.EllipseAccess;
import ua.tasks.task5.proxy.EllipseProxy;

import java.lang.reflect.*;

import static ua.tasks.task5.Constants.*;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException,
            InstantiationException, InvocationTargetException {
        Ellipse ellipse = new Ellipse(10.0, 5.0, new Point(0.0, 0.0));

        Class<?> clazz = Class.forName(ELLIPSE);
        Object object = clazz.newInstance();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            CustomAnnotation customAnnotation = method.getAnnotation(CustomAnnotation.class);
            if (customAnnotation != null) {
                int methodParameterCount = method.getParameterCount();
                if (methodParameterCount > 0) {
                    method.setAccessible(true);
                    method.invoke(object, 10.0, 5.0);
                } else {
                    method.invoke(object);
                }
            }
        }

        System.out.println(CLASS_NAME + clazz.getSimpleName());
        System.out.println(CLASS_MODIFIER + Modifier.toString(clazz.getModifiers()));

        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(CONSTRUCTOR + constructor.toString());
        }

        EllipseAccess proxy = (EllipseAccess) EllipseProxy.newInstance(ellipse);
        System.out.println(ACCESS_TO_GETTER + proxy.getBigHalfAxle());
    }
}
