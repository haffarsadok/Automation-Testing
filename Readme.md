# **User Login Automation Testing with Selenium and Cucumber**

## **Overview**

This project is a **Test Automation Framework** designed to validate the functionality of a web application's login feature. The framework is built using **Java**, **Selenium WebDriver**, **Cucumber**, and **ExtentReports**. It supports testing various login scenarios such as successful login and login failure due to invalid credentials.

By leveraging Cucumber's **Gherkin** syntax, the project enables easy-to-read test cases that ensure seamless collaboration between technical and non-technical team members.

Additionally, the framework captures screenshots for failed scenarios, generating detailed test reports to enhance debugging and provide insights into test execution.



## **Technologies Used**

- **Java**: Core programming language for writing test scripts.
- **Selenium WebDriver**: Used to automate interactions with the web application.
- **Cucumber**: Behavior-Driven Development (BDD) framework that uses Gherkin for writing test cases.
- **ExtentReports**: For generating visually rich and detailed test execution reports.
- **Maven**: Dependency management and build tool.
- **WebDriverManager**: Automates the setup of WebDriver binaries.
---
## **Project Structure**


├───src
│   ├───main
│   │   └───java
│   │       └───pages
│   └───test
│       ├───java
│       │   ├───base
│       │   ├───ExtentReport
│       │   └───StepDefinitions
│       └───resources
│           └───features
└───target
    ├───extent-reports
    ├───screenshots          


## **Test Scenarios**

### **Successful Login**
- **login.features**: Where the scenarios created.
- **Scenario**: Verify the user can log in with valid credentials .
- **Example**:
  - Username: `tomsmith`
  - Password: `SuperSecretPassword!`

### **Failed Login**
- **Scenario**: Verify the application displays an error message for invalid credentials.
- **Examples**:
  - Username: `WrongUsername`, Password: `SuperSecretPassword!`
  - Username: `haffar`, Password: `MedSadok`
  - Username: `tomsmith`, Password: `SuperSecretPassword!`

---

## **Features**

1. **BDD Approach**: Scenarios are written in plain English using the Gherkin syntax.
2. **Dynamic Screenshot Capture**:*
   - Creates a folder inside screenshots if there are a failed scenario.
   - Captures screenshots for **failed** scenarios.
   - Includes timestamps in filenames to avoid overwriting.
3. **Detailed Reports**:
   - Generates rich HTML reports for test execution using ExtentReports.
   - Provides step-by-step logs and embedded screenshots for each scenario.
4. **Centralized Setup and Teardown**:
   - TestBase ensures uniform initialization and cleanup of the WebDriver.
5. **Scenario Tags**:
   - Tags like `@ValidCredentials` and `@InvalidCredentials` allow selective test execution.

---

## **Setup Instructions**

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/haffarsadok/Automation-Testing.git
   ```
2. **Go To CucumberRunner.java**:
   ```bash
     cd src\test\java\CucumberRunner.java
   ```
3. **Run the test**:
   - Run the CucumberRunner 

## **Technologies Used**

- **Java**: Programming language for test automation logic.
- **Selenium WebDriver**: Browser automation framework.
- **Cucumber**: BDD framework for human-readable test scenarios.
- **ExtentReports**: Reporting tool for detailed and visually appealing reports.
- **Maven**: Dependency management and build automation.

