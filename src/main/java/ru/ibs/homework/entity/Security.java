package ru.ibs.homework.entity;

import com.fasterxml.jackson.annotation.*;
import javax.annotation.processing.Generated;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "currency",
        "code",
        "date"
})
@Generated("jsonschema2pojo")
public class Security {

    @JsonProperty("name")
    private String name;

    @JsonProperty("currency")
    private List<String> currencyList;

    @JsonProperty("code")
    private String code;

    @JsonProperty("date")
    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date date;

    @JsonIgnore
    private Map<String, Object> additionalPropertiesMap = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("currency")
    public List<String> getCurrencyList() {
        return currencyList;
    }

    @JsonProperty("currency")
    public void setCurrencyList(List<String> currencyList) {
        this.currencyList = currencyList;
    }

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("date")
    public Date getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(Date date) {
        this.date = date;
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
        return "Security{" +
                "name='" + name + '\'' +
                ", currencyList=" + currencyList +
                ", code='" + code + '\'' +
                ", date=" + date +
                ", additionalPropertiesMap=" + additionalPropertiesMap +
                '}';
    }
}
