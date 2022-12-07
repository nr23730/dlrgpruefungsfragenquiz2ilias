package model.ilias.qpl;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class PageContent {

    @JacksonXmlProperty(localName = "Question")
    private Question question;

    PageContent(Question question) {
        this.question = question;
    }

    public Question getQuestion() {
        return question;
    }

}
