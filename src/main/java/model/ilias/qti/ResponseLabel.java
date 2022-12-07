package model.ilias.qti;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class ResponseLabel {

    @JacksonXmlProperty(isAttribute = true, localName = "ident")
    private String ident;
    @JacksonXmlProperty(localName = "material")
    private Material material = new Material();

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public Material getMaterial() {
        return material;
    }

}
