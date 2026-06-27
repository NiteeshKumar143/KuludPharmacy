package Base;


import org.testng.annotations.BeforeClass;

import Auth.TokenManager;
import Config.ConfigManager;


import Utils.AuthUtil;
import io.restassured.RestAssured;


public class BaseTest 
{


    @BeforeClass
    public static String setup() 
    {
        RestAssured.baseURI = ConfigManager.getBaseUrl();
        //Auto login before tests
           if (TokenManager.getToken() == null || TokenManager.isTokenExpired()) 
            {

            System.out.println("🔄 Token expired. Regenerating...");
            String token = AuthUtil.login("70808080", "+974", "123456");

            TokenManager.setToken(token, 3600);

            return token;
            }
            
             return TokenManager.getToken();

       
    }


   
   

 

}
    
