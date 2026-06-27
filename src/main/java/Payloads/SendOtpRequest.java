package Payloads;


public class SendOtpRequest {

    private String phone;
    private String countryCode;

    // Constructors
    public SendOtpRequest() {}

    public SendOtpRequest(String phone, String countryCode) 
    {
        this.phone = phone;
        this.countryCode = countryCode;
    }

    // Getters & Setters
    public String getPhone() 
    {
        return phone;
    }

    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getCountryCode() 
    {
        return countryCode;
    }

    public void setCountryCode(String countryCode) 
    {
        this.countryCode = countryCode;
    }
}