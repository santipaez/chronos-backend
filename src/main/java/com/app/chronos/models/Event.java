package com.app.chronos.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "events")
@ToString @EqualsAndHashCode
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private Integer id;

    @ManyToOne
    @Getter @Setter @JoinColumn(name = "user_id")
    private User user;

    @Getter @Setter @Column(name = "title", nullable = false)
    private String title;

    @Getter @Setter @Column(name = "description", nullable = false)
    private String description;

    @Getter @Setter @Column(name = "event_date", nullable = false)
    private LocalDate eventDate;

    @Getter @Setter @Column(name = "start_time", nullable = false)
    private LocalTime startTime;

    @Getter @Setter @Column(name = "end_time", nullable = false)
    private LocalTime endTime;

    @Getter @Setter @Column(name = "location", nullable = false)
    private String location;

}
