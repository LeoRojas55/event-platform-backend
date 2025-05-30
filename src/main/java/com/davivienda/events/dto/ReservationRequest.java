package com.davivienda.events.dto;

import lombok.Data;

@Data
public class ReservationRequest {
    private Long id;
    private Long eventId;
    private Long userId;
}
