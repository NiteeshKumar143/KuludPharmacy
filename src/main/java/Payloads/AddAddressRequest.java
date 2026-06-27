package Payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddAddressRequest 
{
  private String name;
  private String houseOrBuilding;
  private String apartmentOrCompany;
  private String floor;
  private String street;
  private String direction;
  private String type;
  @JsonProperty("isDefault")
  private boolean isDefault;

    private double latitude;   
    private double longitude; 


    private String googleStreet;
    private String zoneId;
    private String zoneName;
    private String branchId;
    private String branchName;
    private String country;
    private String city;




   public String getGoogleStreet() {
        return googleStreet;
    }

    public void setGoogleStreet(String googleStreet) {
        this.googleStreet = googleStreet;
    }

    public String getZoneId() {
        return zoneId;
    }

    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

   public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    // Constructors
    public AddAddressRequest() 
    {

    }

    public AddAddressRequest(String name, String houseOrBuilding,String apartmentOrCompany,
                             String floor, String street,String direction,String type,boolean isDefault,double latitude,double longitude,String googleStreet,
    String zoneId,
    String zoneName,
    String branchId,
    String branchName,
    String country,
    String city) 
    {
        this.name = name;
        this.houseOrBuilding = houseOrBuilding;

    }

    public String getName() {
    return name;
}

  public void setName(String name) {
    this.name = name;
  }

  public String getHouseOrBuilding() {
    return houseOrBuilding;
  }

  public void setHouseOrBuilding(String houseOrBuilding) {
    this.houseOrBuilding = houseOrBuilding;
  }

  public String getApartmentOrCompany() {
    return apartmentOrCompany;
  }

  public void setApartmentOrCompany(String apartmentOrCompany) {
    this.apartmentOrCompany = apartmentOrCompany;
  }

  public String getFloor() {
    return floor;
  }

  public void setFloor(String floor) {
    this.floor = floor;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getDirection() {
    return direction;
  }

  public void setDirection(String direction) {
    this.direction = direction;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public boolean isDefault() {
    return isDefault;
  }

  public void setDefault(boolean isDefault) {
    this.isDefault = isDefault;
  }

 


    

   

    
}
