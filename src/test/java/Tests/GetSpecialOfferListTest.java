package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import Apis.SpecialOfferApi;
import io.restassured.response.Response;

public class GetSpecialOfferListTest {

    @Test(priority = 11)
    public void getSpecialOfferList() 
    { 
                Response response = SpecialOfferApi.GetSpecialOffersList();
                int statuscode=response.getStatusCode();
        
                Assert.assertEquals(statuscode,200);
                System.out.println("Test Pass-: Special Offers List fetched successfully");
                //response.prettyPrint();
    }
    
}
