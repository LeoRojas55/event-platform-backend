package com.davivienda.events.dto;

import com.davivienda.events.model.Event;
import com.davivienda.events.model.Reservation;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ReservationResponse {
    private Reservation reservation;
}
