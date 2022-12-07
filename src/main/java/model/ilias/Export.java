package model.ilias;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "exp:Export")
public class Export {

    @JacksonXmlProperty(isAttribute = true, localName = "InstallationId")
    private String installationId;
    @JacksonXmlProperty(isAttribute = true, localName = "InstallationUrl")
    private String installationUrl;
    @JacksonXmlProperty(isAttribute = true, localName = "Entity")
    private String entity = "qpl";
    @JacksonXmlProperty(isAttribute = true, localName = "SchemaVersion")
    private String schemaVersion = "4.1.0";
    @JacksonXmlProperty(isAttribute = true, localName = "TargetRelease")
    private String targetRelease = "7.14.0";
    @JacksonXmlProperty(isAttribute = true, localName = "xmlns:xsi")
    private String xsi = "http://www.w3.org/2001/XMLSchema-instance";
    @JacksonXmlProperty(isAttribute = true, localName = "xmlns:exp")
    private String exp = "http://www.ilias.de/Services/Export/exp/4_1";
    @JacksonXmlProperty(isAttribute = true, localName = "xsi:schemaLocation")
    private String schemaLocation = "http://www.ilias.de/Services/Export/exp/4_1 https://lernen.dlrg.net/xml/ilias_export_4_1.xsd http://www.ilias.de/Modules/TestQuestionPool/htlm/4_1 https://lernen.dlrg.net/xml/ilias_qpl_4_1.xsd";
    @JacksonXmlProperty(localName = "exp:ExportItem")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<ExportItem> exportItems = new ArrayList<>();

    // @JacksonXmlProperty(localName = "exp:ExportItem")
    // List<String> exportItems = new ArrayList<>();

    public void setInstallationId(String installationId) {
        this.installationId = installationId;
    }

    public void setInstallationUrl(String installationUrl) {
        this.installationUrl = installationUrl;
    }

    public List<ExportItem> getExportItems() {
        return exportItems;
    }

    public void setExportItems(List<ExportItem> exportItems) {
        this.exportItems = exportItems;
    }

}
