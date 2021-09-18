package ru.ibs.homework.entity;

import com.fasterxml.jackson.annotation.*;
import javax.annotation.processing.Generated;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "address",
        "phoneNumber",
        "inn",
        "founded",
        "securities"
})
@Generated("jsonschema2pojo")
public class Company {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("address")
    private String address;

    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @JsonProperty("inn")
    private String inn;

    @JsonProperty("founded")
    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date founded;

    @JsonProperty("securities")
    private List<Security> securitiesList;

    @JsonIgnore
    private Map<String, Object> additionalPropertiesMap = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @JsonProperty("phoneNumber")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @JsonProperty("inn")
    public String getInn() {
        return inn;
    }

    @JsonProperty("inn")
    public void setInn(String inn) {
        this.inn = inn;
    }

    @JsonProperty("founded")
    public Date getFounded() {
        return founded;
    }

    @JsonProperty("founded")
    public void setFounded(Date founded) {
        this.founded = founded;
    }

    @JsonProperty("securities")
    public List<Security> getSecuritiesList() {
        return securitiesList;
    }

    @JsonProperty("securities")
    public void setSecuritiesList(List<Security> securitiesList) {
        this.securitiesList = securitiesList;
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
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", inn='" + inn + '\'' +
                ", founded=" + founded +
                ", securitiesList=" + securitiesList +
                ", additionalPropertiesMap=" + additionalPropertiesMap +
                '}';
    }
}
