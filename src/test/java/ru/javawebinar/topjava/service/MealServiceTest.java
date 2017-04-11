package ru.javawebinar.topjava.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.javawebinar.topjava.MealTestData;
import ru.javawebinar.topjava.UserTestData;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.util.DbPopulator;
import ru.javawebinar.topjava.util.MealsUtil;
import ru.javawebinar.topjava.util.exception.NotFoundException;


import java.time.LocalDateTime;
import java.time.Month;

import static ru.javawebinar.topjava.MealTestData.MATCHER;
import static ru.javawebinar.topjava.MealTestData.MEAL;
import static ru.javawebinar.topjava.MealTestData.MEAL_ID;
import static ru.javawebinar.topjava.UserTestData.ADMIN_ID;
import static ru.javawebinar.topjava.UserTestData.USER_ID;

/**
 * Created by DLepeshko on 10.04.2017.
 */

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class MealServiceTest {
    @Autowired
    private MealService mealService;

    @Autowired
    private DbPopulator dbPopulator;

    @Before
    public void setUp() {
        dbPopulator.execute();
    }

    @Test
    public void testGet() throws Exception {
        Meal meal = mealService.get(100002, USER_ID);
        MATCHER.assertEquals(meal,MEAL);
    }

    @Test(expected = NotFoundException.class)
    public void testDelete() throws Exception {
        mealService.delete(MEAL_ID,USER_ID);
        mealService.get(MEAL_ID,USER_ID);
    }

    @Test
    public void testGetBetweenDates() throws Exception {

    }

    @Test
    public void testGetBetweenDateTimes() throws Exception {

    }

    @Test
    public void testGetAll() throws Exception {
        int size = mealService.getAll(USER_ID).size();
        Assert.assertEquals(size,6);
    }

    @Test
    public void testUpdate() throws Exception {
        Meal meal = new Meal(MEAL);
        meal.setDescription("fgfdg");
        meal.setCalories(200);
        mealService.update(meal,USER_ID);
        MealTestData.MATCHER.assertEquals(meal,mealService.get(meal.getId(),USER_ID));
    }

    @Test
    public void testSave() throws Exception {
        mealService.save(new Meal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500),USER_ID);
        int size = mealService.getAll(USER_ID).size();
        Assert.assertEquals(size,7);
    }

    @Test(expected = NotFoundException.class)
    public void testGetExepted() throws Exception {
        mealService.get(1,100000);
    }

    @Test(expected = NotFoundException.class)
    public void testGetForeignMeal() throws Exception {
        mealService.get(MEAL_ID,ADMIN_ID);
    }

    @Test(expected = NotFoundException.class)
    public void testDeleteForeignMeal() throws Exception {
        mealService.delete(MEAL_ID,ADMIN_ID);
    }

    @Test(expected = NotFoundException.class)
    @Ignore
    public void testGetAllForeignMeal() throws Exception {
        mealService.getAll(ADMIN_ID);
    }
}