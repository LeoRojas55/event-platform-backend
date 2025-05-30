package com.davivienda.events.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class EventRequest {

    private Long id;
    private String title;
    private String description;
    private String date;
    private int capacity;

}
