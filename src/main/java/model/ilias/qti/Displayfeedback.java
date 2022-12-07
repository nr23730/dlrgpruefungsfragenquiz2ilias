package model.ilias.qti;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Displayfeedback {

    @JacksonXmlProperty(isAttribute = true, localName = "feedbacktype")
    private String feedbacktype = "Response";
    @JacksonXmlProperty(isAttribute = true, localName = "linkrefid")
    private String linkrefid;

    public void setFeedbacktype(String feedbacktype) {
        this.feedbacktype = feedbacktype;
    }

    public void setLinkrefid(String linkrefid) {
        this.linkrefid = linkrefid;
    }

}
