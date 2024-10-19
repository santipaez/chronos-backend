package com.app.chronos.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.time.Instant;
import java.time.LocalTime;

@Entity
@Table(name = "schedules")
@ToString @EqualsAndHashCode
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private Long id;

    @ManyToOne
    @Getter @Setter @JoinColumn(name = "user_id")
    private User user;

    @Getter @Setter @Column(name = "name", nullable = false)
    private String name;

    @Getter @Setter @Column(name = "description", nullable = false)
    private String description;

    @Getter @Setter @Column(name = "start_time", nullable = false)
    private LocalTime startTime;

    @Getter @Setter @Column(name = "end_time", nullable = false)
    private LocalTime endTime;

    @Getter @Setter @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt = Instant.now();
}