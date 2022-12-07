package model.ilias.qpl.metadata;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Language {

    @JacksonXmlProperty(isAttribute = true, localName = "Language")
    private String language = "de";

}
