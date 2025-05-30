package com.davivienda.events.dto;

import com.davivienda.events.model.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EventResponse {

    private Event event;

}
