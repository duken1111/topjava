package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.BaseEntity;
import ru.javawebinar.topjava.util.exception.NotFoundException;

/**
 * Created by DLepeshko on 30.03.2017.
 */
public class ValidationUtil {

    private ValidationUtil() {

    }

    public static void checkNotFound(boolean found, String msg) {
        if (!found) {
            throw new NotFoundException("Not found entity with " + msg);
        }
    }

    public static void checkNew(BaseEntity entity) {
        if (!entity.isNew()) {
            throw new IllegalArgumentException(entity + " must be new (id=null)");
        }
    }

    public static void checkIdConsistent(BaseEntity entity, int id) {
        //      http://stackoverflow.com/a/32728226/548473
        if (entity.isNew()) {
            entity.setId(id);
        } else if (entity.getId() != id) {
            throw new IllegalArgumentException(entity + " must be with id=" + id);
        }
    }
}
