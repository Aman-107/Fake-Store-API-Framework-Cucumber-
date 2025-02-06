package StepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import org.hamcrest.Matcher;

import Resources.TestDataBuild;
import Resources.Utils;


public class stepDefinations extends Utils {

	RequestSpecification reqspec;
	TestDataBuild testDataBuild = new TestDataBuild();
	Response response;
	
	@Given("Add User Payload with {string} and {string}")
	public void add_user_payload_with_and(String username, String password) throws IOException {
		reqspec = given().spec(requestSpecification())
				.body(testDataBuild.Login(username, password));
	}
	
	@When("user calls API with https request")
	public void user_calls_api_with_https_request() {
		response = reqspec.when()   // Capturing response
		.post("auth/login");	
	}
	
	@Then("the API got success with status code {int}")
	public void the_api_got_success_with_status_code(Integer expectedStatusCode) {
		response.then()
		  .statusCode(expectedStatusCode)  // Validate Status Code
		  .time(lessThan(2000L))         // validation reponse time
		.assertThat()
        .body(matchesJsonSchemaInClasspath("authentication-schema.json"));
		
		System.out.println("response time " + response.getTime() + " ms"); // printing response Time
	}
}

/*
## **1. Authentication Scenarios**
- ✅ Validate login with **valid credentials** (`POST /auth/login`)
- ✅ Validate login with **invalid credentials**
- ✅ Validate login with **missing username/password**
- ✅ Check response time and status code for authentication API
*/
