package model.ilias.qpl;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Question {

    @JacksonXmlProperty(isAttribute = true, localName = "QRef")
    private String qref;

    public Question(String qref) {
        this.qref = qref;
    }

    public String getQref() {
        return qref;
    }

}
