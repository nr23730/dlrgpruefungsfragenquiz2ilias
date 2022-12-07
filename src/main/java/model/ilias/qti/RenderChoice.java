package model.ilias.qti;

import java.util.List;
import java.util.ArrayList;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class RenderChoice {

    @JacksonXmlProperty(isAttribute = true, localName = "shuffle")
    private String shuffle = "Yes";
    @JacksonXmlProperty(localName = "response_label")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<ResponseLabel> responseLabel = new ArrayList<>();

    public List<ResponseLabel> getResponseLabel() {
        return responseLabel;
    }

}
