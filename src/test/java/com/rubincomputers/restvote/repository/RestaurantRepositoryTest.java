package com.rubincomputers.restvote.repository;

import com.rubincomputers.restvote.AbstractTest;
import com.rubincomputers.restvote.model.Restaurant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.NoSuchElementException;

import static com.rubincomputers.restvote.testdata.RestaurantTestData.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.util.AssertionErrors.assertEquals;



public class RestaurantRepositoryTest extends AbstractTest {
    @Autowired
    private RestaurantRepository repository;


    @Test
    public void get() {
        Restaurant restaurant = repository.findById(REST1_ID).get();
        REST_MATCHER.assertMatch(restaurant, rest1);
    }

    @Test
    public void getNotFound() {
        assertThrows(NoSuchElementException.class, () -> repository.findById(REST_NOT_FOUND_ID).get());
    }


    @Test
    public void getAll() {
        List<Restaurant> all = repository.findAll();
        REST_MATCHER.assertMatch(all, rest1, rest2, rest3);
    }

    @Test
    public void getAllEmptyList() {
        repository.deleteAll();
        List<Restaurant> all = repository.findAll();
        REST_MATCHER.assertMatch(all, List.of());
    }

    @Test
    public void create() {
        Restaurant created = repository.save(getNew());
        int newId = created.id();
        Restaurant newRest = getNew();
        newRest.setId(newId);
        REST_MATCHER.assertMatch(created, newRest);
        REST_MATCHER.assertMatch(repository.findById(newId).get(), newRest);
    }


    @Test
    public void delete() {
        assertEquals("must be 1", 1, repository.delete(REST1_ID));
    }

    @Test
    public void deletedNotFound() {
        assertEquals("must be 0", 0, repository.delete(REST_NOT_FOUND_ID));
    }

//    @Test
//    public void update() {
//        Restaurant updated = getUpdated();
//        repository.save(updated);
//        USER_MATCHER.assertMatch(service.get(USER_ID), getUpdated());
//    }
//
//    @Test
//    public void updateNotFound() {
//        User updated = getUpdated();
//        updated.setId(NOT_FOUND);
//        assertThrows(NotFoundException.class, () -> service.update(updated));
//    }
}
