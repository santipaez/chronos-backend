package com.app.chronos.controller;

import com.app.chronos.models.Event;
import com.app.chronos.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {
    @Autowired
    private EventService eventService;

    @PostMapping
    public void createEvent(@RequestBody Event event) {
        eventService.create(event);
    }

    @GetMapping("/{id}")
    public Event getEvent(@PathVariable Integer id) {
        return eventService.getEvent(id);
    }

    @GetMapping
    public List<Event> getEvents() {
        return eventService.getEvents();
    }

    @GetMapping("/date/{date}")
    public List<Event> getEventsByDate(@PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        return eventService.getEventsByDate(localDate);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Integer id) {
        eventService.delete(id);
    }

    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable Integer id, @RequestBody Event updatedEvent) {
        return eventService.updateEvent(id, updatedEvent);
    }
}