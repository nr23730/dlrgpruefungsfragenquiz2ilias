package model.ilias.qti;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Itemfeedback {

    @JacksonXmlProperty(isAttribute = true, localName = "ident")
    private String ident;
    @JacksonXmlProperty(isAttribute = true, localName = "view")
    private String view = "All";
    @JacksonXmlProperty(localName = "flow_mat")
    private FlowMat flowMat = new FlowMat();

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public FlowMat getFlowMat() {
        return flowMat;
    }

    public void setFlowMat(FlowMat flowMat) {
        this.flowMat = flowMat;
    }

}
