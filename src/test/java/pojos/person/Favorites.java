
package pojos.person;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class Favorites {

    @JsonProperty("color")
    public String color;
    @JsonProperty("food")
    public String food;
    @JsonProperty("movies")
    public List<Movie> movies;

}
