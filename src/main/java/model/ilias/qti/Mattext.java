package model.ilias.qti;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

public class Mattext {

    @JacksonXmlProperty(isAttribute = true, localName = "texttype")
    private String texttype = "text/xhtml";
    @JacksonXmlText
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
