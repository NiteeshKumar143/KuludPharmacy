package Utils;

import Apis.AuthAPI;
import Auth.TokenManager;
import Payloads.SendOtpRequest;
import Payloads.VerifyOtpRequest;
import io.restassured.response.Response;

public class AuthUtil  
{
    public static String login(String phone, String countryCode, String otp) 
   {

        // Step 1: Send OTP

        SendOtpRequest sendRequest = new SendOtpRequest(phone, countryCode);
        AuthAPI.sendOtp(sendRequest);

        // Step 2: Verify OTP

        VerifyOtpRequest verifyRequest = new VerifyOtpRequest(phone, countryCode, otp);
        Response response = AuthAPI.verifyOtp(verifyRequest);

        // Step 3: Extract Token

        String token = response.jsonPath().getString("data.accessToken");
        
        if (token == null || token.isEmpty()) 
        {
            throw new RuntimeException("❌ Token is null. Login failed!");
        }

        System.out.println("✅ TOKEN: " + token);

        // Step 4: Store Token
        TokenManager.setToken(token, 3600);
        return token;   
        
     
    }
    
}
