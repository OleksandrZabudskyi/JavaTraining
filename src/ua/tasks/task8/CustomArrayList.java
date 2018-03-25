package ua.tasks.task8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Predicate;

public class CustomArrayList extends ArrayList{



    public CustomArrayList(Collection c) {
        super(c);
    }

    @Override
    public Object remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeIf(Predicate filter) {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        CustomArrayList customArrayList = new CustomArrayList(Arrays.asList(4, 5, 6, 4, 5, 3, 4, 2, 4, 5, 7));
        customArrayList.remove(4);
    }
}
