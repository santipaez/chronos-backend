package com.app.chronos.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.chronos.models.Event;
import com.app.chronos.repository.EventRepository;
import java.time.LocalDate;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public void create(Event event) {
        if (event.isValidTimeFormat(event.getStartTime())) {
            eventRepository.save(event);
        } else {
            throw new IllegalArgumentException("Invalid time format");
        }
    }

    public Event getEvent(Integer id) {
        Optional<Event> event = eventRepository.findById(id);
        return event.orElse(null);
    }

    public List<Event> getEvents() {
        return eventRepository.findAll();
    }


    public List<Event> getEventsByDate(LocalDate date) {
        return eventRepository.findByDate(date);
    }

    public void delete(Integer id) {
        eventRepository.deleteById(id);
    }

    public Event updateEvent(Integer id, Event updatedEvent) {
        Optional<Event> existingEvent = eventRepository.findById(id);
        if (existingEvent.isPresent()) {
            Event event = existingEvent.get();
            if (event.isValidTimeFormat(updatedEvent.getStartTime())) {
                event.setName(updatedEvent.getName());
                event.setDescription(updatedEvent.getDescription());
                event.setStartTime(updatedEvent.getStartTime());
                event.setDate(updatedEvent.getDate());
                return eventRepository.save(event);
            } else {
                throw new IllegalArgumentException("Invalid time format");
            }
        } else {
            return null;
        }
    }
}