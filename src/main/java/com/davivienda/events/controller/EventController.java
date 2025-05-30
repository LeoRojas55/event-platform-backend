package com.davivienda.events.controller;

import java.util.List;
import java.util.Optional;

import com.davivienda.events.dto.EventRequest;
import com.davivienda.events.dto.EventResponse;
import com.davivienda.events.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davivienda.events.model.Event;

@RestController
@RequestMapping("/api/events")
public class EventController {


    @Autowired private EventService eventService;

    @PostMapping("/create")
    public ResponseEntity<EventResponse> create(@RequestBody EventRequest request) {
        Event event =eventService.create(request.getTitle(),
                request.getDate(),
                request.getCapacity(),
                request.getDescription());

        EventResponse eventResponse =
                EventResponse.builder()
                        .event(event)
                        .build();
        return ResponseEntity.ok().body(eventResponse);
    }

    @GetMapping("/show")
    public ResponseEntity<List<Event>> show() {
        List<Event> eventList = eventService.read();
        return ResponseEntity.ok().body(eventList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventResponse>getEventById(@PathVariable Long id) {
        Optional<Event> event = eventService.findById(id);
        EventResponse eventResponse =
                EventResponse.builder()
                        .event(event.orElse(null))
                        .build();
        return ResponseEntity.ok().body(eventResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventResponse> updateEvent(@PathVariable Long id, @RequestBody EventRequest request) {
        //Event event = eventRepository.findById(id).orElseThrow(() -> new RuntimeException("Evento no encontrado"));
        Event event =eventService.update(request.getId(),
                request.getTitle(),
                request.getDate(),
                request.getCapacity(),
                request.getDescription());

        EventResponse eventResponse =
                EventResponse.builder()
                        .event(event)
                        .build();
        return ResponseEntity.ok().body(eventResponse);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
