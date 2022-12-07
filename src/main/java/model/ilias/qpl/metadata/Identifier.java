package model.ilias.qpl.metadata;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Identifier {

    @JacksonXmlProperty(isAttribute = true, localName = "Catalog")
    private String catalog = "ILIAS";
    @JacksonXmlProperty(isAttribute = true, localName = "Entry")
    private String entry;

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

}
