package ua.tasks.task2;

import java.util.ArrayList;
import java.util.List;

public class Service {
    private int minBorder;
    private int maxBorder;
    private int randomValue;
    private List<String> statistics;

    public Service() {
        this.minBorder = 0;
        this.maxBorder = 100;
        this.randomValue = (int) (Math.random() * 101);
        this.statistics = new ArrayList<>();
    }

    public int getMinBorder() {
        return minBorder;
    }

    public int getMaxBorder() {
        return maxBorder;
    }

    public List<String> getStatistics() {
        return statistics;
    }

    public boolean isGuessValueFromRange(int value) {
        int result = value - randomValue;

        if (result == 0) {
            return true;
        }

        if (result < 0) {
            minBorder = value + 1;
        } else {
            maxBorder = value - 1;
        }
        return false;

    }

    public void generateRandomValue(int min, int max) {
        minBorder = min;
        maxBorder = max;
        int margin = maxBorder - minBorder;
        randomValue = (int) (Math.random() * (margin + 1) + minBorder);
    }
}
