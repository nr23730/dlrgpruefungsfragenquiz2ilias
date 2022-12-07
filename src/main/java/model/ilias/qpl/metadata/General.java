package model.ilias.qpl.metadata;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class General {

    @JacksonXmlProperty(isAttribute = true, localName = "Structure")
    private String structure = "Hierarchical";
    @JacksonXmlProperty(localName = "Identifier")
    private Identifier identifier = new Identifier();
    @JacksonXmlProperty(localName = "Title")
    private Title title = new Title();
    @JacksonXmlProperty(localName = "Language")
    private Language language = new Language();
    @JacksonXmlProperty(localName = "Description")
    private Description description = new Description();
    @JacksonXmlProperty(localName = "Keyword")
    private Keyword keyword = new Keyword();

    public Identifier getIdentifier() {
        return identifier;
    }

    public Title getTitle() {
        return title;
    }

    public Language getLanguage() {
        return language;
    }

    public Description getDescription() {
        return description;
    }

    public Keyword getKeyword() {
        return keyword;
    }
}
