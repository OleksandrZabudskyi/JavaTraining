package ua.tasks.task2;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private int minBorder;
    private int maxBorder;
    private int randomValue;
    private List<String> statistics = new ArrayList<>();

    public int getMinBorder() {
        return minBorder;
    }

    public int getMaxBorder() {
        return maxBorder;
    }

    public int getRandomValue() {
        return randomValue;
    }

    public List<String> getStatistics() {
        return statistics;
    }

    public boolean isGuessValueFromRange(int value) {
        statistics.add(Integer.toString(value));
        int result = value - randomValue;

        if (result == 0) {
            return true;
        }

        if (result < 0) {
            minBorder = value;
        } else {
            maxBorder = value;
        }
        return false;

    }

    public void setBorders(int minBorder, int maxBorder) {
        this.minBorder = minBorder;
        this.maxBorder = maxBorder;
    }

    public void generateRandomValue() {
        randomValue = (int) Math.ceil(Math.random() *
                (maxBorder - minBorder - 1) + minBorder);
    }
}
