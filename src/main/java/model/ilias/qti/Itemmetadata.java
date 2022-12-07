package model.ilias.qti;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Itemmetadata {

    @JacksonXmlProperty(localName = "qtimetadata")
    private Qtimetadata qtimetadata = new Qtimetadata();

    public Qtimetadata getQtimetadata() {
        return qtimetadata;
    }

}
