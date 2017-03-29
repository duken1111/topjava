package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.to.MealWithExceed;

import java.util.List;

/**
 * GKislin
 * 06.03.2015.
 */
@Controller
public class MealRestController {
    protected final Logger LOG = LoggerFactory.getLogger(getClass());
    @Autowired
    private MealService service;

    public List<Meal> getAll() {
        LOG.info("getAll MEALS");
        return null;
    }

    public Meal getById(int id) {
        LOG.info("getByID meals");
        return null;
    }

    public void save(Meal meal) {
        LOG.info("save meal " + meal.getId());
    }

    public void delete(int id) {
        LOG.info("delete meals" + id);
    }



}
