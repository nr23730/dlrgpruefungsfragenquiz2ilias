package model.ilias.qti;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Flow {

    @JacksonXmlProperty(localName = "material")
    private Material material = new Material();
    @JacksonXmlProperty(localName = "response_lid")
    private ResponseLid responseLid = new ResponseLid();

    public Material getMaterial() {
        return material;
    }

    public ResponseLid getResponseLid() {
        return responseLid;
    }

}
