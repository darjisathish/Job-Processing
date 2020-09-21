package com.agility.focis.CBR;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EVENTS {
    @JacksonXmlProperty(localName = "EVENTTYPE")
    private String eventType;
    @JacksonXmlProperty(localName = "EVENTNAME")
    private String eventName;
    @JacksonXmlProperty(localName = "EVENTSTATUS")
    private String eventStatus;
    @JacksonXmlProperty(localName = "EVENTLOCATION")
    private String eventLocation;
    @JacksonXmlProperty(localName = "EVENTLOCATIONDATETIME")
    private String eventLocationDateTime;
    @JacksonXmlProperty(localName = "EVENTLOCATIONUTCDATETIME")
    private String eventLocationUTCDateTime;
    @JacksonXmlProperty(localName = "REMARKS")
    private String remarks;
    @JacksonXmlProperty(localName = "EVENTUPDATEDUTCDATETIME")
    private String eventUpdateDateandTime;
    @JacksonXmlProperty(localName = "EVENTUPDATEDBY")
    private String eventUpdatedBy;

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventLocationDateTime() {
        return eventLocationDateTime;
    }

    public void setEventLocationDateTime(String eventLocationDateTime) {
        this.eventLocationDateTime = eventLocationDateTime;
    }

    public String getEventLocationUTCDateTime() {
        return eventLocationUTCDateTime;
    }

    public void setEventLocationUTCDateTime(String eventLocationUTCDateTime) {
        this.eventLocationUTCDateTime = eventLocationUTCDateTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getEventUpdateDateandTime() {
        return eventUpdateDateandTime;
    }

    public void setEventUpdateDateandTime(String eventUpdateDateandTime) {
        this.eventUpdateDateandTime = eventUpdateDateandTime;
    }

    public String getEventUpdatedBy() {
        return eventUpdatedBy;
    }

    public void setEventUpdatedBy(String eventUpdatedBy) {
        this.eventUpdatedBy = eventUpdatedBy;
    }
}
