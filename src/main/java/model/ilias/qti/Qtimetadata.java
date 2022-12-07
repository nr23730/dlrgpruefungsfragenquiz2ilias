package model.ilias.qti;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Qtimetadata {

    @JacksonXmlProperty(localName = "qtimetadatafield")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Qtimetadatafield> qtimetadatafield = new ArrayList<>();

    public List<Qtimetadatafield> getQtimetadatafield() {
        return qtimetadatafield;
    }

}
