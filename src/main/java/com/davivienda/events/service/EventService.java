package com.davivienda.events.service;

import com.davivienda.events.model.Event;
import com.davivienda.events.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    private EventRepository repo;
    public Event create(String title, String date, int capacity, String description) {
        Event event = new Event();
        event.setDate(date);
        event.setTitle(title);
        event.setCapacity(capacity);
        event.setDescription(description);
        return repo.save(event);
    }
    public List<Event> read(){
        return repo.findAll();
    }

    public Optional<Event> findById(Long id) {

        return repo.findById(id);
    }

    public Event update(Long id, String title, String date, int capacity, String description) {
        Event event = new Event();
        event.setId(id);
        event.setDate(date);
        event.setTitle(title);
        event.setCapacity(capacity);
        event.setDescription(description);
        return repo.save(event);

    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
