package com.agility.focis.CBR;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

@JsonIgnoreProperties(ignoreUnknown = true)
public class INCOTERMLOCATION {
    @JacksonXmlProperty(isAttribute = true)
    private String INCOTERMTYPE;
    @JacksonXmlText()
    private String Location;

    public String getINCOTERMTYPE() {
        return INCOTERMTYPE;
    }

    public void setINCOTERMTYPE(String INCOTERMTYPE) {
        this.INCOTERMTYPE = INCOTERMTYPE;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }
}
