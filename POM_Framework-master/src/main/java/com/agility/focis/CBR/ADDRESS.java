package com.agility.focis.CBR;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import org.apache.commons.lang.WordUtils;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ADDRESS {
    @JacksonXmlProperty(localName = "ADDRESSTYPE")
    private String addressType;
    @JacksonXmlProperty(localName = "ADDRESSLINE1")
    private String addressLine1;
    @JacksonXmlProperty(localName = "ADDRESSLINE2")
    private String addressLine2;
    @JacksonXmlProperty(localName = "ADDRESSLINE3")
    private String addressLine3;
    @JacksonXmlProperty(localName = "ADDRESSLINE4")
    private String addressLine4;
    @JacksonXmlProperty(localName = "ADDRESSLINE5")
    private String addressLine5;
    @JacksonXmlProperty(localName = "ADDRESSLINE6")
    private String addressLine6;
    @JacksonXmlProperty(localName = "CITY")
    private String city;
    @JacksonXmlProperty(localName = "STATE")
    private String state;
    @JacksonXmlProperty(localName = "COUNTRYCODE")
    private String countryCode;
    @JacksonXmlProperty(localName = "COUNTRYNAME")
    private String countryName;
    @JacksonXmlProperty(localName = "POSTCODE")
    private String postalCode;
    @JacksonXmlElementWrapper(localName = "PARTYREFERENCES", useWrapping = false)
    @JacksonXmlProperty(localName = "PARTYREFERENCES")
    private PARTYREFERENCES partyReferences;

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public String getAddressLine4() {
        return addressLine4;
    }

    public void setAddressLine4(String addressLine4) {
        this.addressLine4 = addressLine4;
    }

    public String getAddressLine5() {
        return addressLine5;
    }

    public void setAddressLine5(String addressLine5) {
        this.addressLine5 = addressLine5;
    }

    public String getAddressLine6() {
        return addressLine6;
    }

    public void setAddressLine6(String addressLine6) {
        this.addressLine6 = addressLine6;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public PARTYREFERENCES getPartyReferences() {
        return partyReferences;
    }

    public void setPartyReferences(PARTYREFERENCES partyReferences) {
        this.partyReferences = partyReferences;
    }

    public String getAddressAsString() {
        String address = "";
        if (!getAddressLine1().equalsIgnoreCase("")) {
            address = address + getAddressLine1().trim() + "\n";
        }
        if (!getAddressLine2().equalsIgnoreCase("")) {
            address = address + getAddressLine2() + "\n";
        }
        if (!getAddressLine3().equalsIgnoreCase("")) {
            address = address + getAddressLine3() + "\n";
        }
        if (!getAddressLine4().equalsIgnoreCase("")) {
            address = address + getAddressLine4() + "\n";
        }
        if (!getAddressLine5().equalsIgnoreCase("")) {
            address = address + getAddressLine5() + "\n";
        }
        if (!getAddressLine6().equalsIgnoreCase("")) {
            address = address + getAddressLine6() + "\n";
        }

        return address.trim();
    }
}
