package Apis;

import static io.restassured.RestAssured.given;

import Auth.TokenManager;
import Builder.RequestSpecBuilderUtil;
import EndPoints.Routs;
import Payloads.AddAddressRequest;
import Utils.HeaderBuilder;
import io.restassured.response.Response;

public class UserAddressApi 
{
    public static Response AddUserAssressApi(AddAddressRequest  request) 
    {
    return given()
                //.log().all() 
                .spec(RequestSpecBuilderUtil.getRequestSpec())
                .headers(HeaderBuilder.commonHeaders())
                .header("Authorization", "Bearer " + TokenManager.getToken())
                .body(request)
                .when()
                .post(Routs.apiendpoints.postAddUserAddress);
               
     }


   public static Response GetUserAssressApi() 
   {
          return given()
                //.log().all() 
                .spec(RequestSpecBuilderUtil.getRequestSpec())
                .headers(HeaderBuilder.commonHeaders())
                .header("Authorization", "Bearer " + TokenManager.getToken())
                .queryParam("page",1)
                .queryParam("limit", 10)
                .when()
                .get(Routs.apiendpoints.getUserAddress);
               
    }



    public static Response DeleteUserAssressApi(String id) 
     {
          return given()
                //.log().all() 
                .spec(RequestSpecBuilderUtil.getRequestSpec())
                .headers(HeaderBuilder.commonHeaders())
                .header("Authorization", "Bearer " + TokenManager.getToken())
                .pathParam("id",id)
             
                .when()
                .delete(Routs.apiendpoints.deleteUserAddressById+"/{id}");
               
     } 

    
}
