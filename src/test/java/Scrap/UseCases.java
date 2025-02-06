package Scrap;

public class UseCases {

}


/*
Here are the possible **use cases** for automating the [FakeStoreAPI](https://fakestoreapi.com/docs) using **Rest Assured**:

---

## **1. Authentication Scenarios**
- ✅ Validate login with **valid credentials** (`POST /auth/login`)
- ✅ Validate login with **invalid credentials**
- ✅ Validate login with **missing username/password**
- ✅ Check response time and status code for authentication API

---

## **2. Products API Scenarios** (`/products`)
### **Basic CRUD Operations**
- ✅ **GET** all products (`GET /products`)
- ✅ **GET** a single product by ID (`GET /products/{id}`)
- ✅ **POST** a new product (`POST /products`)
  - Validate with **all required fields**
  - Validate with **missing/invalid fields**
- ✅ **PUT** update an existing product (`PUT /products/{id}`)
- ✅ **DELETE** a product (`DELETE /products/{id}`)

### **Data Validations**
- ✅ Validate the product list is not empty
- ✅ Validate a product contains **valid price, title, and category**
- ✅ Validate response **JSON schema**
- ✅ Validate filtering **by category** (`GET /products/category/{category}`)

### **Performance & Security**
- ✅ Validate API response time
- ✅ Check security headers for API calls

---

## **3. Categories API Scenarios** (`/products/categories`)
- ✅ **GET** all categories (`GET /products/categories`)
- ✅ Validate if categories list is **not empty**
- ✅ Validate response format and schema

---

## **4. Cart API Scenarios** (`/carts`)
### **Basic CRUD Operations**
- ✅ **GET** all carts (`GET /carts`)
- ✅ **GET** a specific cart (`GET /carts/{id}`)
- ✅ **POST** a new cart (`POST /carts`)
- ✅ **PUT** update a cart (`PUT /carts/{id}`)
- ✅ **DELETE** a cart (`DELETE /carts/{id}`)

### **Data Validations**
- ✅ Validate cart contains **valid products and user IDs**
- ✅ Validate response schema for cart API
- ✅ Validate **filtering by date range** (`GET /carts?startdate={}&enddate={}`)
- ✅ Validate **cart retrieval by user ID** (`GET /carts/user/{userId}`)

---

## **5. Users API Scenarios** (`/users`)
### **Basic CRUD Operations**
- ✅ **GET** all users (`GET /users`)
- ✅ **GET** a single user (`GET /users/{id}`)
- ✅ **POST** create a new user (`POST /users`)
- ✅ **PUT** update an existing user (`PUT /users/{id}`)
- ✅ **DELETE** a user (`DELETE /users/{id}`)

### **Validations**
- ✅ Validate **correct user details** in response
- ✅ Validate **user retrieval by ID**
- ✅ Validate response schema
- ✅ Validate **password security** in user creation
- ✅ Validate **address fields (geo, city, zip, street, etc.)**

---

## **6. Negative Test Cases**
- ❌ Try accessing an invalid **product ID**
- ❌ Try deleting a non-existent **cart or user**
- ❌ Try creating a user **without required fields**
- ❌ Test **unauthorized** access by omitting authentication (if applicable)
- ❌ Test **boundary cases** (e.g., large payloads, SQL injection attempts)

---

## **7. Performance & Security Testing**
- ✅ Validate **response times** for all APIs
- ✅ Check for **rate limits** (if any)
- ✅ Verify **CORS headers**
- ✅ Validate API **response caching behavior**
- ✅ Check for **data consistency** across requests


---

## **8. Advanced Product API Scenarios**
- ✅ Validate **sorting of products** by price (`GET /products?sort=asc/desc`)
- ✅ Validate **pagination** (`GET /products?limit=10`)
- ✅ Validate **search functionality** (if supported)
- ✅ Verify **product price updates persist correctly** after `PUT` request
- ✅ Validate that **deleting a product does not affect other products**

---

## **9. Advanced Cart API Scenarios**
- ✅ Validate **adding multiple products** to a cart (`POST /carts`)
- ✅ Validate **removing a single product** from a cart (if applicable)
- ✅ Validate if **cart total updates correctly** after removing a product
- ✅ Test if an **empty cart can be processed**
- ✅ Validate that an **expired cart** cannot be retrieved (if applicable)
- ✅ Ensure **user cannot access another user’s cart** (security check)

---

## **10. Advanced User API Scenarios**
- ✅ Validate creating a user with **same email should fail** (if applicable)
- ✅ Validate **email format correctness** during user creation (`POST /users`)
- ✅ Verify **user details persist correctly** after update (`PUT /users/{id}`)
- ✅ Test **updating only partial user data** (should not remove other details)
- ✅ Ensure **deleting a user removes all associated carts** (if applicable)
- ✅ Validate that **deleted users cannot log in**
- ✅ Verify **phone number format validation**
- ✅ Validate **user roles (if applicable)** - Ensure a normal user cannot access admin functionalities

---

## **11. Security & Negative Scenarios**
- ❌ **SQL Injection attack test** (e.g., passing `' OR 1=1--` in inputs)
- ❌ **XSS attack test** (e.g., injecting `<script>alert('XSS')</script>`)
- ❌ **Verify API does not expose sensitive user details** (e.g., passwords in response)
- ❌ **Check if API allows updating another user’s details** (should be restricted)
- ❌ **Test with an invalid bearer token (if authentication is needed)**
- ❌ **Verify API does not accept malformed JSON payloads**
- ❌ **Check behavior with extremely large payloads**
- ❌ **Ensure API does not expose stack traces in error messages**
- ❌ **Ensure deleted products/carts/users cannot be accessed again**
- ❌ **Ensure non-admin users cannot create products (if applicable)**

---

## **12. Edge Case Testing**
- ✅ **Adding a product with an extremely long name**
- ✅ **Adding a product with a price of `0`**
- ✅ **Adding a product with a negative price (should be rejected)**
- ✅ **Creating a user without an address (should it be allowed?)**
- ✅ **Creating an empty cart (should it be allowed?)**
- ✅ **Attempting to get a product using an invalid ID format (e.g., string instead of integer)**
- ✅ **Adding the same product to the cart multiple times (should it merge or duplicate?)**
- ✅ **Attempting to delete a cart that doesn’t exist**
- ✅ **Check API behavior when a request times out**

---

## **13. API Rate Limiting & Concurrency**
- ✅ **Send multiple concurrent requests to test rate limits**
- ✅ **Test concurrent updates to the same product/user/cart**
- ✅ **Verify race conditions - two users updating the same cart at the same time**
- ✅ **Test what happens when making multiple rapid login requests (brute force protection)**

---

## **14. API Contract Testing**
- ✅ Validate that API **contract/schema does not change unexpectedly**
- ✅ Validate response headers such as **CORS, Content-Type, Cache-Control**
- ✅ Check for **deprecated fields in API responses**
- ✅ Ensure **new fields added to responses do not break existing automation**

---

## **15. API Documentation Testing**
- ✅ Validate if **API responses match documentation**
- ✅ Test if **optional parameters work as described**
- ✅ Ensure **error messages follow a consistent structure**
- ✅ Validate **HTTP status codes** match expected values (`200`, `400`, `404`, etc.)
- ✅ Verify **all endpoints listed in documentation are accessible**

---
*/