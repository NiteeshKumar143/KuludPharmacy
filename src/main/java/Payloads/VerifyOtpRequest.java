package Payloads;


public class VerifyOtpRequest {

    private String phone;
    private String countryCode;
    private String otp;

    // Constructors
    public VerifyOtpRequest() {}

    public VerifyOtpRequest(String phone, String countryCode, String otp) 
    {
        this.phone = phone;
        this.countryCode = countryCode;
        this.otp = otp;
    }

    // Getters & Setters
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}
