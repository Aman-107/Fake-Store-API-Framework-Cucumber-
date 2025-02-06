package POJO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateLoginReq_Address_Geolocation {
	
	private String lat;
	@JsonProperty("long") // Maps JSON's "long" to Java's "lng"
	private String lng;
	
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	
}
