package model.ilias.qti;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Presentation {

    @JacksonXmlProperty(isAttribute = true, localName = "label")
    private String label;
    @JacksonXmlProperty(localName = "flow")
    private Flow flow = new Flow();

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Flow getFlow() {
        return flow;
    }

}
