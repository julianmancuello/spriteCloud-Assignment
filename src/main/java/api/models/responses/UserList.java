package api.models.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"page", "userPerPage", "total", "totalPages", "data"})
public class UserList {
    @JsonProperty("page")
    private int page;
    @JsonProperty("per_page")
    private int userPerPage;
    @JsonProperty("total")
    private int total;
    @JsonProperty("total_pages")
    private int totalPages;
    @JsonProperty("data")
    private List<UserData> data;
    @JsonProperty("support")
    private Support support;
}
