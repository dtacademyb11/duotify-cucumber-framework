
package pojos.employee;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "age",
    "designation",
    "directReports"
})

public class Employee {

    @JsonProperty("name")
    public String name;
    @JsonProperty("age")
    public Integer age;
    @JsonProperty("designation")
    public String designation;
    @JsonProperty("directReports")
    public List<DirectReport> directReports;

    // for additional key value pairs
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


}
