package com.rubincomputers.restvote.testdata;


import com.rubincomputers.restvote.MatcherFactory;
import com.rubincomputers.restvote.model.Dish;
import com.rubincomputers.restvote.model.Restaurant;

import java.time.LocalDate;

import static com.rubincomputers.restvote.testdata.RestaurantTestData.rest1;


public class DishTestData {
    public static final MatcherFactory.Matcher<Dish> DISH_MATCHER = MatcherFactory.usingIgnoringFieldsComparator();
    public static final MatcherFactory.Matcher<Dish> DISH_MATCHER_IGNORE_REST = MatcherFactory.usingIgnoringFieldsComparator("restaurant");

    public static final int DISH1_ID = 1;
    public static final int DISH2_ID = 2;
    public static final int DISH3_ID = 3;
    public static final int DISH4_ID = 4;
    public static final int DISH5_ID = 5;
    public static final int DISH6_ID = 6;
    public static final int DISH_NOT_FOUND_ID = 100;

    public static final Dish dish1 = new Dish(DISH1_ID, "dish1 - rest1", 101, LocalDate.now(), rest1);
    public static final Dish dish2 = new Dish(DISH2_ID, "dish2 - rest1", 202, LocalDate.now());
    public static final Dish dish3 = new Dish(DISH3_ID, "dish3 - rest1", 303, LocalDate.now());
    public static final Dish dish4 = new Dish(DISH4_ID, "dish4 - rest2", 404, LocalDate.now());
    public static final Dish dish5 = new Dish(DISH5_ID, "dish5 - rest2", 505, LocalDate.now());
    public static final Dish dish6 = new Dish(DISH6_ID, "dish6 - rest3", 606, LocalDate.now());

    public static Dish getNew() {
        return new Dish(null, "New Dish", 1000, LocalDate.now(), rest1);
    }


    public static Dish getUpdated() {
        Dish updated = new Dish(dish1);
        updated.setName("dish updated name");
        return updated;
    }
}
