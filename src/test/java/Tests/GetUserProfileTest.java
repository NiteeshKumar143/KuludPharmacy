package Tests;

import Base.BaseTest;
import io.restassured.response.Response;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.testng.Assert;
import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;

import Apis.UserApi;


public class GetUserProfileTest extends BaseTest 
{

    @Test(priority = 1)
    public void getUserProfileVerifySuccessfulResponse() 
    {

 
                Response response = UserApi.getUserProfile();
                
                int statuscode=response.getStatusCode();
                Assert.assertEquals(statuscode,200);
                
                System.out.println("Test Pass-: Get Success response with valid Headers");
    }
    @Test(priority = 2)
    public void getUserProfileValidateResponseSchema() 
    {

 
              Response response = UserApi.getUserProfile();

              
              response.then()
              .statusCode(200)
              .body(matchesJsonSchemaInClasspath("Schema/profileSchema.json"));
              System.out.println("Test Pass-: Response schema is Correct");

                
    }

@Test(priority = 3)
    public void getUserProfileValidateEmailFormat() 
    {
        Response response = UserApi.getUserProfile();
    // Extract email
       String email = response.jsonPath().getString("data.email");

   // Assertions
        assertThat(email,notNullValue());
        //Assert.assertEquals(email,notNullValue());
        assertThat(email, containsString("@"));
        assertThat(email, matchesPattern("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"));
        System.out.println("Test Pass-: Email having Correct Format");
}


@Test(priority = 4)
    public void getUserProfileValidatePhoneNumberFormat() 
    {
        Response response = UserApi.getUserProfile();
       // SoftAssert soft = new SoftAssert();

    // Extract email
        String phone = response.jsonPath().getString("data.phone");
        String countryCode = response.jsonPath().getString("data.countryCode");
        String fullPhone = response.jsonPath().getString("data.fullPhone");

   // Assertions

     //soft assertion
    // soft.assertEquals(response.getStatusCode(), 200);
       
     // 1. fullPhone = countryCode + phone
        assertThat(phone,notNullValue());
        assertThat(fullPhone, equalTo(countryCode + phone));

        // 2. countryCode starts with +
        assertThat(countryCode,notNullValue());
        assertThat(countryCode, startsWith("+"));

        // 3. phone contains only digits
        assertThat(fullPhone,notNullValue());
        assertThat(phone, matchesPattern("\\d+"));

        System.out.println("Test Pass-: Phone Number is in Correct format and having valid country Code");

        
}

@Test(priority = 5)
public void getUserProfileValidateEnumValues() 
{

        Response response = UserApi.getUserProfile();
        response.then()
       // .header("deviceType", "Android")
        .log().ifError();
        
        

        // Extract values
        String status = response.jsonPath().getString("data.status");
        String userType = response.jsonPath().getString("data.userType");
        String gender = response.jsonPath().getString("data.gender");

        // Assertions
        assertThat(status, anyOf(is("ACTIVE"), is("INACTIVE")));
        assertThat(userType, anyOf(is("USER"), is("ADMIN")));
        assertThat(gender, anyOf(is("MALE"), is("FEMALE"), is("OTHER")));

        System.out.println("Test Pass-: Enum fields having correct values");

        }

}