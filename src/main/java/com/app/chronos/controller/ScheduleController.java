package com.app.chronos.controller;

import com.app.chronos.models.Schedule;
import com.app.chronos.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @PostMapping
    public void createSchedule(@RequestBody Schedule schedule) {
        scheduleService.register(schedule);
    }

    @GetMapping("/{id}")
    public Schedule getSchedule(@PathVariable Integer id) {
        return scheduleService.getSchedule(id);
    }

    @GetMapping
    public List<Schedule> getSchedules() {
        return scheduleService.getSchedules();
    }

    @GetMapping("/day/{day}")
    public List<Schedule> getSchedulesByDay(@PathVariable String day) {
        return scheduleService.getSchedulesByDay(day);
    }

    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable Integer id) {
        scheduleService.delete(id);
    }

    @PutMapping("/{id}")
    public Schedule updateSchedule(@PathVariable Integer id, @RequestBody Schedule updatedSchedule) {
        return scheduleService.updateSchedule(id, updatedSchedule);
    }
}