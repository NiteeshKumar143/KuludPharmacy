package Builder;

import Config.ConfigManager;
import Utils.HeaderBuilder;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecBuilderUtil {
    public static RequestSpecification getRequestSpec() 
    {
        
        return new RequestSpecBuilder()
                .setBaseUri(ConfigManager.getBaseUrl())
                .setContentType(ContentType.JSON)
                .addHeaders(HeaderBuilder.commonHeaders())
                .build();
    }
}
