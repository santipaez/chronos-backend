package com.app.chronos.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.time.LocalDate;

@Entity
@Table(name = "events")
@ToString @EqualsAndHashCode
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private Integer id;

    @Getter @Setter @Column(name = "date")
    private LocalDate date;

    @Getter @Setter @Column(name = "name")
    private String name;

    @Getter @Setter @Column(name = "description")
    private String description;

    @Getter @Setter @Column(name = "start_time")
    private String startTime;

        // Método para validar el formato de la hora
        public boolean isValidTimeFormat(String time) {
            return time.matches("^([01]\\d|2[0-3]):([0-5]\\d)$");
        }
}