package models.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"email", "password"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Credentials {
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;
}
