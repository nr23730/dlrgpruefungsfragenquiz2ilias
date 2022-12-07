package model.ilias.qti;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

public class Setvar {

    @JacksonXmlProperty(isAttribute = true, localName = "action")
    private String action = "Add";
    @JacksonXmlText
    private String var;

    public void setAction(String action) {
        this.action = action;
    }

    public void setVar(String var) {
        this.var = var;
    }

}
