package model.ilias.qti;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class FlowMat {

    @JacksonXmlProperty(localName = "material")
    private Material material = new Material();

    public Material getMaterial() {
        return material;
    }

}
