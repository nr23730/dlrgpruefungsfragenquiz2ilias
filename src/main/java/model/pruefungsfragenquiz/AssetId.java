package model.pruefungsfragenquiz;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "frage"
})
@Generated("jsonschema2pojo")
public class AssetId {

    @JsonProperty("frage")
    private String frage;

    @JsonProperty("frage")
    public String getFrage() {
        return frage;
    }

    @JsonProperty("frage")
    public void setFrage(String frage) {
        this.frage = frage;
    }

}