package model.ilias;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class ExportFile {
    
    @JacksonXmlProperty(isAttribute = true, localName = "Component")
    private String component = "Modules/TestQuestionPool";
    @JacksonXmlProperty(isAttribute = true, localName = "Path")
    private String path = "Modules/TestQuestionPool/set_1/export.xml";

}
