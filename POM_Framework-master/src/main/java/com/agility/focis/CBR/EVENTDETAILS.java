package com.agility.focis.CBR;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;

public class EVENTDETAILS {
    @JacksonXmlElementWrapper(localName = "EVENTS", useWrapping = false)
    @JacksonXmlProperty(localName = "EVENTS")
    private ArrayList<EVENTS> events;

    public ArrayList<EVENTS> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<EVENTS> events) {
        this.events = events;
    }
}
