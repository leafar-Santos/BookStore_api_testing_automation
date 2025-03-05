package core;

import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import org.junit.jupiter.api.BeforeAll;
import static org.hamcrest.Matchers.lessThan;


public class BaseTeste implements ConstantsConfiguration {

    @BeforeAll
    public static void setupTeste()  {

        baseURI = System.getProperty("APP_BASE_URL", API_BASE_URL);
        //baseURI = API_BASE_URL;
        port = API_PORT;
        basePath = API_BASE_PATH;

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setContentType(API_CONTENT_TYPE);

        requestSpecification = requestSpecBuilder.build();

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectResponseTime(lessThan(MAX_TIMEOUT));
        responseSpecification = responseSpecBuilder.build();

        enableLoggingOfRequestAndResponseIfValidationFails();


    }


}
