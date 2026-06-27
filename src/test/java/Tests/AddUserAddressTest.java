package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import Apis.UserAddressApi;
import Base.BaseTest;
import Payloads.AddAddressRequest;
import io.restassured.response.Response;

public class AddUserAddressTest extends BaseTest
{

    @Test(priority = 6)
    public void AddAddressTest() 
    {        
         
            AddAddressRequest request = new AddAddressRequest();
               request.setName("AppInventiv Noida 135");
               request.setHouseOrBuilding("Sector 135 B25");
               request.setApartmentOrCompany("Noida");
               request.setFloor("10");
               request.setStreet("201301");
               request.setDirection("Near metro");
               request.setType("HOUSE");
               request.setDefault(false);
              // request.setLatitude(25.276987);
              // request.setLongitude(55.296249);

               /*request.setGoogleStreet("street");
                request.setZoneId("zoneid");
                request.setZoneName("zonename");
                request.setBranchId("branchid");
                request.setBranchName("branchname");
                request.setCountry("country");
                request.setCity("city");*/

              Response response = UserAddressApi.AddUserAssressApi(request);
         
              int statuscode=response.getStatusCode();
              Assert.assertEquals(statuscode,201);
              System.out.println("Test Pass-: New Address added sucessfully");
             // response.prettyPrint();

    }
    
}
