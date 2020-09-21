package com.agility.focis.CBR;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.Map;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Party {
    @JacksonXmlProperty(localName = "PARTYTYPE")
    private String partyType;
    @JacksonXmlProperty(localName = "PARTYID")
    private String partyID;
    @JacksonXmlProperty(localName = "PARTYNAME")
    private String partyName;
    @JacksonXmlProperty(localName = "NWCCODE")
    private String nwcCode;
    @JacksonXmlElementWrapper(localName = "ADDRESS", useWrapping = false)
    @JacksonXmlProperty(localName = "ADDRESS")
    private ADDRESS address;

    public ADDRESS getAddress() {
        return address;
    }

    public void setAddress(ADDRESS address) {
        this.address = address;
    }

    public void setPartyType(String partyType) {
        this.partyType = partyType;
    }

    public void setPartyID(String partyID) {
        this.partyID = partyID;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public void setNwcCode(String nwcCode) {
        this.nwcCode = nwcCode;
    }

    public String getPartyType() {
        return partyType;
    }

    public String getPartyID() {
        return partyID;
    }

    public String getPartyName() {
        return partyName;
    }

    public String getNwcCode() {
        return nwcCode;
    }

}
