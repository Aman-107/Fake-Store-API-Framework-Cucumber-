package StepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import Resources.TestDataBuild;
import Resources.Utils;


public class stepDefinations extends Utils {

	RequestSpecification reqspec;
	TestDataBuild testDataBuild = new TestDataBuild();
	
	@Given("Add User Payload with {string} and {string}")
	public void add_user_payload_with_and(String username, String password) throws IOException {
		reqspec = given().spec(requestSpecification())
				.body(testDataBuild.Login(username, password));
	}
	
	@When("user calls API with https request")
	public void user_calls_api_with_https_request() {
		reqspec.when()
		.post("auth/login");	
	}
	
	@Then("the API got success with status code {int}")
	public void the_api_got_success_with_status_code(Integer int1) {
		reqspec.then()
		  .statusCode(int1);	
		
	}
}
