package model.ilias;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Manifest {

    @JacksonXmlProperty(isAttribute = true, localName = "MainEntity")
    private String mainEntity = "qpl";
    @JacksonXmlProperty(isAttribute = true, localName = "Title")
    private String title;
    @JacksonXmlProperty(isAttribute = true, localName = "TargetRelease")
    private String targetRelease = "7.14.0";
    @JacksonXmlProperty(isAttribute = true, localName = "InstallationId")
    private String installationId;
    @JacksonXmlProperty(isAttribute = true, localName = "InstallationUrl")
    private String installationUrl;
    @JacksonXmlProperty(localName = "ExportFile")
    private ExportFile exportFile = new ExportFile();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ExportFile getExportFile() {
        return exportFile;
    }

    public void setInstallationId(String installationId) {
        this.installationId = installationId;
    }

    public void setInstallationUrl(String installationUrl) {
        this.installationUrl = installationUrl;
    }

    public void setExportFile(ExportFile exportFile) {
        this.exportFile = exportFile;
    }

}
