package com.agility.focis.CBR;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "DETAILS")
@JsonIgnoreProperties(ignoreUnknown = true)
public class JOBDETAILS {
    @JacksonXmlProperty(localName = "JOBNUMBER")
    private String jobNumber;

    @JacksonXmlProperty(localName = "JOBCREATEDDATE")
    private String creationDate;

    @JacksonXmlProperty(localName = "PRODUCT")
    private String product;

    @JacksonXmlProperty(localName = "PRODUCTTYPE")
    private String productType;

    @JacksonXmlElementWrapper(localName = "JOBSTATUS", useWrapping = false)
    @JacksonXmlProperty(localName = "JOBSTATUS")
    private JOBSTATUS jobStatus;

    @JacksonXmlElementWrapper(localName = "INCOTERMLOCATION", useWrapping = false)
    @JacksonXmlProperty(localName = "INCOTERMLOCATION")
    private INCOTERMLOCATION incotermlocation;
    @JacksonXmlElementWrapper(localName = "PARTIES", useWrapping = false)
    @JacksonXmlProperty(localName = "PARTIES")
    private Parties parties;
    @JacksonXmlElementWrapper(localName = "JOBREFERENCES", useWrapping = false)
    @JacksonXmlProperty(localName = "JOBREFERENCES")
    private JOBREFERENCES jobReferences;
    @JacksonXmlElementWrapper(localName = "TRANSPORTDETAILS", useWrapping = false)
    @JacksonXmlProperty(localName = "TRANSPORTDETAILS")
    private TRANSPORTDETAILS transportdetails;
    @JacksonXmlElementWrapper(localName = "EVENTDETAILS", useWrapping = false)
    @JacksonXmlProperty(localName = "EVENTDETAILS")
    private EVENTDETAILS eventdetails;

    public JOBREFERENCES getJobReferences() {
        return jobReferences;
    }

    public void setJobReferences(JOBREFERENCES jobReferences) {
        this.jobReferences = jobReferences;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getProduct() {
        return product;
    }

    public String getProductType() {
        return productType;
    }

    public Parties getParties() {
        return parties;
    }

    public void setParties(Parties parties) {
        this.parties = parties;
    }

    public INCOTERMLOCATION getIncotermlocation() {
        return incotermlocation;
    }

    public void setIncotermlocation(INCOTERMLOCATION incotermlocation) {
        this.incotermlocation = incotermlocation;
    }

    public TRANSPORTDETAILS getTransportdetails() {
        return transportdetails;
    }

    public void setTransportdetails(TRANSPORTDETAILS transportdetails) {
        this.transportdetails = transportdetails;
    }

    public EVENTDETAILS getEventdetails() {
        return eventdetails;
    }

    public void setEventdetails(EVENTDETAILS eventdetails) {
        this.eventdetails = eventdetails;
    }

    public JOBSTATUS getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(JOBSTATUS jobStatus) {
        this.jobStatus = jobStatus;
    }

    @Override
    public String toString() {
        return "JobDetails [jobNumber=" + jobNumber + ", creationDate=" + creationDate
                + ", product=" + product + ", productType=" + productType + ",Parties=" + parties + "]";
    }
}
