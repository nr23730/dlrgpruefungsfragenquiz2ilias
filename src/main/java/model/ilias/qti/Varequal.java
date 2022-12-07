package model.ilias.qti;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

public class Varequal {

    @JacksonXmlProperty(isAttribute = true, localName = "respident")
    private IdentEnum respident;
    @JacksonXmlText
    private String ident;

    public void setRespident(IdentEnum respident) {
        this.respident = respident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

}
