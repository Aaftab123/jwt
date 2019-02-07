package com.example.demo.client.response;

import java.util.List;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.entities.Person;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"personList"
})
public class PersonList {

@JsonProperty("personList")
private List<Person> personList = null;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("personList")
public List<Person> getPersonList() {
return personList;
}

@JsonProperty("personList")
public void setPersonList(List<Person> personList) {
this.personList = personList;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

@Override
public String toString() {
	return null;
}

}
