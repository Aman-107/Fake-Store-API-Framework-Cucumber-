package Resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import POJO.AddNewCart;
import POJO.AddNewCart_Products;
import POJO.CreateLoginReq_Address;
import POJO.CreateLoginReq_Address_Geolocation;
import POJO.CreateLoginReq_Name;
import POJO.CreateloginReq;
import POJO.GetAllCarts;
import POJO.GetAllCarts_Products;

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
	
	private static HashMap<String,Object> newProductpayload = new HashMap<String,Object>();
	public HashMap<String, Object> addNewProduct(String title, Double price, String description, String image, String category) {

		newProductpayload.put("title", title);
		newProductpayload.put("price", price);
		newProductpayload.put("description", description);
		newProductpayload.put("image", image);
		newProductpayload.put("category", category);
		
		return newProductpayload;
		
	}

	public HashMap<String, Object> updateProduct(String description,String image) {
		
		newProductpayload.put("description", description);
		newProductpayload.put("image", image);
		
		return newProductpayload;
	}

	
	
	private AddNewCart addNewCart = new AddNewCart();
    public List<AddNewCart_Products> productsList = new ArrayList<>();

    public void addNewCart(int userId, String date) {
        addNewCart.setUserId(userId);
        addNewCart.setDate(date);
        addNewCart.setProducts(productsList);
    }

    public void addNewCart_Products(int productId, int quantity) {
        AddNewCart_Products addNewCart_Products = new AddNewCart_Products();
        addNewCart_Products.setProductId(productId);
        addNewCart_Products.setQuantity(quantity);
        
        productsList.add(addNewCart_Products);  // ✅ Corrected this part
    }

    public AddNewCart build() {
        return addNewCart;  // ✅ Returns the final payload
    }
}
