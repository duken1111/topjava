package ru.javawebinar.topjava.util;


import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;

import java.util.Arrays;
import java.util.List;

/**
 * Created by DLepeshko on 29.03.2017.
 */
public class UserUtil {

    public static final List<User> USERS = Arrays.asList(
            new User(1,"Dima","dukman@pochta.ru","1111", Role.ROLE_USER),
            new User(2,"Duke","dukman@gmail.com","1111", Role.ROLE_ADMIN),
            new User(3,"Dima2","dukman@pochta.com","1111", Role.ROLE_USER)
    );

    public static User getUser() {
        return USERS.stream().filter(u -> u.getId() == 2).findFirst().orElse(null);
    }
}
