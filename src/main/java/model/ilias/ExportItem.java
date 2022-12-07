package model.ilias;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

public class ExportItem {

    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String id;
    @JacksonXmlText
    private String text = "";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
