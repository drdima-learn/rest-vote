package com.rubincomputers.restvote.service;

import com.rubincomputers.restvote.AbstractTest;
import com.rubincomputers.restvote.exception.NotFoundException;
import com.rubincomputers.restvote.model.Dish;
import com.rubincomputers.restvote.testdata.DishTestData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.rubincomputers.restvote.testdata.DishTestData.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class DishServiceTest extends AbstractTest {
    @Autowired
    private DishService service;


    @Test
    public void get() {
        Dish dish = service.get(DISH1_ID);
        DISH_MATCHER_IGNORE_REST.assertMatch(dish, DishTestData.dish1);
    }

    @Test
    public void getNotFound() {
        assertThrows(NotFoundException.class, () -> service.get(DISH_NOT_FOUND_ID));
    }


    @Test
    public void getAll() {
        List<Dish> all = service.getAll();
        DISH_MATCHER_IGNORE_REST.assertMatch(all, dish1, dish2, dish3, dish4, dish5, dish6);
    }

    @Test
    public void getAllEmptyList() {
        service.deleteAll();
        List<Dish> all = service.getAll();
        DISH_MATCHER_IGNORE_REST.assertMatch(all, List.of());
    }

    @Test
    public void create() {
        Dish created = service.create(getNew());
        int newId = created.id();
        Dish newDish = getNew();
        newDish.setId(newId);
        DISH_MATCHER_IGNORE_REST.assertMatch(created, newDish);
        DISH_MATCHER_IGNORE_REST.assertMatch(service.get(newId), newDish);
    }


    @Test
    public void delete() {
        service.delete(DISH1_ID);
        assertThrows(NotFoundException.class, () -> service.get(DISH1_ID));
    }

    @Test
    public void deletedNotFound() {
        assertThrows(NotFoundException.class, () -> service.delete(DISH_NOT_FOUND_ID));
    }

    @Test
    public void update() {
        Dish updated = getUpdated();
        service.update(updated);
        DISH_MATCHER_IGNORE_REST.assertMatch(service.get(DISH1_ID), getUpdated());
    }

    @Test
    public void updateNotFound() {
        Dish updated = getUpdated();
        updated.setId(DISH_NOT_FOUND_ID);
        assertThrows(NotFoundException.class, () -> service.update(updated));
    }
}
