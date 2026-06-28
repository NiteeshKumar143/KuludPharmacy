package Apis;
import static io.restassured.RestAssured.given;
import Auth.TokenManager;
import Builder.RequestSpecBuilderUtil;
import EndPoints.Routs;
import Utils.HeaderBuilder;
import io.restassured.response.Response;

public class SpecialOfferApi {


public static Response GetSpecialOffersList() 
   {
          return given()
                //.log().all() 
                .spec(RequestSpecBuilderUtil.getRequestSpec())
                .headers(HeaderBuilder.commonHeaders())
                .header("Authorization", "Bearer " + TokenManager.getToken())
                .queryParam("page",1)
                .queryParam("limit", 10)
                .when()
                .get(Routs.apiendpoints.getSpecialOffers);
               
    }
    
}
