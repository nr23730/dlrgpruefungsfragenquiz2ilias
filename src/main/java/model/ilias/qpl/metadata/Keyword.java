package model.ilias.qpl.metadata;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Keyword {

    @JacksonXmlProperty(isAttribute = true, localName = "Language")
    private String language = "de";

}
