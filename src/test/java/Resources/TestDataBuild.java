package Resources;

import java.util.HashMap;

import POJO.CreateLoginReq_Address;
import POJO.CreateLoginReq_Address_Geolocation;
import POJO.CreateLoginReq_Name;
import POJO.CreateloginReq;

public class TestDataBuild {

	public CreateloginReq createLogin() {
		CreateloginReq createLogin =new CreateloginReq();
		createLogin.setEmail("John@gmail.com");
		createLogin.setUsername("johnd");
		createLogin.setPassword("m38rmF$");
		createLogin.setPhone("1-570-236-7033");
		
		CreateLoginReq_Name name = new CreateLoginReq_Name();
		name.setFirstname("John");
		name.setLastname("Doe");
		createLogin.setName(name);
		
		CreateLoginReq_Address address = new CreateLoginReq_Address();
		address.setCity("kilcoole");
		address.setNumber(3);
		address.setStreet("7835 new road");
		address.setZipcode("12926-3874");
		
		CreateLoginReq_Address_Geolocation location = new CreateLoginReq_Address_Geolocation();
		location.setLat("-37.3159");
		location.setLng("81.1496");
		address.setGeolocation(location);
		createLogin.setAddress(address);
		
		return createLogin;
	}
	
	public String login(String username, String password) {
		
		return ("{\r\n"
				+ "                \"username\": \""+username+"\",\r\n"
				+ "                \"password\": \""+password+"\"\r\n"
				+ "}");
	}

	public HashMap<String, Object> productsBody(String title, String category,String description, String image) {
		
		HashMap<String,Object> payload = new HashMap<String,Object>();
		
		if(title != null) {
		payload.put("title", title);
		} else payload.put("title", "test product");
		
		payload.put("price", 20.5);
		
		if(description != null) {
			payload.put("description", description);
			} else payload.put("description", "lorem ipsum set");
		
		if(image != null) {
			payload.put("image", image);
			} else payload.put("image", "https://i.pravatar.cc");
		
		if(category != null) {
			payload.put("category", category);
			} else payload.put("category", "electronic");
	
		return payload;
		
	}
}
