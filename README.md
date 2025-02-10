# Fake Store API Automation Framework (Cucumber BDD)

[![Java](https://img.shields.io/badge/Java-11%2B-blue)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.6.3%2B-blue)](https://maven.apache.org/)
[![Cucumber](https://img.shields.io/badge/Cucumber-7.0%2B-green)](https://cucumber.io/)
[![RestAssured](https://img.shields.io/badge/RestAssured-5.0%2B-orange)](https://rest-assured.io/)

A Behavior-Driven Development (BDD) framework for testing Fake Store API (https://fakestoreapi.com/) using Cucumber and RestAssured.

## Features

- **BDD Approach** with Gherkin syntax
- **API Endpoint Validation** for:
  - Products
  - Carts
  - Users
  - Authentication
- **Multi-environment Support** (DEV, STAGING, PROD)
- **Data-Driven Testing** with Scenario Outlines
- **HTML/JSON/XML Reports** generation
- **Schema Validation** for API responses
- **CI/CD Ready** (Jenkins/GitHub Actions compatible)
- **Authentication Testing** (Basic Auth)
- **Request/Response Logging**
- **Parallel Test Execution**

## Prerequisites

- Java JDK 11+
- Maven 3.6.3+
- Cucumber 7.0+
- RestAssured 5.0+
- JUnit 4.13+

## Framework Structure

```
Fake-Store-API-Framework-Cucumber/
├── src/
│   ├── main/
│   │    ├── java/
│   │         └──POJO/                                    # serializing and deserializing JSON data
│   │            ├── AddNewCart.java
│   │            ├── AddNewCart_Products.java	
│   │            ├── CreateLoginReq.java	
│   │            ├── CreateLoginReq_Name.java
│   │            ├── CreateLoginReq_Address.java
│   │            ├── CreateLoginReq_Address_Geolocation.java	
│   │            ├── GetAllCarts.java
│   │            ├── GetAllCarts_Products.java
│   │            ├── GetAllProducts.java
│   │            └── GetAllProducts_Ratings.java
│   │			
│   └── test/
│        ├── java/
│            ├── Features/                                # Feature files   
│            │   ├── products.feature                     # Product scenarios
│            │   ├── carts.feature                        # Cart scenarios
│            │   ├── users.feature                        # User scenarios
│            │   └── authentication.feature               # Auth scenarios
│            │	
│            ├── Resources/ 	                          
│            │	 ├── ResourceAPI.java                     # Enumerations - API endpoints constants
│            │	 ├── Utils.java                           # reusable utility classes (spec builder, JSON parsing etc) 
│            │	 ├── TestDataBuild.java                   #Builds dynamic payloads
│            │	 └── GlobalProperties.properties          #environment configurations	
│            │	 
│            ├── Runner/
│            │   └── TestRunner.java                      # Main Cucumber runner class			 
│            │
│            ├── Scrap/
│            │   ├── FakeStoreAPI.java                    # Pseudo Code
│            │   └── UseCases.java                        # Uses Case
│            │   
│            ├── StepDefinitions/		                     # Step definition classes                
│            │   ├── ProductsStepDefs.java                # Product API steps
│            │   ├── ProductsStepDefs.java                # Product API steps
│            │   ├── ProductsStepDefs.java                # Product API steps
│            │   ├── CartsStepDefs.java                   # Cart API steps
│            │   ├── UsersStepDefs.java                   # User API steps
│            │   └── AuthStepDefs.java                    # Authentication steps
│            │
│            ├── utilities/                               # Helper classes
│            │   ├── APIRequestBuilder.java               # Request specification builder
│            │   ├── TestContext.java                     # Shared test context
│            │   ├── ConfigReader.java                    # Config.properties reader
│            │   ├── ResponseValidator.java               # Response validation utils
│            │   └── SchemaValidator.java                 # JSON schema validation
│            │
│            │
│            ├── listeners/                               # Hooks and listeners
│            │   └── TestListener.java                    # Cucumber hooks
│            │
│            │
│            ├── schemas/                                 # JSON schemas
│            │   ├── product-schema.json
│            │   ├── cart-schema.json
│            │   └── user-schema.json
│            │
│            └── testdata/                                # Test data files
│                ├── testdata.json
│                └── testdata.csv
│
├── target/                                               # Generated files
│   ├── cucumber-reports/                                 # Cucumber HTML reports
│   ├── jsonReport/                                       # Test cases json Responses
│   └── surefire-reports/                                 # JUnit XML reports
│                                                         
├── logging.txt                                           # Logs of the Requests
└── pom.xml                                               # Maven dependencies
```

## Getting Started

### Installation

1. Clone the repository:
   ```
   git clone https://github.com/Aman-107/Fake-Store-API-Framework-Cucumber.git
   cd Fake-Store-API-Framework-Cucumber
   ```

2. Install dependencies:
   ```
   mvn clean install
   ```

### Configuration

1. Update `src/test/resources/GlobalProperties.properties`:
   ```properties
   base.url=https://fakestoreapi.com
   env=dev
   log.level=INFO
   auth.token=your_auth_token
   ```

## Running Tests

### Run All Tests
```bash
mvn test
```

### Run Specific Feature {"D_package_name"}
```bash 
mvn test -Drunner="src/test/resources/features/products.feature" 
```

### Run with Tags
```bash
mvn test -Dcucumber.options="--tags @smoke"
```

## Example Test Scenario

```gherkin
Feature: Validating Fake Store API

 @LoginAPI @Regression
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
```

## Reports

Three types of reports generated:
1. **Cucumber HTML Report**: `target/cucumber-reports/cucumber-html-reports/overview-features.html`
2. **JsonReports**: `target/jsonReports/*.json`
3. **JUnit XML Report**: `target/surefire-reports/*.xml`

## Key Dependencies

- RestAssured: API testing
- Cucumber-Java: BDD implementation
- Cucumber-JUnit: Test runners
- Allure-Cucumber: Reporting
- Jackson: JSON processing
- JSON Schema Validator: Schema validation
- Log4j: Logging

## Contributing

1. Create an issue describing the enhancement/bug
2. Fork the repository
3. Create your feature branch (`e.g. - git checkout -b feature/new-endpoint`)
4. Commit your changes (`e.g. - git commit -m 'Add new payment endpoint tests'`)
5. Push to the branch (`e.g. - git push origin feature/new-endpoint`)
6. Open a Pull Request

## License

Distributed under the MIT License. See `LICENSE` for more information.

## Best Practices

- Follow Given-When-Then structure
- Use tags for test categorization
- Validate response schemas
- Implement proper cleanup after tests
- Use environment-specific configurations
- Avoid hardcoding test data


This README provides:
- Clear framework overview
- Setup instructions
- Test execution commands
- Report generation details
- Contribution guidelines
- Best practices for API testing
