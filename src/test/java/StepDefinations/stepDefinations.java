package StepDefinations;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
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
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

public class stepDefinations extends Utils {

	RequestSpecification reqspec;
	TestDataBuild testDataBuild = new TestDataBuild();
	Response response;
	private static String productId;
	private static List<GetAllProducts> products;

	@Given("Add User Payload with {string} and {string}")
	public void add_user_payload_with_and(String username, String password) throws IOException {

		reqspec = given().spec(requestSpecification()).body(testDataBuild.login(username, password));
	}

	@When("user calls {string} API with {string} https request")
	public void user_calls_api_with_https_request(String resource, String method) {

		resourceApi(resource, method);
	}

	@Then("the API got success with status code {int}")
	public void the_api_got_success_with_status_code(Integer expectedStatusCode) {

		response.then().statusCode(expectedStatusCode) // Validate Status Code
				.time(lessThan(2000L)); // validation reponse time

		System.out.println("response time " + response.getTime() + " ms"); // printing response Time
	}

	@Then("verify {string} in response header is {string}")
	public void verify_in_response_header_is(String key, String value) {

		Assert.assertEquals(response.header(key), value);
	}
	
	@Given("Get All Products list")
	public void get_all_products_list() throws IOException {
		
		reqspec = given().spec(requestSpecification());
	}

	@Given("Get a single product by passing the id.")
	public void get_a_single_product_by_passing_the_id() throws IOException {
		
		reqspec = given().spec(requestSpecification());
	}
	
	@When("user calls {string} API with key as {string} via {string} https request")
	public void user_calls_api_with_key_as_via_https_request(String resource, String key, String method) {
	    
		resourceApiwithPath(resource,method,key);
	}
	
	@Then("verify {string} in response body should be {int}")
	public void verify_in_response_body_should_be(String key, Integer expectedValue) {
	    
		Assert.assertEquals(expectedValue.intValue(),getJsonPathInt(response,key));
	}

	@Given("Get the product by filters.")
	public void get_the_product_by_filters() throws IOException {
	   reqspec = given().spec(requestSpecification());
	}
	
	@When("user calls {string} API for {string} via {string} https request, extract all products from {string}")
	public void user_calls_api_for_via_https_request_extract_all_products_from(String resource, String key, String method, String extract) {
	    
		resourceApiwithPath(resource,method,key);
		products = Arrays.asList(response.as(GetAllProducts[].class));
	}
	
	@Then("validate {string} in response body is {string} for every product")
	public void validate_in_response_body_is_for_every_product(String key, String expectedValue) {
	   
		String output = response.getBody().asString();
		
		JsonPath js = new JsonPath(output);
		int size = js.getInt(key + ".size()");
		
		List<String> values = js.getList(key); // Get all values

		for (int i = 0; i < size; i++) {
		    Assert.assertTrue(values.get(i).equals(expectedValue));
		}
		
		}

	@Given("Add New Product Payload with {string}, {double},{string}, {string} and {string}")
	public void add_new_product_payload_with_and(String title, Double price, String description, String image, String category) throws IOException {
	    
		reqspec = given().spec(requestSpecification())
				.body(testDataBuild.addNewProduct(title, price, description, image, category));
	}
	
	@Then("verify {string} in response body is {string}")
	public void verify_in_response_body_is(String key, String expectedValue) {
	    
		String actualValue = getJsonPath(response,key);
		Assert.assertEquals(expectedValue,actualValue);
	}
	
	@Then("extract {string} in response body")
	public void extract_in_response_body(String key) {
	    
		String id = Integer.toString(getJsonPathInt(response,key));
		productId = id;
		//System.out.println(productId);
	}

	@Given("Update Product Payload with {string} and {string}")
	public void update_product_payload_with_and(String value1, String value2) throws IOException {
	    reqspec = given().spec(requestSpecification())
	    		.body(testDataBuild.updateProduct(value1, value2));
	}
	
	@Given("Delete the product by passing the id.")
	public void delete_the_product_by_passing_the_id() throws IOException {
	    reqspec = given().spec(requestSpecification());
	}
	
	
	
	
	
	
	
	
	
	
	
	public void resourceApi(String resource, String method) {

		ResourceAPI resourceAPI = ResourceAPI.valueOf(resource);
		System.out.println(resourceAPI.getResource());

		if (method.equalsIgnoreCase("POST"))
			response = reqspec.when().post(resourceAPI.getResource()); // Capturing response

		else if (method.equalsIgnoreCase("GET"))
			response = reqspec.when().get(resourceAPI.getResource());

		else if (method.equalsIgnoreCase("PUT"))
			response = reqspec.when().put(resourceAPI.getResource());

		else if (method.equalsIgnoreCase("DELETE"))
			response = reqspec.when().delete(resourceAPI.getResource());

	}

	public void resourceApiwithPath(String resource, String method, String key) {

		ResourceAPI resourceAPI = ResourceAPI.valueOf(resource);
		System.out.println(resourceAPI.getResource());

		if (method.equalsIgnoreCase("POST"))
			response = reqspec.when().post(resourceAPI.getResourceWithkey(key)); // Capturing response

		else if (method.equalsIgnoreCase("GET"))
			response = reqspec.when().get(resourceAPI.getResourceWithkey(key));

		else if (method.equalsIgnoreCase("PUT"))
			response = reqspec.when().put(resourceAPI.getResourceWithkey(key));

		else if (method.equalsIgnoreCase("DELETE"))
			response = reqspec.when().delete(resourceAPI.getResourceWithkey(key));

	}

}

/*
 * ## **2. Products API Scenarios** (`/products`) ### **Basic CRUD Operations**
 * - ✅ **GET** all products (`GET /products`) - ✅ **GET** a single product by ID
 * (`GET /products/{id}`) - ✅ **POST** a new product (`POST /products`) -
 * Validate with **all required fields** - Validate with **missing/invalid
 * fields** - ✅ **PUT** update an existing product (`PUT /products/{id}`) - ✅
 * **DELETE** a product (`DELETE /products/{id}`)
 */
