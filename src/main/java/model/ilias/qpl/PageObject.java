package model.ilias.qpl;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class PageObject {

    @JacksonXmlProperty(localName = "PageContent")
    private PageContent pageContent;

    public PageObject(Question question) {
        pageContent = new PageContent(question);
    }

    public PageContent getPageContent() {
        return pageContent;
    }

}
