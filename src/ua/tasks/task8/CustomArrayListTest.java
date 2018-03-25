package ua.tasks.task8;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class CustomArrayListTest {
    private CustomArrayList customArrayList ;

    @Before
    public void initTest() {
        customArrayList = new CustomArrayList(Arrays.asList(4, 5, 6, 4, 5, 3, 4, 2, 4, 5, 7));
    }


    @Test(expected = UnsupportedOperationException.class)
    public void testRemoveObject() {
        customArrayList.remove(new Integer(7));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testRemoveInt() {
        customArrayList.remove(7);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testRemoveRange() {
        customArrayList.removeRange(2, 5);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testRemoveAll() {
        customArrayList.removeAll(Arrays.asList(4, 5, 6, 4));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testRemoveIf() {
        customArrayList.removeIf(s -> s.equals(new Integer(7)));
    }
}