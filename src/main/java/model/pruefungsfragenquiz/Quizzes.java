
package model.pruefungsfragenquiz;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class Quizzes {

    @JsonIgnore
    private Map<String, Quiz> quizzes = new LinkedHashMap<>();

    @JsonAnyGetter
    public Quiz getQuiz(String key) {
        return quizzes.get(key);
    }

    @JsonAnySetter
    public void setQuiz(String key, Quiz quiz) {
        quizzes.put(key, quiz);
    }

    public Map<String, Quiz> getQuizzes() {
        return quizzes;
    }

}
