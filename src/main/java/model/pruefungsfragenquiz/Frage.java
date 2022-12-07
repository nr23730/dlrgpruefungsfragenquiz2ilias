package model.pruefungsfragenquiz;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "frage",
        "antworten",
        "anzAw",
        "anzAwKorrekt",
        "kapitel",
        "kapitelBez",
        "code",
        "status",
        "order",
        "answer"
})
@Generated("jsonschema2pojo")
public class Frage {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("frage")
    private String frage;
    @JsonProperty("antworten")
    private List<String> antworten = null;
    @JsonProperty("anzAw")
    private Integer anzAw;
    @JsonProperty("anzAwKorrekt")
    private Integer anzAwKorrekt;
    @JsonProperty("kapitel")
    private String kapitel;
    @JsonProperty("kapitelBez")
    private String kapitelBez;
    @JsonProperty("code")
    private String code;
    @JsonProperty("status")
    private Integer status;
    @JsonProperty("order")
    private List<Integer> order = null;
    @JsonProperty("answer")
    private Integer answer;

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("frage")
    public String getFrage() {
        return frage;
    }

    @JsonProperty("frage")
    public void setFrage(String frage) {
        this.frage = frage;
    }

    @JsonProperty("antworten")
    public List<String> getAntworten() {
        return antworten;
    }

    @JsonProperty("antworten")
    public void setAntworten(List<String> antworten) {
        this.antworten = antworten;
    }

    @JsonProperty("anzAw")
    public Integer getAnzAw() {
        return anzAw;
    }

    @JsonProperty("anzAw")
    public void setAnzAw(Integer anzAw) {
        this.anzAw = anzAw;
    }

    @JsonProperty("anzAwKorrekt")
    public Integer getAnzAwKorrekt() {
        return anzAwKorrekt;
    }

    @JsonProperty("anzAwKorrekt")
    public void setAnzAwKorrekt(Integer anzAwKorrekt) {
        this.anzAwKorrekt = anzAwKorrekt;
    }

    @JsonProperty("kapitel")
    public String getKapitel() {
        return kapitel;
    }

    @JsonProperty("kapitel")
    public void setKapitel(String kapitel) {
        this.kapitel = kapitel;
    }

    @JsonProperty("kapitelBez")
    public String getKapitelBez() {
        return kapitelBez;
    }

    @JsonProperty("kapitelBez")
    public void setKapitelBez(String kapitelBez) {
        this.kapitelBez = kapitelBez;
    }

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("status")
    public Integer getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Integer status) {
        this.status = status;
    }

    @JsonProperty("order")
    public List<Integer> getOrder() {
        return order;
    }

    @JsonProperty("order")
    public void setOrder(List<Integer> order) {
        this.order = order;
    }

    @JsonProperty("answer")
    public Integer getAnswer() {
        return answer;
    }

    @JsonProperty("answer")
    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

}