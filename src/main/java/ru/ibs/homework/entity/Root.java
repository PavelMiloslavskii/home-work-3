package ru.ibs.homework.entity;

import com.fasterxml.jackson.annotation.*;
import javax.annotation.processing.Generated;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "companies"
})
@Generated("jsonschema2pojo")
public class Root {

    @JsonProperty("companies")
    private List<Company> companiesList;

    @JsonIgnore
    private Map<String, Object> additionalPropertiesMap = new HashMap<String, Object>();

    @JsonProperty("companies")
    public List<Company> getCompaniesList() {
        return companiesList;
    }

    @JsonProperty("companies")
    public void setCompaniesList(List<Company> companiesList) {
        this.companiesList = companiesList;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalPropertiesMap() {
        return this.additionalPropertiesMap;
    }

    @JsonAnySetter
    public void setAdditionalPropertiesMap(String name, Object value) {
        this.additionalPropertiesMap.put(name, value);
    }

    @Override
    public String toString() {
        return "Root{" +
                "companiesList=" + companiesList +
                ", additionalPropertiesMap=" + additionalPropertiesMap +
                '}';
    }
}
