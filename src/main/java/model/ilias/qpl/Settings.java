package model.ilias.qpl;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Settings {

    @JacksonXmlProperty(localName = "ShowTaxonomies")
    private Integer showTaxonomies = 0;
    @JacksonXmlProperty(localName = "NavTaxonomy")
    private Integer navTaxonomy = 0;
    @JacksonXmlProperty(localName = "SkillService")
    private Integer skillService = 0;

}
