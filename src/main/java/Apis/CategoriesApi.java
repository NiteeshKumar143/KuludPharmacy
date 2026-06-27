package Apis;
import static io.restassured.RestAssured.given;
import Auth.TokenManager;
import Builder.RequestSpecBuilderUtil;
import EndPoints.Routs;
import Utils.HeaderBuilder;
import io.restassured.response.Response;

public class CategoriesApi 
{


public static Response GetCategoriesList() 
   {
          return given()
                //.log().all() 
                .spec(RequestSpecBuilderUtil.getRequestSpec())
                .headers(HeaderBuilder.commonHeaders())
                .header("Authorization", "Bearer " + TokenManager.getToken())
                .when()
                .get(Routs.apiendpoints.getCategoriesList);
               
    }
    
}
