package POJO;

public class CreateLoginReq_Address {
	
	private String city;
	private String street;
	private int number;
	private String zipcode;
	private CreateLoginReq_Address_Geolocation geolocation;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public CreateLoginReq_Address_Geolocation getGeolocation() {
		return geolocation;
	}
	public void setGeolocation(CreateLoginReq_Address_Geolocation geolocation) {
		this.geolocation = geolocation;
	}
}
