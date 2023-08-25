
package pojos.person;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "title",
    "year"
})
public class Movie {

    @JsonProperty("title")  // this is the name that will be used as a key when json is generated
    public String title;
    @JsonProperty("year")
    public Integer year;

}
