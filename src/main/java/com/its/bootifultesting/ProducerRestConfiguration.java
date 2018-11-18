package com.its.bootifultesting;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.*;
import static org.springframework.web.reactive.function.server.ServerResponse.*;

@Configuration
public class ProducerRestConfiguration {
    private final ReservationRepository reservationRepository;

    ProducerRestConfiguration(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Bean
    RouterFunction<ServerResponse> routes () {
        return route(GET("/reservations"), request -> ok().body(reservationRepository.findAll(), Reservation.class));
    }
}
