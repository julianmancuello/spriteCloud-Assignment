package api.services;

import api.endpoints.Endpoints;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import lombok.Data;

@Data
public class BaseApi {

    private RequestSpecification requestSpec;

    public BaseApi() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(Endpoints.BASE_URI)
                .setContentType("application/json")
                .build();
    }
}
