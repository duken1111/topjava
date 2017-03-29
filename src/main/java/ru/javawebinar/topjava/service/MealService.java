package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.Collection;

/**
 * GKislin
 * 15.06.2015.
 */
public interface MealService {
    Meal save(Meal meal, User user);

    void delete(int id, User user) throws NotFoundException;

    Meal get(int id, User user) throws NotFoundException;

    Collection<Meal> getAll(User user);
}
