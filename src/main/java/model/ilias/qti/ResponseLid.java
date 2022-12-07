package model.ilias.qti;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class ResponseLid {

    @JacksonXmlProperty(isAttribute = true, localName = "ident")
    private IdentEnum ident;
    @JacksonXmlProperty(isAttribute = true, localName = "rcardinality")
    private RcardinalityEnum rcardinality;
    @JacksonXmlProperty(localName = "render_choice")
    private RenderChoice renderChoice = new RenderChoice();

    public IdentEnum getIdent() {
        return ident;
    }

    public void setIdent(IdentEnum ident) {
        this.ident = ident;
    }

    public RcardinalityEnum gtRecardinality() {
        return rcardinality;
    }

    public void setRcardinality(RcardinalityEnum rcardinality) {
        this.rcardinality = rcardinality;
    }

    public RenderChoice getRenderChoice() {
        return renderChoice;
    }

}
