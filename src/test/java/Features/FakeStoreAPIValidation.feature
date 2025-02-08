Feature: Validating Fake Store API


@LoginAPI
Scenario Outline: Verify if user has successfully Loged In
Given Add User Payload with "<username>" and "<password>"
When user calls "UserLogin" API with "POST" https request
Then the API got success with status code 200
And verify "Server" in response header is "cloudflare" 

Examples:
| username | password |
|   johnd  | m38rmF$  |
# |kevinryan | kev02937@|
# |  donero  |  ewedon  |


@ProductsAPI
Scenario: Verify if the All Products API is working properly
Given Get All Products list
When user calls "GetAllProducts" API with "GET" https request
Then the API got success with status code 200
And verify "Server" in response header is "cloudflare"

@ProductsAPI 
Scenario: Verify if the single product API is working properly
Given Get a single product by passing the id.
When user calls "GetSingleProducts" API with key as "10" via "GET" https request
Then the API got success with status code 200
And verify "Server" in response header is "cloudflare"
And verify "id" in response body should be 10                        
# here id as 10 is being passed

@ProductsAPI
Scenario: Verify the filtering of products is working properly
Given Get the product by filters.
When user calls "FilteredProduct" API for "electronics" via "GET" https request, extract all products from "category"
Then the API got success with status code 200
And validate "category" in response body is "electronics" for every product 

@ProductsAPI 
Scenario Outline: Verify if the New product added is successfully
Given Add New Product Payload with "<title>", <price>,"<description>", "<image>" and "<category>"
When user calls "AddNewProducts" API with "POST" https request
Then the API got success with status code 200
And verify "title" in response body is "test product"
And verify "Server" in response header is "cloudflare"
And extract "id" in response body

Examples: 
| title           |   price  |      description    |   image               |    category   |
|  test product   |  13.5    | 		lorem ipsum set  | https://i.pravatar.cc |   electronic  |


@ProductsAPI 
Scenario Outline: Verify if the product is updated successfully
Given Update Product Payload with "<description>" and "<image>" 
When user calls "UpdateProduct" API with key as "10" via "PUT" https request
Then the API got success with status code 200
And verify "title" in response body is "test product"
And verify "description" in response body is "shadow ipsum set"
And verify "Server" in response header is "cloudflare" 

Examples: 
|  description      |       image           |
| shadow ipsum set  | https://i.cars.png    |


@ProductsAPI 
Scenario: Verify if the product is deleted successfully
Given Delete the product by passing the id.
When user calls "DeleteProduct" API with key as "10" via "DELETE" https request
Then the API got success with status code 200
And verify "Server" in response header is "cloudflare"
And verify "id" in response body should be 10 


@ProductsAPI
Scenario: Verify if the categories API giving responses
Given Get all categories
When user calls "CategoriesOfProduct" API with "GET" https request
Then the API got success with status code 200
And verify "Server" in response header is "cloudflare"
And verify categories list in response body is not null


@CartsAPI
Scenario: Verify if the All Carts Products API is working properly
Given Get All Carts list
When user calls "GetAllCarts" API with "GET" https request
Then the API got success with status code 200
And verify "Server" in response header is "cloudflare"  

@CartsAPI 
Scenario: Verify if the single Cart is working properly
Given Get a single cart by passing the id.
When user calls "GetSingleCart" API with key as "2" via "GET" https request
Then the API got success with status code 200
And verify "Server" in response header is "cloudflare"
And verify "id" in response body should be 2
And verify response should be from "GetAllCarts" for id "2" passed

@CartsAPI 
Scenario Outline: User creates a new cart with dynamic product details
Given User provides cart details with userId <userId> and date "<date>"
And User adds product with productId <productId1> and quantity <quantity1>
And User adds product with productId <productId2> and quantity <quantity2>
And User adds product with productId <productId3> and quantity <quantity3>
When user calls "GetAllCarts" API with "POST" https request
Then the API got success with status code 200
And verify "userId" in response body should be 1
And The response should contain products with correct productId and quantity
And extract "id" in response body

Examples:
| userId | date                      | productId1 | quantity1 | productId2 | quantity2 | productId3 | quantity3 |
| 1      | 2024-07-02T00:00:00.000Z  | 2          | 4         | 1          | 10        | 5          | 2         |
#| 2      | 2025-11-15T00:00:00.000Z  | 3          | 1         | 4          | 5         | 6          | 8         |


@CartsAPI 
Scenario Outline: Verify if the cart is updated successfully
Given Update Cart Payload with userId <userId> and date "<date>"
And User adds product with productId <productId1> and quantity <quantity1>
When user calls "GetSingleCart" API with key as "11" via "PUT" https request
Then the API got success with status code 200
And verify "id" in response body should be 11
And verify "date" in response body is "2025-11-15T00:00:00.000Z"
And verify "Server" in response header is "cloudflare" 

Examples:
| userId | date                      | productId1 | quantity1 |
#| 1      | 2024-07-02T00:00:00.000Z  | 2          | 4         | 1          | 10        | 5          | 2         |
| 2      | 2025-11-15T00:00:00.000Z  | 3          | 1         | 


@CartsAPI 
Scenario: Verify if the Cart is deleted successfully
Given Delete the product by passing the id.
When user calls "GetSingleCart" API with key as "6" via "DELETE" https request
Then the API got success with status code 200
And verify "Server" in response header is "cloudflare"
And verify "id" in response body should be 6

