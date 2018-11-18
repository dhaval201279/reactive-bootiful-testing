package com.its.bootifultesting;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@DataMongoTest
public class ReservationRepositoryTest {
    @Autowired
    ReservationRepository reservationRepository;

    @Test
    public void testRepositoryShouldSaveFind() {
        Mono <Reservation> aReservation = reservationRepository.save(new Reservation(null, "Shruti" ));
        Publisher<Reservation> reservationsFound = aReservation.thenMany(reservationRepository.findAll());

        StepVerifier
            .create(reservationsFound)
            .expectNextMatches(r -> r.getReservationName().equals("Shruti"))
            .verifyComplete();
    }
}
