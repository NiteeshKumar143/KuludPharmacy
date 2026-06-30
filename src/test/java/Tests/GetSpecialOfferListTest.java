package Tests;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.Map;

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

    @Test(priority = 12)
    public void validateItemsResponse() {
    
    Response response = SpecialOfferApi.GetSpecialOffersList();

    // Status code validation
    response.then().statusCode(200);

    // Message validation
    response.then().body("message", equalTo("en, en.DEFAULT"));

    // Items array should not be empty
    response.then().body("data.items.size()", greaterThan(0));

    // Meta validations
    response.then().body("data.meta.totalItems", equalTo(124));
    response.then().body("data.meta.itemCount", equalTo(10));
    response.then().body("data.meta.itemsPerPage", equalTo(10));
    response.then().body("data.meta.totalPages", equalTo(13));
    response.then().body("data.meta.currentPage", equalTo(1));
    assertThat(response.jsonPath().getList("data.items"), not(empty()));
    assertThat(response.statusCode(), equalTo(200));
    System.out.println("Test Pass-: Meta data validated successfully");
}



@Test(priority = 13)
public void validateFirstItemDetails() {

     Response response = SpecialOfferApi.GetSpecialOffersList();

    response.then()
            .body("data.items[0].id", equalTo("58"))
            .body("data.items[0].nameEn", equalTo("Talya Hair Care Hair Oil"))
            .body("data.items[0].price", equalTo("10.00"))
            .body("data.items[0].discount", equalTo("50.00"))
            .body("data.items[0].priceAfterDiscount", equalTo("5.00"))
            .body("data.items[0].brandNameEn", equalTo("Dr. Browns"))
            .body("data.items[0].inCart", equalTo(true))
            .body("data.items[0].cartQuantity", equalTo(1));

    System.out.println("Test Pass-: First item details validated successfully");
}

@Test(priority = 14)
public void validateMandatoryFieldsForAllItems() {

     Response response = SpecialOfferApi.GetSpecialOffersList();

    List<Map<String, Object>> items = response.jsonPath().getList("data.items");

    for (Map<String, Object> item : items) {
        Assert.assertNotNull(item.get("id"));
        Assert.assertNotNull(item.get("nameEn"));
        Assert.assertNotNull(item.get("price"));
        Assert.assertNotNull(item.get("priceAfterDiscount"));
        Assert.assertNotNull(item.get("brandNameEn"));
        Assert.assertNotNull(item.get("itemId"));
        System.out.println("Test Pass-: Mandatory fields validated for item with ID: " + item.get("id"));
    }
}
    
}
