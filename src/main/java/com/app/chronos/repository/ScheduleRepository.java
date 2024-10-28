package com.app.chronos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.chronos.models.Schedule;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    List<Schedule> findByDay(String day);
}