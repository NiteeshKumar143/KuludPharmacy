package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Apis.UserAddressApi;
import Base.BaseTest;
import io.restassured.response.Response;

public class GetUserAddressTest extends BaseTest
{

    @Test(enabled = true)
    public void getUserAddressList() 
    { 
                Response response = UserAddressApi.GetUserAssressApi();
                int statuscode=response.getStatusCode();
        

                Assert.assertEquals(statuscode,200);
                System.out.println("Test Pass-: User Address List fetched successfully");
               //response.prettyPrint();
    }
    
}
