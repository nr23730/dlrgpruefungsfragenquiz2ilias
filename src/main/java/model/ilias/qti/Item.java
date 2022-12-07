package model.ilias.qti;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Item {

    @JacksonXmlProperty(isAttribute = true, localName = "ident")
    private String ident;
    @JacksonXmlProperty(isAttribute = true, localName = "title")
    private String title;
    @JacksonXmlProperty(isAttribute = true, localName = "maxattempts")
    private String maxAttempts = "0";
    @JacksonXmlProperty(localName = "qticomment")
    private String qtiComment = "";
    @JacksonXmlProperty(localName = "duration")
    private String duration = "P0Y0M0DT0H1M0S";
    @JacksonXmlProperty(localName = "itemmetadata")
    private Itemmetadata itemMetadata = new Itemmetadata();
    @JacksonXmlProperty(localName = "presentation")
    private Presentation presentation = new Presentation();
    @JacksonXmlProperty(localName = "resprocessing")
    private Resprocessing resprocessing = new Resprocessing();
    @JacksonXmlProperty(localName = "itemfeedback")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Itemfeedback> itemfeedback = new ArrayList<>();

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Itemmetadata getItemMetadata() {
        return itemMetadata;
    }

    public Presentation getPresentation() {
        return presentation;
    }

    public Resprocessing getResprocessing() {
        return resprocessing;
    }

    public List<Itemfeedback> getItemfeedback() {
        return itemfeedback;
    }

}
