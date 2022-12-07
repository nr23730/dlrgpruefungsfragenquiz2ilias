
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
public class AssetIds {

    @JsonIgnore
    private Map<String, AssetId> assetIds = new LinkedHashMap<>();

    @JsonAnyGetter
    public AssetId getAssetId(String key) {
        return assetIds.get(key);
    }

    @JsonAnySetter
    public void setAssetId(String key, AssetId assetId) {
        assetIds.put(key, assetId);
    }

    public Map<String, AssetId> getAssetIds() {
        return assetIds;
    }

}
