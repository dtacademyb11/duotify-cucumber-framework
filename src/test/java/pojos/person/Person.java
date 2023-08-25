
package pojos.person;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "age",
        "address",
        "contacts",
        "favorites"
})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {


    public String name;

    public Integer age;

    public Address address;

    public Contacts contacts;

    public Favorites favorites;

}
