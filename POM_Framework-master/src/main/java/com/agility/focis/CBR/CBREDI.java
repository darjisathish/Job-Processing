package com.agility.focis.CBR;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;

public class CBREDI {

    public static JOBDETAILS getEDIInfo(String xmlFile) throws JsonProcessingException {
        XmlMapper mapper = new XmlMapper();
        return mapper.readValue(xmlFile, JOBDETAILS.class);
    }
}
