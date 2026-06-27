package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import Apis.UserAddressApi;
import Base.BaseTest;
import io.restassured.response.Response;

public class DeleteUserAddressTest extends BaseTest
{

    @Test(priority = 7)
    public void DeleteUserAddressById()
    { 

                 String id = UserAddressApi.GetUserAssressApi()
                .jsonPath()
                .getString("data.addresses[4].id");

                System.out.println("Id " +id);
                System.out.println("Test Pass-: Address " +id+ " deleted sucessfully");

                Response response = UserAddressApi.DeleteUserAssressApi(id);
                
                int statuscode=response.getStatusCode();
                
                Assert.assertEquals(statuscode,200);

                //Response response1= UserAddressApi.GetUserAssressApi();
                //response.prettyPrint();
               // response1.prettyPrint();

    }
    
}
