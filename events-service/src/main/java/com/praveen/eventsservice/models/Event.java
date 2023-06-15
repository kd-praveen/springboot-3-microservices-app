package com.praveen.eventsservice.models;

import java.time.LocalTime;
import java.util.Date;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DynamicUpdate
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "events")
public class Event {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "event_name", unique = true)
    private String eventName;

    @Column(name = "event_date")
    private Date eventDate;

    @Column(name = "event_time")
    private LocalTime eventTime;

    @Column(name = "event_location")
    private String eventLocation;

    @Column(name = "event_description")
    private String eventDescription;

    @Column(name = "created_by")
    private Integer userId;

}
