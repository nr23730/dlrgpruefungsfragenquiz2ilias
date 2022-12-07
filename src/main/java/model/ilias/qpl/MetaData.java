package model.ilias.qpl;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import model.ilias.qpl.metadata.General;

public class MetaData {

    @JacksonXmlProperty(localName = "General")
    private General general = new General();

    public General getGeneral() {
        return general;
    }

}
