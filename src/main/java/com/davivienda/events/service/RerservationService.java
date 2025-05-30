package com.davivienda.events.service;

import com.davivienda.events.model.Event;
import com.davivienda.events.model.Reservation;
import com.davivienda.events.model.User;
import com.davivienda.events.repository.EventRepository;
import com.davivienda.events.repository.ReservationRepository;
import com.davivienda.events.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RerservationService {
    @Autowired
    private EventRepository eventRepo;
    @Autowired
    private ReservationRepository reservationRepo;
    @Autowired
    private UserRepository userRepo;

    public Reservation create(Long eventId, Long userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Event event = eventRepo.findById(eventId).orElseThrow(() -> new RuntimeException("Event not found"));

        Reservation reservation = new Reservation();
        reservation.setEvent(event);
        reservation.setUser(user);

        return reservationRepo.save(reservation);
    }

    public List<Reservation> read() {
        return reservationRepo.findAll();
    }

    public Optional<Reservation> findById(Long id) {
        return reservationRepo.findById(id);
    }

    public Reservation update(Long id, Long userId, Long eventId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Event event = eventRepo.findById(eventId).orElseThrow(() -> new RuntimeException("Event not found"));

        Reservation reservation = new Reservation();
        reservation.setId(id);
        reservation.setEvent(event);
        reservation.setUser(user);

        return reservationRepo.save(reservation);
    }

    public void deleteById(Long id) {
        reservationRepo.deleteById(id);
    }
}
