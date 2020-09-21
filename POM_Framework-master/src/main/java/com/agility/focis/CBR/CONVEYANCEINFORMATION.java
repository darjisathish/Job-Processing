package com.agility.focis.CBR;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CONVEYANCEINFORMATION {
    @JacksonXmlProperty(localName = "VESSELNAME")
    private String vesselName;
    @JacksonXmlProperty(localName = "VOYAGENUMBER")
    private String voyageNumber;
    @JacksonXmlProperty(localName = "CARRIAGEFLAG")
    private String carrierFlag;
    @JacksonXmlProperty(localName = "IMONUMBER")
    private String imoNumber;
    @JacksonXmlProperty(localName = "CARRIERBOOKINGREFERENCE")
    private String carrierBookingReference;
    @JacksonXmlProperty(localName = "CARRIERDOCCUTOFF")
    private String carrierDOCCutOff;
    @JacksonXmlProperty(localName = "CARRIERCARGOCUTOFF")
    private String carrierCargoCutOff;
    @JacksonXmlProperty(localName = "ETD")
    private String etd;
    @JacksonXmlProperty(localName = "ETA")
    private String eta;
    @JacksonXmlProperty(localName = "ETDUTC")
    private String etdUTC;
    @JacksonXmlProperty(localName = "ETAUTC")
    private String etaUTC;
    @JacksonXmlProperty(localName = "CARRIERSCAC")
    private String carrierSCAC;
    @JacksonXmlProperty(localName = "CARRIERNAME")
    private String carrierName;
    @JacksonXmlElementWrapper(localName = "CARRIERCONTRACTNUMBERS", useWrapping = false)
    @JacksonXmlProperty(localName = "CARRIERCONTRACTNUMBERS")
    private CARRIERCONTRACTNUMBERS carriercontractnumbers;

    public String getVesselName() {
        return vesselName;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    public String getVoyageNumber() {
        return voyageNumber;
    }

    public void setVoyageNumber(String voyageNumber) {
        this.voyageNumber = voyageNumber;
    }

    public String getCarrierFlag() {
        return carrierFlag;
    }

    public void setCarrierFlag(String carrierFlag) {
        this.carrierFlag = carrierFlag;
    }

    public String getImoNumber() {
        return imoNumber;
    }

    public void setImoNumber(String imoNumber) {
        this.imoNumber = imoNumber;
    }

    public String getCarrierBookingReference() {
        return carrierBookingReference;
    }

    public void setCarrierBookingReference(String carrierBookingReference) {
        this.carrierBookingReference = carrierBookingReference;
    }

    public String getCarrierDOCCutOff() {
        return carrierDOCCutOff;
    }

    public void setCarrierDOCCutOff(String carrierDOCCutOff) {
        this.carrierDOCCutOff = carrierDOCCutOff;
    }

    public String getCarrierCargoCutOff() {
        return carrierCargoCutOff;
    }

    public void setCarrierCargoCutOff(String carrierCargoCutOff) {
        this.carrierCargoCutOff = carrierCargoCutOff;
    }

    public String getEtd() {
        return etd;
    }

    public void setEtd(String etd) {
        this.etd = etd;
    }

    public String getEta() {
        return eta;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }

    public String getEtdUTC() {
        return etdUTC;
    }

    public void setEtdUTC(String etdUTC) {
        this.etdUTC = etdUTC;
    }

    public String getEtaUTC() {
        return etaUTC;
    }

    public void setEtaUTC(String etaUTC) {
        this.etaUTC = etaUTC;
    }

    public String getCarrierSCAC() {
        return carrierSCAC;
    }

    public void setCarrierSCAC(String carrierSCAC) {
        this.carrierSCAC = carrierSCAC;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public CARRIERCONTRACTNUMBERS getCarriercontractnumbers() {
        return carriercontractnumbers;
    }

    public void setCarriercontractnumbers(CARRIERCONTRACTNUMBERS carriercontractnumbers) {
        this.carriercontractnumbers = carriercontractnumbers;
    }
}
