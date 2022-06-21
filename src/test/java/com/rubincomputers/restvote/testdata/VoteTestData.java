package com.rubincomputers.restvote.testdata;


import com.rubincomputers.restvote.MatcherFactory;
import com.rubincomputers.restvote.model.Vote;

import java.time.LocalDate;

import static com.rubincomputers.restvote.testdata.RestaurantTestData.*;
import static com.rubincomputers.restvote.testdata.UserTestData.admin;
import static com.rubincomputers.restvote.testdata.UserTestData.user1;

public class VoteTestData {
    public static final MatcherFactory.Matcher<Vote> VOTE_MATCHER_IGNORE_REST = MatcherFactory.usingIgnoringFieldsComparator();

    public static final int VOTE1_ID = 1;
    public static final int VOTE2_ID = 2;
    public static final int VOTE3_ID = 3;

    public static final int VOTE_NOT_FOUND_ID = 100;

    public static final Vote vote1 = new Vote(VOTE1_ID, rest1, user1, LocalDate.now());
    public static final Vote vote2 = new Vote(VOTE2_ID, rest2, admin, LocalDate.now());


    public static Vote getNew() {
        return new Vote(null, rest3, user1, LocalDate.now().plusDays(1));
    }

    public static Vote getUpdated() {
        Vote updated = new Vote(vote1);
        updated.setRestaurant(rest2);
        return updated;
    }
}
