package com.its.bootifultesting;

import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class ReservationPOJOTest {

    /**
     * 1st step
     */
    @Test
    public void testShouldConstruct() {
        // Since reservation class does not exists, it will give compilation error
        // Once we create class, we should be able to assert successfull instanatiation  of below object
        Reservation aReservation = new Reservation("1","dps");

        Assert.assertEquals("1", aReservation.getId());
        Assert.assertThat(aReservation.getReservationName(), Matchers.equalToIgnoringCase("dps"));

        // Assertj is fluid declarative way of asserting
        Assertions.assertThat(aReservation)
                .as("Not a null reference")
                .isNotNull();

        Assertions.assertThat(aReservation.getReservationName())
                .as("Reservation name is populated")
                .isNotNull();
    }
}
