package model.ilias.qti;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Material {

    @JacksonXmlProperty(localName = "mattext")
    private Mattext mattext = new Mattext();

    public Mattext getMattext() {
        return mattext;
    }

}
