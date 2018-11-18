package com.its.bootifultesting;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.test.StepVerifier;

/**
 * Step 2
 */
@RunWith(SpringRunner.class)
@DataMongoTest
public class ReservationDocumentTest {
    @Autowired
    ReactiveMongoTemplate mongoTemplate;

    @Test
    public void testShouldStoreAndRetrieve() {
        /*StepVerifier.create(mongoTemplate.save(new Reservation("1", "dhaval")))
                .expectNextMatches( r -> r.getReservationName().equals("dhaval"))
                .verifyComplete();*/

        // Refactored step - below code does the same thing as above
        Publisher<Reservation> reservationPublisher = mongoTemplate.save(new Reservation("1","dhaval"));
        StepVerifier.create(reservationPublisher)
                .expectNextMatches( r -> r.getReservationName().equals("dhaval"))
                .verifyComplete();
    }
}
