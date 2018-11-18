package com.its.bootifultesting;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;

@RunWith(SpringRunner.class)
//@WebFluxTest
@SpringBootTest
public class BaseClass {

    @Autowired
    ReservationRepository reservationRepository;

    @Before
    public void before() {
        Mockito.when(this.reservationRepository.findAll())
                .thenReturn(Flux.just(new Reservation("1","Shruti")));

        RestAssured.baseURI = "http://localhost:8080";
    }
}
