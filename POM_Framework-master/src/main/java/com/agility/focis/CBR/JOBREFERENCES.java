package com.agility.focis.CBR;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;

public class JOBREFERENCES {
    public ArrayList<REFERENCES> getReferences() {
        return references;
    }

    public void setReferences(ArrayList<REFERENCES> references) {
        this.references = references;
    }

    @JacksonXmlElementWrapper(localName = "REFERENCES", useWrapping = false)
    @JacksonXmlProperty(localName = "REFERENCES")
    private ArrayList<REFERENCES> references;
}
