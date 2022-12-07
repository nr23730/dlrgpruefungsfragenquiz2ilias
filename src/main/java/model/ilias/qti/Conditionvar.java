package model.ilias.qti;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Conditionvar {

    @JacksonXmlProperty(localName = "varequal")
    private Varequal varequal = new Varequal();

    public Varequal getVarequal() {
        return varequal;
    }

}
