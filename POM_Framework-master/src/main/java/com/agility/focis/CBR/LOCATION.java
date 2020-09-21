package com.agility.focis.CBR;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LOCATION {
    @JacksonXmlProperty(isAttribute = true)
    private String LOCATIONTYPE;
    @JacksonXmlElementWrapper(localName = "LOCATIONCODE", useWrapping = false)
    @JacksonXmlProperty(localName = "LOCATIONCODE")
    private LOCATIONCODE locationcode;
    @JacksonXmlProperty(localName = "LOCATIONNAME")
    private String locationName;
    @JacksonXmlProperty(localName = "CITY")
    private String city;
    @JacksonXmlProperty(localName = "SUBDIVISION")
    private String subDivision;
    @JacksonXmlProperty(localName = "COUNTRYNAME")
    private String countryName;
    @JacksonXmlProperty(localName = "LOCATIONCOUNTRY")
    private String countryCode;

    public String getLOCATIONTYPE() {
        return LOCATIONTYPE;
    }

    public void setLOCATIONTYPE(String LOCATIONTYPE) {
        this.LOCATIONTYPE = LOCATIONTYPE;
    }

    public LOCATIONCODE getLocationcode() {
        return locationcode;
    }

    public void setLocationcode(LOCATIONCODE locationcode) {
        this.locationcode = locationcode;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSubDivision() {
        return subDivision;
    }

    public void setSubDivision(String subDivision) {
        this.subDivision = subDivision;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
