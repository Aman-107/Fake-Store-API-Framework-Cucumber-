Rest Assured : 

Here's a professional README.md for your Fake Store API Framework with Cucumber:

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
- **Authentication Testing** (JWT/Basic Auth)
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
