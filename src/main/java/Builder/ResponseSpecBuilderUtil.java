package Builder;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecBuilderUtil {

        public static ResponseSpecification successResponse() {

            return new ResponseSpecBuilder()
               .expectStatusCode(anyOf(is(200), is(201)))
                .log(LogDetail.ALL)
                .build();
    }
    
}
