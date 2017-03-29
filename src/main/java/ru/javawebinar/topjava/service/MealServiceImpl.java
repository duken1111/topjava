package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.exception.ExceptionUtil;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.Collection;

/**
 * GKislin
 * 06.03.2015.
 */
@Service
public class MealServiceImpl implements MealService {

    @Autowired
    private MealRepository repository;

    @Override
    public Meal save(Meal meal, User user) {
        if(meal.getUser() == user)
            return repository.save(meal);

        return null;
    }

    @Override
    public void delete(int id, User user) throws NotFoundException {
        Meal meal = repository.get(id);
        if(meal.getUser() == user)
            ExceptionUtil.checkNotFoundWithId(repository.delete(id), id);
        else
            throw new NotFoundException("Ошибка доступа");

    }

    @Override
    public Meal get(int id, User user) throws NotFoundException {
        Meal meal = repository.get(id);
        if(meal.getUser() == user)
            return ExceptionUtil.checkNotFoundWithId(repository.get(id), id);
        else
            throw new NotFoundException("Ошибка доступа");
    }

    @Override
    public Collection<Meal> getAll(User user) {
        return repository.getAll(user);
    }
}
