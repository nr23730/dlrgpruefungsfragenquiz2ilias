package model.ilias.qpl;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class QuestionSkillAssignments {

    @JacksonXmlProperty(localName = "TritterQuestion")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<TriggerQuestion> triggerQuestion = new ArrayList<>();

    public List<TriggerQuestion> getTriggerQuestion() {
        return triggerQuestion;
    }

    public void setTriggerQuestion(List<TriggerQuestion> triggerQuestion) {
        this.triggerQuestion = triggerQuestion;
    }

}
