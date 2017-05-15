package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.javawebinar.topjava.AuthorizedUser;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.web.meal.MealRestController;


/**
 * Created by DLepeshko on 15.05.2017.
 */
@Controller
public class MealController {
    private static final Logger LOG = LoggerFactory.getLogger(MealServlet.class);

    @Autowired
    private MealRestController controller;

    @RequestMapping(value = "/meals", method = RequestMethod.GET)
    public String meals(Model model) {
        model.addAttribute("mealList", controller.getAll());
        return "meals";
    }

    @RequestMapping(value = "/meal", method = RequestMethod.GET)
    public String addMeal(@Param(value = "action") String action, Model model) {
        if("create".equalsIgnoreCase(action)) {
            model.addAttribute("meal", new Meal());
        }

        return "meal";
    }
}
