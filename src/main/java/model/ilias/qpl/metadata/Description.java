package model.ilias.qpl.metadata;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

public class Description {

    @JacksonXmlProperty(isAttribute = true, localName = "Language")
    private String language = "de";
    @JacksonXmlText
    private String description = "";

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
