package com.app.chronos.repository;

import com.app.chronos.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.time.LocalDate;

public interface EventRepository extends JpaRepository<Event, Integer> {
    List<Event> findByDate(LocalDate date);
}