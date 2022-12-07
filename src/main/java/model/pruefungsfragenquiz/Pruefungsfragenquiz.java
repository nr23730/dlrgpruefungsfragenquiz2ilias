
package model.pruefungsfragenquiz;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "fragenIds",
        "fragenPointer",
        "fragen",
        "running",
        "quiz",
        "alle",
        "kapitel",
        "quizzes",
        "assetIds"
})
@Generated("jsonschema2pojo")
public class Pruefungsfragenquiz {

    @JsonProperty("fragenIds")
    private List<String> fragenIds = null;
    @JsonProperty("fragenPointer")
    private Integer fragenPointer;
    @JsonProperty("fragen")
    private Fragen fragen;
    @JsonProperty("running")
    private Boolean running;
    @JsonProperty("quiz")
    private Quiz quiz;
    @JsonProperty("alle")
    private Object alle;
    @JsonProperty("kapitel")
    private Object kapitel;
    @JsonProperty("quizzes")
    private Quizzes quizzes;
    @JsonIgnore
    private Map<String, Object> additional = new LinkedHashMap<>();

    @JsonAnyGetter
    public Object getAdditional(String key) {
        return additional.get(key);
    }

    @JsonAnySetter
    public void setAdditional(String key, Object frage) {
        additional.put(key, frage);
    }

    @JsonProperty("fragenIds")
    public List<String> getFragenIds() {
        return fragenIds;
    }

    @JsonProperty("fragenIds")
    public void setFragenIds(List<String> fragenIds) {
        this.fragenIds = fragenIds;
    }

    @JsonProperty("fragenPointer")
    public Integer getFragenPointer() {
        return fragenPointer;
    }

    @JsonProperty("fragenPointer")
    public void setFragenPointer(Integer fragenPointer) {
        this.fragenPointer = fragenPointer;
    }

    @JsonProperty("fragen")
    public Fragen getFragen() {
        return fragen;
    }

    @JsonProperty("fragen")
    public void setFragen(Fragen fragen) {
        this.fragen = fragen;
    }

    @JsonProperty("running")
    public Boolean getRunning() {
        return running;
    }

    @JsonProperty("running")
    public void setRunning(Boolean running) {
        this.running = running;
    }

    @JsonProperty("quiz")
    public Quiz getQuiz() {
        return quiz;
    }

    @JsonProperty("quiz")
    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    @JsonProperty("quizzes")
    public Quizzes getQuizzes() {
        return quizzes;
    }

    @JsonProperty("quizzes")
    public void setQuizzes(Quizzes quizzes) {
        this.quizzes = quizzes;
    }

}