
package pojos.employee;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "age",
    "designation",
    "directReports"
})
public class DirectReport {

    @JsonProperty("name")
    public String name;
    @JsonProperty("age")
    public Integer age;
    @JsonProperty("designation")
    public String designation;
    @JsonProperty("directReports")
    public List<DirectReport__1> directReports;

}
