package com.rubincomputers.restvote.testdata;


import com.rubincomputers.restvote.MatcherFactory;
import com.rubincomputers.restvote.model.Restaurant;


public class RestaurantTestData {
    public static final MatcherFactory.Matcher<Restaurant> REST_MATCHER = MatcherFactory.usingIgnoringFieldsComparator();

    public static final int REST1_ID = 1;
    public static final int REST2_ID = 2;
    public static final int REST3_ID = 3;
    public static final int REST_NOT_FOUND_ID = 100;

    public static final Restaurant rest1 = new Restaurant(REST1_ID, "rest1");
    public static final Restaurant rest2 = new Restaurant(REST2_ID, "rest2");
    public static final Restaurant rest3 = new Restaurant(REST3_ID, "rest3", false);

    public static Restaurant getNew() {
        return new Restaurant(null, "New Rest4");
    }


    public static Restaurant getUpdated() {
        Restaurant updated = new Restaurant(rest1);
        updated.setName("rest updated name");
        updated.setEnabled(false);
        return updated;
    }
}
