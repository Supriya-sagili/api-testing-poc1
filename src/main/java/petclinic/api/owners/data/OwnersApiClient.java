package petclinic.api.owners.data;

import api.common.ApiClient;
import api.common.ApiResponse;
import api.common.exception.InvalidResponseException;
import com.google.gson.GsonBuilder;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.http.Method;
import io.restassured.internal.mapping.GsonMapper;
import io.restassured.mapper.ObjectMapperType;

import java.util.List;

public class OwnersApiClient extends ApiClient {

    public OwnersApiClient(String baseUrl) {
        super(baseUrl, "/api/owners");

        ObjectMapperConfig config = new ObjectMapperConfig(ObjectMapperType.GSON)
                .gsonObjectMapperFactory((type, s) -> new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create());
        setObjectMapper(new GsonMapper(config.gsonObjectMapperFactory()));
    }

    public List<PetsItem> getPetItems() throws InvalidResponseException {
        ApiResponse<Response> response = caller.executeRequest(getRequest(), Method.GET, Response.class);
        return response.getContent().getPets();

    }

    /*public Response createService(Response service) throws InvalidResponseException {
        var request = getRequest().withBody(service).withHeader("Content-Type", "application/json");
        ApiResponse<Response> response = caller.executeRequest(request, Method.POST, Response.class);
        return response.getContent();
    }*/

    /*public List<Service> getServicesByQuery(String query) throws InvalidResponseException {
        String[] queryParams = query.split("=");
        var request = getRequest().withQueryParam(queryParams[0], queryParams[1]);
        ApiResponse<ServiceResponse> response = caller.executeRequest(getRequest(), Method.GET, ServiceResponse.class);
        return response.getContent().getServices();
    }*/
}

