package Utils;

import java.util.HashMap;
import java.util.Map;


public class HeaderBuilder 
{
    public static Map<String,String> commonHeaders() 
    {

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");
        //headers.put("Authorization", "Basic YXBxeDphcHF4QDEyMw==");

        headers.put("deviceId", "1");
        headers.put("deviceType", "Android");
        headers.put("timezone", "in");
        headers.put("language", "en");
        return headers; 

    }
}
