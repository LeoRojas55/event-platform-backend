package com.davivienda.events.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davivienda.events.model.Event;
import com.davivienda.events.model.Reservation;
import com.davivienda.events.model.User;
import com.davivienda.events.repository.EventRepository;
import com.davivienda.events.repository.ReservationRepository;
import com.davivienda.events.repository.UserRepository;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/my")
    public List<Reservation> getUserReservations(@AuthenticationPrincipal UserDetails userDetails) {
        Long userId = userRepository.findByUsername(userDetails.getUsername())
                                    .map(User::getId)
                                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return reservationRepository.findByUserId(userId);
    }

    @PostMapping("/{eventId}")
    public Reservation reserve(@PathVariable Long eventId, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepository.findByUsername(userDetails.getUsername())
                                  .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Event event = eventRepository.findById(eventId)
                                     .orElseThrow(() -> new RuntimeException("Evento no encontrado"));

        // Validar si el evento está lleno
        int reservasActuales = reservationRepository.countByEventId(eventId);
        if (reservasActuales >= event.getCapacity()) {
            throw new RuntimeException("El evento ya está completo");
        }

        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setEvent(event);
        reservation.setReservationDate(LocalDateTime.now());

        return reservationRepository.save(reservation);
    }

    @DeleteMapping("/{id}")
    public void cancelReservation(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
        Reservation res = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));

        if (!res.getUser().getUsername().equals(userDetails.getUsername())) {
            throw new RuntimeException("No autorizado para eliminar esta reserva");
        }

        reservationRepository.deleteById(id);
    }
}