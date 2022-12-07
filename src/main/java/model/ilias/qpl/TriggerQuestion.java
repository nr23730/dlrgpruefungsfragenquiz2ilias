package model.ilias.qpl;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

public class TriggerQuestion {

    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String id;
    @JacksonXmlText
    private String text = "";

    public TriggerQuestion(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

}
