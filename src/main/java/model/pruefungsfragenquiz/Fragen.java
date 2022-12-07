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
public class Fragen {

    @JsonIgnore
    private Map<String, Frage> fragen = new LinkedHashMap<>();

    @JsonAnyGetter
    public Frage getFrage(String key) {
        return fragen.get(key);
    }

    @JsonAnySetter
    public void setFrage(String key, Frage frage) {
        fragen.put(key, frage);
    }

    public Map<String, Frage> getFragen() {
        return fragen;
    }

}
