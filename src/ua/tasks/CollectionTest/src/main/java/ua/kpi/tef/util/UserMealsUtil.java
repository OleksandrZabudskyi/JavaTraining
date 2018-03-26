package ua.kpi.tef.util;

import ua.kpi.tef.model.UserMeal;
import ua.kpi.tef.model.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * GKislin
 * 31.05.2015.
 */
public class UserMealsUtil {

    public static List<UserMealWithExceed> getFilteredWithExceededJava7(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        Map<LocalDate, Integer> sumCaloriesPerDay = sumCaloriesPerDay(mealList);

        return mealList.stream().
                filter(userMeal -> TimeUtil.isBetween(userMeal.getDateTime().toLocalTime(), startTime, endTime)).
                map(userMeal -> new UserMealWithExceed(userMeal.getDateTime(),
                        userMeal.getDescription(), userMeal.getCalories(),
                        sumCaloriesPerDay.get(userMeal.getDateTime().toLocalDate()) <= caloriesPerDay)).
                collect(Collectors.toList());

        //Java 7 implementation:

/*        Map<LocalDate, Integer> sumCaloriesPerDay = sumCaloriesPerDay(mealList);
        List<UserMealWithExceed> userMealWithExceeds = new ArrayList<>();
        for (UserMeal userMeal : mealList) {
            LocalDate day = userMeal.getDateTime().toLocalDate();
            if (TimeUtil.isBetween(userMeal.getDateTime().toLocalTime(), startTime, endTime)) {
                boolean exceeded = sumCaloriesPerDay.get(day) <= caloriesPerDay;
                userMealWithExceeds.add(
                        new UserMealWithExceed(userMeal.getDateTime(),
                                userMeal.getDescription(), userMeal.getCalories(), exceeded));
            }
        }
        return userMealWithExceeds;*/
    }

    private static Map<LocalDate, Integer> sumCaloriesPerDay(List<UserMeal> mealList) {
        return mealList.stream().
                collect(Collectors.groupingBy((UserMeal userMeal) -> userMeal.getDateTime().toLocalDate(),
                        Collectors.summingInt(UserMeal::getCalories)));

        // Java 7 implementation:

/*        Map<LocalDate, Integer> map = new HashMap<>();
        for (UserMeal userMeal : mealList) {
            LocalDate day = userMeal.getDateTime().toLocalDate();
            if (map.containsKey(day)) {
                map.put(day, map.get(day) + userMeal.getCalories());
            } else {
                map.put(day, userMeal.getCalories());
            }
        }
        return map;*/
    }
}
