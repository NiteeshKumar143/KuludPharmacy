package Tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import Apis.CategoriesApi;
import Apis.SubCategoriesApi;
import Base.BaseTest;
import io.restassured.response.Response;

public class GetSubCategoriesListTest extends BaseTest
{


    @Test(priority = 10)
    public void GetSubCategoriesList()
    { 

                 String categoryId = CategoriesApi.GetCategoriesList()
                .jsonPath()
                .getString("data[1].id");

                String categoryName = CategoriesApi.GetCategoriesList()
                .jsonPath()
                .getString("data[1].nameEn");

                System.out.println("Category Name-:  " +categoryName);
                System.out.println("List of Sub categories belongs to-:  " +categoryName);
                Response response = SubCategoriesApi.getSubCategoriesList(categoryId);
                
                int statuscode=response.getStatusCode();
                
                Assert.assertEquals(statuscode,200);
                System.out.println("Test Pass-: Sub Categories List fetched successfully");
                //response.prettyPrint();
                

    }
    
}
