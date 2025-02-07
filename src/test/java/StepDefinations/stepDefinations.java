package StepDefinations;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

import POJO.GetAllProducts;
import Resources.ResourceAPI;
import Resources.TestDataBuild;
import Resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class stepDefinations extends Utils {

	RequestSpecification reqspec;
	TestDataBuild testDataBuild = new TestDataBuild();
	Response response;
	static String productId;
	
	@Given("Add User Payload with {string} and {string}")
	public void add_user_payload_with_and(String username, String password) throws IOException {
		reqspec = given().spec(requestSpecification())
				.body(testDataBuild.login(username, password));
	}
	
	@When("user calls {string} API with {string} https request")
	public void user_calls_api_with_https_request(String resource, String method) {
		
		ResourceAPI resourceAPI = ResourceAPI.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		
		if(method.equalsIgnoreCase("POST"))
		response = reqspec.when().post(resourceAPI.getResource());      // Capturing response	
		
		else if(method.equalsIgnoreCase("GET"))
			response = reqspec.when().get(resourceAPI.getResource());
		
		else if(method.equalsIgnoreCase("PUT"))
			response = reqspec.when().put(resourceAPI.getResource());
		
		else if(method.equalsIgnoreCase("DELETE"))
			response = reqspec.when().delete(resourceAPI.getResource());
	
	}
	
	@Then("the API got success with status code {int}")
	public void the_api_got_success_with_status_code(Integer expectedStatusCode) {
		response.then()
		  .statusCode(expectedStatusCode);  // Validate Status Code
		//  .time(lessThan(2000L));         // validation reponse time
		
		System.out.println("response time " + response.getTime() + " ms"); // printing response Time
		}
	
	@Then("{string} in response header is {string}")
	public void in_response_header_is(String server, String value) {
	   
		Assert.assertEquals(response.header(server), value);
	}

	@Given("Get All Products list and print there title.")
	public void get_all_products_list_and_print_there_title() throws IOException {
		
		List<GetAllProducts> products = Arrays.asList(
		 given().spec(requestSpecification())
		.when().get("products").as(GetAllProducts[].class));
		
		 // Extract and print titles
	    for (GetAllProducts product : products) {
	        System.out.println(product.getTitle());
	    }
		
	    reqspec = given().spec(requestSpecification());
	    
	}
	
	@Given("Get a single product by passing the id.")
	public void get_a_single_product_by_passing_the_id() throws IOException {
		reqspec = given().spec(requestSpecification());
	}
	
	@When("user calls {string} API with id as {string} via {string} https request")
	public void user_calls_api_with_id_as_via_https_request(String resource, String id,String method) {
		
		productId = id;
		resourceApiwithPath(resource,method,id);
	}
	
	@Then("verify {string} in response body should be {int}")
	public void verify_in_response_body_should_be(String value, Integer int1) {
		
		int id = getJsonPathInt(response,value);
		Assert.assertEquals(int1.intValue(), id);
	}
	
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String expectedValue) {
	    
		String actualValue = getJsonPath(response,key);
		Assert.assertEquals(expectedValue,actualValue);
	}

	@Given("Add New Product Payload with {string}, {double},{string}, {string} and {string}")
	public void add_new_product_payload_with_and(String title, Double price, String description, String image, String category) throws IOException {
		
		reqspec = given().spec(requestSpecification())
				.body(testDataBuild.addNewProduct(title, price, description, image, category));
	}

	@Then("extract {string} in response body")
	public void extract_in_response_body(String id) {
		String newProductId = Integer.toString(getJsonPathInt(response,id));
		System.out.println(newProductId);
		System.out.println(productId);
		productId = newProductId;
		System.out.println(productId);
	}

	@Given("Update Product Payload with {string} and {string}")
	public void update_product_payload_with_and(String description, String image) throws IOException {
	    reqspec = given().spec(requestSpecification())
	    		.body(testDataBuild.updateProduct(description, image));
	}

	@When("user calls {string} API with key as extracted via {string} https request")
	public void user_calls_api_with_key_as_extracted_via_https_request(String resource, String method) {
	    
		resourceApiwithPath(resource,method,productId);
	}
	
	public void resourceApiwithPath(String resource, String method, String key) {
		
		ResourceAPI resourceAPI = ResourceAPI.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		
		if(method.equalsIgnoreCase("POST"))
		response = reqspec.when().post(resourceAPI.getResourceWithID(key));      // Capturing response	
		
		else if(method.equalsIgnoreCase("GET"))
			response = reqspec.when().get(resourceAPI.getResourceWithID(key));
		
		else if(method.equalsIgnoreCase("PUT"))
			response = reqspec.when().put(resourceAPI.getResourceWithID(key));
		
		else if(method.equalsIgnoreCase("DELETE"))
			response = reqspec.when().delete(resourceAPI.getResourceWithID(key));
	}

	@Given("Delete the product by passing the id.")
	public void delete_the_product_by_passing_the_id() throws IOException {
	    reqspec = given().spec(requestSpecification());
	}
}

/*
## **2. Products API Scenarios** (`/products`)
### **Basic CRUD Operations**
- ✅ **GET** all products (`GET /products`)
- ✅ **GET** a single product by ID (`GET /products/{id}`)
- ✅ **POST** a new product (`POST /products`)
  - Validate with **all required fields**
  - Validate with **missing/invalid fields**
- ✅ **PUT** update an existing product (`PUT /products/{id}`)
- ✅ **DELETE** a product (`DELETE /products/{id}`)
*/
