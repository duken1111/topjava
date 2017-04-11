package ru.javawebinar.topjava;

import ru.javawebinar.topjava.matcher.ModelMatcher;
import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Objects;

import static ru.javawebinar.topjava.UserTestData.USER_ID;
import static ru.javawebinar.topjava.model.BaseEntity.START_SEQ;

/**
 * GKislin
 * 13.03.2015.
 */
public class MealTestData {
    public static final int MEAL_ID = START_SEQ + 2;

    public static final Meal MEAL = new Meal(MEAL_ID,LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500,USER_ID);

    public static final ModelMatcher<Meal> MATCHER = new ModelMatcher<>((expected, actual) -> Objects.equals(expected.getId(),actual.getId()));

}
