
package model.pruefungsfragenquiz;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "bezeichnung",
        "code",
        "kurzBez",
        "anzFragen",
        "maxFehler",
        "maxAnzAwKorrekt",
        "pruefungsCodes"
})
@Generated("jsonschema2pojo")
public class Quiz {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("bezeichnung")
    private String bezeichnung;
    @JsonProperty("code")
    private String code;
    @JsonProperty("kurzBez")
    private String kurzBez;
    @JsonProperty("anzFragen")
    private Integer anzFragen;
    @JsonProperty("maxFehler")
    private Integer maxFehler;
    @JsonProperty("maxAnzAwKorrekt")
    private Integer maxAnzAwKorrekt;
    @JsonProperty("pruefungsCodes")
    private List<Object> pruefungsCodes = null;

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("bezeichnung")
    public String getBezeichnung() {
        return bezeichnung;
    }

    @JsonProperty("bezeichnung")
    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("kurzBez")
    public String getKurzBez() {
        return kurzBez;
    }

    @JsonProperty("kurzBez")
    public void setKurzBez(String kurzBez) {
        this.kurzBez = kurzBez;
    }

    @JsonProperty("anzFragen")
    public Integer getAnzFragen() {
        return anzFragen;
    }

    @JsonProperty("anzFragen")
    public void setAnzFragen(Integer anzFragen) {
        this.anzFragen = anzFragen;
    }

    @JsonProperty("maxFehler")
    public Integer getMaxFehler() {
        return maxFehler;
    }

    @JsonProperty("maxFehler")
    public void setMaxFehler(Integer maxFehler) {
        this.maxFehler = maxFehler;
    }

    @JsonProperty("maxAnzAwKorrekt")
    public Integer getMaxAnzAwKorrekt() {
        return maxAnzAwKorrekt;
    }

    @JsonProperty("maxAnzAwKorrekt")
    public void setMaxAnzAwKorrekt(Integer maxAnzAwKorrekt) {
        this.maxAnzAwKorrekt = maxAnzAwKorrekt;
    }

    @JsonProperty("pruefungsCodes")
    public List<Object> getPruefungsCodes() {
        return pruefungsCodes;
    }

    @JsonProperty("pruefungsCodes")
    public void setPruefungsCodes(List<Object> pruefungsCodes) {
        this.pruefungsCodes = pruefungsCodes;
    }

}
