package Apis;

import static io.restassured.RestAssured.given;

import Auth.TokenManager;
import Builder.RequestSpecBuilderUtil;
import EndPoints.Routs;
import Utils.HeaderBuilder;
import io.restassured.response.Response;

public class UserApi {

     public static Response getUserProfile() 
     {

        return given()
                .spec(RequestSpecBuilderUtil.getRequestSpec())
                .headers(HeaderBuilder.commonHeaders())
                .header("Authorization", "Bearer " + TokenManager.getToken())
                .when()
                .get(Routs.apiendpoints.getUserProfile);
                 //.then()
                //.log().all()
                //.extract()
               // .response();
               
    }
    
}
