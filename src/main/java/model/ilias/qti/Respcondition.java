package model.ilias.qti;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Respcondition {

    @JacksonXmlProperty(isAttribute = true, localName = "continue")
    private String conti = "Yes";
    @JacksonXmlProperty(localName = "conditionvar")
    private Conditionvar conditionvar = new Conditionvar();
    @JacksonXmlProperty(localName = "setvar")
    private Setvar setvar = new Setvar();
    @JacksonXmlProperty(localName = "displayfeedback")
    private Displayfeedback displayfeedback = new Displayfeedback();

    public Conditionvar getConditionvar() {
        return conditionvar;
    }

    public Setvar getSetvar() {
        return setvar;
    }

    public Displayfeedback getDisplayfeedback() {
        return displayfeedback;
    }

}
