package com.app.chronos.service;

import com.app.chronos.models.Schedule;
import com.app.chronos.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    public void register(Schedule schedule) {
        if (schedule.isValidTimeFormat(schedule.getStartTime()) && schedule.isValidTimeFormat(schedule.getEndTime())) {
            scheduleRepository.save(schedule);
        } else {
            throw new IllegalArgumentException("Invalid time format");
        }
    }

    public Schedule getSchedule(Integer id) {
        Optional<Schedule> schedule = scheduleRepository.findById(id);
        return schedule.orElse(null);
    }

    public List<Schedule> getSchedules() {
        return scheduleRepository.findAll();
    }

    public List<Schedule> getSchedulesByUser(String username) {
        return scheduleRepository.findByUserUsername(username);
    }

    public List<Schedule> getSchedulesByDayAndUser(String day, String username) {
        return scheduleRepository.findByDayAndUserUsername(day, username);
    }

    public void delete(Integer id) {
        scheduleRepository.deleteById(id);
    }

    public Schedule updateSchedule(Integer id, Schedule updatedSchedule) {
        Optional<Schedule> existingSchedule = scheduleRepository.findById(id);
        if (existingSchedule.isPresent()) {
            Schedule schedule = existingSchedule.get();
            if (schedule.isValidTimeFormat(updatedSchedule.getStartTime()) && schedule.isValidTimeFormat(updatedSchedule.getEndTime())) {
                schedule.setName(updatedSchedule.getName());
                schedule.setDescription(updatedSchedule.getDescription());
                schedule.setStartTime(updatedSchedule.getStartTime());
                schedule.setEndTime(updatedSchedule.getEndTime());
                schedule.setDay(updatedSchedule.getDay());
                return scheduleRepository.save(schedule);
            } else {
                throw new IllegalArgumentException("Invalid time format");
            }
        } else {
            return null;
        }
    }
}