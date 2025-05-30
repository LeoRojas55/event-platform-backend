package com.davivienda.events.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.davivienda.events.dto.ReservationRequest;
import com.davivienda.events.dto.EventResponse;
import com.davivienda.events.dto.ReservationResponse;
import com.davivienda.events.service.EventService;
import com.davivienda.events.service.RerservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.davivienda.events.model.Event;
import com.davivienda.events.model.Reservation;
import com.davivienda.events.model.User;
import com.davivienda.events.repository.EventRepository;
import com.davivienda.events.repository.ReservationRepository;
import com.davivienda.events.repository.UserRepository;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired private RerservationService reservationService;

    @PostMapping("/create")
    public ResponseEntity<ReservationResponse> create(@RequestBody ReservationRequest request) {
        Reservation reservation =reservationService.create(
                request.getEventId(),
                request.getUserId());

        ReservationResponse reservationResponse =
                ReservationResponse.builder()
                        .reservation(reservation)
                        .build();
        return ResponseEntity.ok().body(reservationResponse);
    }

    @GetMapping("/show")
    public ResponseEntity<List<Reservation>> show() {
        List<Reservation> reservationList = reservationService.read();
        return ResponseEntity.ok().body(reservationList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationResponse>getReservationById(@PathVariable Long id) {
        Optional<Reservation> reservation = reservationService.findById(id);
        ReservationResponse reservationResponse =
                ReservationResponse.builder()
                        .reservation(reservation.orElse(null))
                        .build();
        return ResponseEntity.ok().body(reservationResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationResponse> updateReservation(@PathVariable Long id, @RequestBody ReservationRequest request) {
        Reservation reservation =reservationService.update(
                request.getId(),
                request.getUserId(),
                request.getEventId());

        ReservationResponse reservationResponse =
                ReservationResponse.builder()
                        .reservation(reservation)
                        .build();
        return ResponseEntity.ok().body(reservationResponse);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        reservationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}