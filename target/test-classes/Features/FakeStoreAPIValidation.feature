Feature: Validating Fake Store API

@LoginAPI
Scenario Outline: Verify if user has successfully Loged In
Given Add User Payload with "<username>" and "<password>"
When user calls "UserLogin" API with "POST" https request
Then the API got success with status code 200
And "Server" in response header is "cloudflare" 

Examples:
| username | password |
|   johnd  | m38rmF$  |
# |kevinryan | kev02937@|
# |  donero  |  ewedon  |

@ProductsAPI
Scenario: Verify if the products API is working properly
Given Get All Products list and print there title.
When user calls "GetAllProducts" API with "GET" https request
Then the API got success with status code 200
And "Server" in response header is "cloudflare" 

@ProductsAPI 
Scenario: Verify if the single product API is working properly
Given Get a single product by passing the id.
When user calls "GetSingleProducts" API with id as "10" via "GET" https request
Then the API got success with status code 200
And "Server" in response header is "cloudflare"
And verify "id" in response body should be 10                        
 # here id as 10 is being passed

@ProductsAPI 
Scenario Outline: Verify if the Add New product is successfully
Given Add New Product Payload with "<title>" and "<category>"
When user calls "AddNewProducts" API with "POST" https request
Then the API got success with status code 200
And "title" in response body is "test product"
And "Server" in response header is "cloudflare"

Examples: 
| title           | category    |
|  test product   | electronic  |

# using hashMap create full payloads

@ProductsAPI 
Scenario Outline: Verify if the product is updated successfully
Given Update Product Payload with "<description>" and "<image>"
When user calls "UpdateProduct" API with id as "10" via "GET" https request
Then the API got success with status code 200
And "title" in response body is "test product"
And "description" in response body is "lorem ipsum set"
And "Server" in response header is "cloudflare" 

Examples: 
|  description      |       image           |
| lorem ipsum set   | https://i.pravatar.cc |


#UpdateProduct
## **2. Products API Scenarios** (`/products`)
### **Basic CRUD Operations**
# ✅ **GET** all products (`GET /products`)
# ✅ **GET** a single product by ID (`GET /products/{id}`)
# ✅ **POST** a new product (`POST /products`)
#  - Validate with **all required fields**
#  - Validate with **missing/invalid fields**
# ✅ **PUT** update an existing product (`PUT /products/{id}`)
# ✅ **DELETE** a product (`DELETE /products/{id}`)



# Scenario Outline: Verify if Place is being Successfully added using AddPlaceAPI
#	Given Add Place Payload with "<name>","<language>","<place>"
#	When user calls "AddPlaceAPI" with "Post" http request
#	Then the API got success with status code 200
#	And "status" in response body is "OK"
#	And "scope" in response body is "APP" 
#	And verify place_Id created maps to "<name>" using "GetPlaceAPI"