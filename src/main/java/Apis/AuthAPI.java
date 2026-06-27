package Apis;

import Builder.RequestSpecBuilderUtil;
import EndPoints.Routs;
import Payloads.SendOtpRequest;
import Payloads.VerifyOtpRequest;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthAPI {

     public static Response sendOtp(SendOtpRequest request) 
     {

        return given()
                //.log().all()
                .spec(RequestSpecBuilderUtil.getRequestSpec())
                .body(request)
                .when() 
                .post(Routs.apiendpoints.sendOtp);
     }

    public static Response verifyOtp(VerifyOtpRequest request) 
    {

        return given()
                .spec(RequestSpecBuilderUtil.getRequestSpec())
                .body(request) 
                .when()
                .post(Routs.apiendpoints.verifyOTP);
                
    }
}
