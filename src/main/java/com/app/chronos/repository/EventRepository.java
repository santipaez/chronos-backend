package com.app.chronos.repository;

import com.app.chronos.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    // Métodos personalizados de consulta pueden ir aquí
}
