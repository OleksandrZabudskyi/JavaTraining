package ua.tasks.task7;

import java.util.*;

public class DuplicatesCounter<E> {

    public Map<E, Integer> findNumberOfRepetition(List<E> list) {
        Map<E, Integer> valueCountMap = new HashMap<>();
        for (E element : list) {
            if (valueCountMap.containsKey(element)) {
                valueCountMap.put(element, valueCountMap.get(element) + 1);
            } else {
                valueCountMap.put(element, 1);
            }
        }
        return valueCountMap;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(4, 5, 6, 4, 5, 3, 4, 2, 4, 5, 7));
        DuplicatesCounter<Integer> duplicatesCounter = new DuplicatesCounter<>();
        System.out.println(duplicatesCounter.findNumberOfRepetition(list));
    }
}
