package model.ilias.qpl;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class ContentObject {

    @JacksonXmlProperty(isAttribute = true, localName = "Type")
    private String type = "Questionpool_Test";
    @JacksonXmlProperty(localName = "MetaData")
    private MetaData metaData = new MetaData();
    @JacksonXmlProperty(localName = "Settings")
    private Settings settings = new Settings();
    @JacksonXmlProperty(localName = "PageObject")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<PageObject> pageObject = new ArrayList<>();
    @JacksonXmlProperty(localName = "QuestionSkillAssignments")
    private QuestionSkillAssignments questionSkillAssignments = new QuestionSkillAssignments();

    public MetaData getMetaData() {
        return metaData;
    }

    public Settings getSettings() {
        return settings;
    }

    public List<PageObject> getPageObject() {
        return pageObject;
    }

    public QuestionSkillAssignments getQuestionSkillAssignments() {
        return questionSkillAssignments;
    }

}
