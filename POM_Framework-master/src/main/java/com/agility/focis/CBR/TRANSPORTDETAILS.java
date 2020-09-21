package com.agility.focis.CBR;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TRANSPORTDETAILS {
    @JacksonXmlElementWrapper(localName = "TRANSPORT", useWrapping = false)
    @JacksonXmlProperty(localName = "TRANSPORT")
    private ArrayList<TRANSPORT> trasnports;

    public ArrayList<TRANSPORT> getTrasnports() {
        return trasnports;
    }

    public void setTrasnports(ArrayList<TRANSPORT> trasnports) {
        this.trasnports = trasnports;
    }
}
