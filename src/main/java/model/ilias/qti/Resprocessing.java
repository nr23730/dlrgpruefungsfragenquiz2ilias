package model.ilias.qti;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Resprocessing {

    @JacksonXmlProperty(localName = "outcomes")
    private Outcomes outcomes = new Outcomes();
    @JacksonXmlProperty(localName = "respcondition")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Respcondition> respcondition = new ArrayList<>();

    public List<Respcondition> getRespcondition() {
        return respcondition;
    }

}
