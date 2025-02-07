package Scrap;

import io.restassured.RestAssured;

public class FakeStoreAPI {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://fakestoreapi.com";
		
		String str = "products/category/{type}";
		System.out.println(str.split("}")[0]);
		// Create a new user
	}

}

/*
## **1. Authentication Scenarios**
- ✅ Validate login with **valid credentials** (`POST /auth/login`)
- ✅ Validate login with **invalid credentials**
- ✅ Validate login with **missing username/password**
- ✅ Check response time and status code for authentication API
- ✅ Validate response schema for authentication API
*/