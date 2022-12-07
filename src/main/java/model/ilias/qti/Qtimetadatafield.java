package model.ilias.qti;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Qtimetadatafield {

    @JacksonXmlProperty(localName = "fieldlabel")
    private String fieldlabel;
    @JacksonXmlProperty(localName = "fieldentry")
    private String fieldentry;

    public void setFieldlabel(String fieldlabel) {
        this.fieldlabel = fieldlabel;
    }

    public void setFieldentry(String fieldentry) {
        this.fieldentry = fieldentry;
    }

}
