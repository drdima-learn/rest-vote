package com.rubincomputers.restvote.testdata;


import com.rubincomputers.restvote.MatcherFactory;
import com.rubincomputers.restvote.model.Dish;
import com.rubincomputers.restvote.model.Restaurant;


public class DishTestData {
    public static final MatcherFactory.Matcher<Restaurant> REST_MATCHER = MatcherFactory.usingIgnoringFieldsComparator();

    public static final int DISH1_ID = 1;
    public static final int DISH2_ID = 2;
    public static final int DISH3_ID = 3;
    public static final int DISH_NOT_FOUND_ID = 100;

    public static final Dish dish1 = new Dish(DISH1_ID, "dish1 - rest1", 101);
    public static final Dish dish2 = new Dish(DISH2_ID, "dish2 - rest1", 202);
    public static final Dish dish3 = new Dish(DISH3_ID, "dish3 - rest1", 303);

    public static Dish getNew() {
        return new Dish(null, "New Dish", 1000);
    }


    public static Dish getUpdated() {
        Dish updated = new Dish(dish1);
        updated.setName("dish updated name");
        return updated;
    }
}
