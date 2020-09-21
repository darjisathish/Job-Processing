package com.agility.focis.CBR;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LOCATIONCODE {
    @JacksonXmlProperty(isAttribute = true)
    private String LOCATIONQUALIFIER;
    @JacksonXmlText()
    private String code;

    public String getLOCATIONQUALIFIER() {
        return LOCATIONQUALIFIER;
    }

    public void setLOCATIONQUALIFIER(String LOCATIONQUALIFIER) {
        this.LOCATIONQUALIFIER = LOCATIONQUALIFIER;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
