package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Apis.CategoriesApi;
import Base.BaseTest;
import io.restassured.response.Response;

public class GetCategoriesListTest extends BaseTest 
{
    @Test(enabled = false)
    public void getCategoriesList() 
    { 
                Response response = CategoriesApi.GetCategoriesList();
                int statuscode=response.getStatusCode();
        
                Assert.assertEquals(statuscode,200);
                response.prettyPrint();
    }
    
}
