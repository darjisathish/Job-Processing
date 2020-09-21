package com.agility.focis.CBR;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TRANSPORT {
    @JacksonXmlElementWrapper(localName = "LOCATION", useWrapping = false)
    @JacksonXmlProperty(localName = "LOCATION")
    private ArrayList<LOCATION> locations;
    @JacksonXmlProperty(isAttribute = true)
    private String TRANSPORTMODE;
    @JacksonXmlProperty(isAttribute = true)
    private String TRANSPORTSTAGE;
    @JacksonXmlElementWrapper(localName = "CONVEYANCEINFORMATION", useWrapping = false)
    @JacksonXmlProperty(localName = "CONVEYANCEINFORMATION")
    private CONVEYANCEINFORMATION conveyanceinformation;

    public ArrayList<LOCATION> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<LOCATION> locations) {
        this.locations = locations;
    }

    public String getTRANSPORTMODE() {
        return TRANSPORTMODE;
    }

    public void setTRANSPORTMODE(String TRANSPORTMODE) {
        this.TRANSPORTMODE = TRANSPORTMODE;
    }

    public String getTRANSPORTSTAGE() {
        return TRANSPORTSTAGE;
    }

    public void setTRANSPORTSTAGE(String TRANSPORTSTAGE) {
        this.TRANSPORTSTAGE = TRANSPORTSTAGE;
    }

    public CONVEYANCEINFORMATION getConveyanceinformation() {
        return conveyanceinformation;
    }

    public void setConveyanceinformation(CONVEYANCEINFORMATION conveyanceinformation) {
        this.conveyanceinformation = conveyanceinformation;
    }
}
