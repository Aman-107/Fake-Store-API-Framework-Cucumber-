package Resources;

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
	
	public String Login(String username, String password) {
		
		return ("{\r\n"
				+ "                \"username\": \""+username+"\",\r\n"
				+ "                \"password\": \""+password+"\"\r\n"
				+ "}");
	}
}
