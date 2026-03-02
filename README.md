# 🚀 Selenium E2E Automation Framework

A robust, well-structured, and scalable end-to-end automation testing framework built with **Selenium WebDriver**, **Cucumber BDD**, and **Java** for testing web applications.

![Java](https://img.shields.io/badge/Java-17-brightgreen)
![Selenium](https://img.shields.io/badge/Selenium-4.19.1-green)
![Cucumber](https://img.shields.io/badge/Cucumber-7.16.1-blue)
![Maven](https://img.shields.io/badge/Maven-3.0+-orange)
![License](https://img.shields.io/badge/License-MIT-yellow)

---

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [Running Tests](#running-tests)
- [Test Reports](#test-reports)
- [Framework Architecture](#framework-architecture)
- [Best Practices](#best-practices)
- [Contributing](#contributing)
- [Troubleshooting](#troubleshooting)

---

## 📖 Overview

This framework provides a comprehensive solution for end-to-end automation testing of web applications. It follows the **Page Object Model (POM)** design pattern and uses **Cucumber** for Behavior-Driven Development (BDD), allowing non-technical stakeholders to understand test scenarios.

### Key Highlights:
- ✅ BDD approach using Cucumber feature files
- ✅ Page Object Model for maintainability
- ✅ Cross-browser testing support (Chrome, Firefox)
- ✅ Data-driven testing with Excel support
- ✅ Parallel test execution
- ✅ Comprehensive HTML reports
- ✅ Screenshot capture for failed tests
- ✅ Centralized configuration management

---

## ✨ Features

| Feature | Description |
|---------|-------------|
| **BDD Framework** | Cucumber for behavior-driven testing with Gherkin syntax |
| **Page Object Model** | Organized page element classes for maintainability |
| **Multi-browser Support** | Test execution on Chrome and Firefox |
| **Data-Driven Testing** | Excel file integration for test data management |
| **Cross-browser Testing** | Run tests on different browsers seamlessly |
| **Screenshot & Logging** | Automatic screenshot capture for failed tests |
| **Maven Integration** | Easy dependency management and test execution |
| **HTML Reports** | Beautiful Cucumber HTML reports with detailed metrics |
| **Parallel Execution** | Run multiple tests simultaneously |
| **Hooks** | Pre/Post test setup and teardown |
| **Common Utilities** | Reusable methods for common Selenium operations |

---

## 🛠 Tech Stack

| Tool/Library | Version | Purpose |
|-------------|---------|---------|
| **Java** | 17 | Programming language |
| **Selenium WebDriver** | 4.19.1 | Browser automation |
| **Cucumber** | 7.16.1 | BDD framework |
| **JUnit** | (Cucumber) | Test runner |
| **Apache POI** | 5.2.5 | Excel file handling |
| **Commons IO** | 2.15.1 | File operations |
| **SLF4J** | 2.0.13 | Logging framework |
| **Maven** | 3.0+ | Build automation |

---

## 📁 Project Structure

```
selenium-e2e-automation-framework/
│
├── src/
│   └── test/
│       ├── java/com/berkesolutions/
│       │   ├── pages/                    # Page Object Model classes
│       │   │   ├── LoginPageElements.java
│       │   │   ├── DashboardPageElements.java
│       │   │   ├── AddEmployeePageElements.java
│       │   │   └── ...
│       │   │
│       │   ├── steps/                    # Step definitions (Gherkin implementations)
│       │   │   ├── LoginSteps.java
│       │   │   ├── DashboardSteps.java
│       │   │   ├── Hooks.java            # Setup & teardown
│       │   │   └── ...
│       │   │
│       │   ├── testbase/                 # Base classes & utilities
│       │   │   ├── BaseClass.java        # WebDriver initialization
│       │   │   └── PageInitializer.java  # Page object initialization
│       │   │
│       │   ├── utils/                    # Helper utilities
│       │   │   ├── CommonMethods.java    # Common Selenium operations
│       │   │   ├── ConfigsReader.java    # Configuration file reader
│       │   │   ├── ExcelUtility.java     # Excel file handling
│       │   │   └── Constants.java        # Application constants
│       │   │
│       │   ├── runners/                  # Test runners
│       │   │   ├── RegressionRunner.java
│       │   │   ├── TestRunner.java
│       │   │   └── FailedRunner.java
│       │   │
│       │   └── practice/                 # Learning examples
│       │       ├── ListExample.java
│       │       ├── MapExample.java
│       │       └── ...
│       │
│       └── resources/
│           ├── features/                 # Cucumber feature files (.feature)
│           │   ├── LoginToHRM.feature
│           │   ├── Dashboard.feature
│           │   ├── AddEmployee.feature
│           │   └── ...
│           │
│           ├── configs/
│           │   └── configuration.properties  # Application configuration
│           │
│           └── testdata/                 # Test data files
│               └── (Excel files, JSON, etc.)
│
├── screenshots/                           # Test execution screenshots
│   ├── passed/                           # Screenshots of passed tests
│   └── failed/                           # Screenshots of failed tests
│
├── target/                               # Maven build output
│   └── (compiled classes & reports)
│
├── pom.xml                               # Maven configuration
├── README.md                             # Project documentation
└── .gitignore                            # Git ignore rules

```

---

## 📋 Prerequisites

Before setting up the framework, ensure you have the following installed:

### System Requirements:
- **Operating System**: Windows, macOS, or Linux
- **Java**: JDK 17 or higher
- **Maven**: 3.6 or higher
- **Git**: For version control

### Browser Setup:
- **ChromeDriver**: Match your Chrome version (auto-managed by Selenium 4)
- **GeckoDriver**: For Firefox testing (auto-managed by Selenium 4)

### IDE:
- **Eclipse IDE**, **IntelliJ IDEA**, or **VS Code**

### Verify Installation:
```bash
# Check Java version
java -version

# Check Maven version
mvn --version

# Check Git version
git --version
```

---

## 🚀 Installation

### Step 1: Clone the Repository
```bash
git clone https://github.com/yourusername/Selenium-e2e-automation-framework.git
cd Selenium-e2e-automation-framework
```

### Step 2: Install Dependencies
The framework uses Maven for dependency management. Maven will automatically download all required libraries.

```bash
# Clean and install all dependencies
mvn clean install

# Or just install without cleaning
mvn install
```

### Step 3: Import into IDE

#### For IntelliJ IDEA:
1. Open IntelliJ IDEA
2. Click `File` → `Open`
3. Select the project folder
4. Click `Open as Project`
5. Maven will automatically download dependencies

#### For Eclipse:
1. Open Eclipse
2. Click `File` → `Import`
3. Select `Existing Maven Projects`
4. Browse and select the project folder
5. Click `Finish`

### Step 4: Verify Setup
```bash
# Run Maven compile to verify setup
mvn clean compile
```

---

## ⚙️ Configuration

### Configuration File Location:
`src/test/resources/configs/configuration.properties`

### Example Configuration:
```properties
# Browser Configuration
browser=chrome           # Options: chrome, firefox

# Application URL
url=https://example-hrm.com/

# Credentials
username=Admin111
password=your_password

# Database Configuration (optional)
dbUrl=jdbc:mysql://localhost:3306/testdb
dbUserName=root
dbPassword=password

# Implicit Wait Time (in seconds)
implicit_wait=10

# Explicit Wait Time (in seconds)
explicit_wait=15
```

### Environment-Specific Configuration:
Create different property files for different environments:
```
configuration.properties      # Default/Production
configuration-dev.properties  # Development
configuration-qa.properties   # QA
configuration-staging.properties  # Staging
```

### Creating Environment-Specific Properties:
```bash
# To run tests with a specific environment
mvn clean test -Denv=qa
```

---

## 🧪 Running Tests

### Run All Tests (Tagged with @regression):
```bash
mvn clean test
```

### Run Specific Test Runner:
```bash
mvn -Dtest=RegressionRunner test
```

### Run Tests by Tags:
```bash
# Using Cucumber tags to run specific scenarios
mvn clean test -Dcucumber.filter.tags="@smoke"
mvn clean test -Dcucumber.filter.tags="@regression"
mvn clean test -Dcucumber.filter.tags="@Login"
```

### Run Specific Feature File:
```bash
mvn clean test -Dtest=RegressionRunner -Dcucumber.features="src/test/resources/features/LoginToHRM.feature"
```

### Run with Specific Browser:
```bash
# Edit configuration.properties before running
# Or set programmatically
mvn clean test -Dbrowser=firefox
```

### Run Tests in Parallel (Advanced):
Update `pom.xml` with parallel configuration for faster execution.

### Run Failed Tests Only:
```bash
mvn clean test -Dtest=FailedRunner
```

---

## 📊 Test Reports

### Cucumber HTML Reports
After test execution, reports are generated automatically.

**Report Location**: `target/cucumber-default-report.html`

### View Report:
1. Navigate to the `target` folder
2. Open `cucumber-default-report.html` in a web browser
3. View detailed test results with steps and screenshots

### Report Contents:
- ✅ Test execution summary (pass/fail/skip)
- 📝 Feature-wise breakdown
- 🖼️ Screenshots for failed scenarios
- ⏱️ Execution time metrics
- 📈 Detailed step information

### Screenshots:
- **Passed Tests**: `screenshots/passed/`
- **Failed Tests**: `screenshots/failed/`

---

## 🏗 Framework Architecture

### Design Patterns Used:

#### 1. **Page Object Model (POM)**
```java
// Example: LoginPageElements.java
public class LoginPageElements {
    @FindBy(id = "username")
    private WebElement usernameField;
    
    @FindBy(id = "password")
    private WebElement passwordField;
    
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;
    
    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }
    // ... more methods
}
```

#### 2. **Step Implementations (Glue Code)**
```java
// Example: LoginSteps.java
public class LoginSteps extends CommonMethods {
    @When("I enter a valid username")
    public void user_enters_valid_username() {
        CommonMethods.sendText(loginPage.getUsernameField(), 
            ConfigsReader.getProperty("username"));
    }
    // ... more steps
}
```

#### 3. **Base Class Pattern**
```java
// BaseClass handles WebDriver initialization
public class BaseClass {
    public static WebDriver driver;
    
    public static void setUp() {
        // Browser initialization
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfigsReader.getProperty("url"));
    }
}
```

### Execution Flow:
```
Feature File (.feature)
         ↓
   Cucumber Parser
         ↓
  Step Implementation (Steps)
         ↓
  Page Object Model (POM)
         ↓
 Common Methods / Utilities
         ↓
  Selenium WebDriver
         ↓
  Browser Actions
```

---

## 🎯 Best Practices

### 1. **Page Object Naming**
```java
// ✅ Good
public class LoginPageElements {
    @FindBy(id = "username")
    private WebElement usernameField;
}

// ❌ Avoid
public class login_page {
    @FindBy(id = "username")
    private WebElement f;
}
```

### 2. **Write Clear Gherkin Scenarios**
```gherkin
# ✅ Good
Scenario: Valid user should login successfully
    When I enter a valid username
    And I enter a valid password
    And I click the login button
    Then I should see the dashboard

# ❌ Avoid
Scenario: Login
    When I login
    Then I see dashboard
```

### 3. **Use Explicit Waits**
```java
// ✅ Good - Use explicit waits
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
wait.until(ExpectedConditions.elementToBeClickable(element));

// ❌ Avoid - Implicit waits only
Thread.sleep(5000); // Never use Thread.sleep()
```

### 4. **Handle Exceptions Gracefully**
```java
// ✅ Good
try {
    element.click();
} catch (staleElementReferenceException e) {
    // Re-initialize element
    element = driver.findElement(By.id("element"));
}

// ❌ Avoid
element.click(); // No exception handling
```

### 5. **Keep Tests Independent**
```gherkin
# Each scenario should be standalone and not dependent on others
# Use Background for common setup
Background:
    Given I am logged in as an admin
```

### 6. **Use Data-Driven Testing**
```gherkin
Scenario Outline: Login with multiple credentials
    When user enters login information "<username>" and "<password>"
    And I click the login button
    Then verify that "<employeeName>" is showing

    Examples:
        | username  | password | employeeName |
        | user1     | pass1    | John Doe     |
        | user2     | pass2    | Jane Smith   |
```

---

## 🚦 Continuous Integration (CI/CD)

### GitHub Actions Example (`.github/workflows/tests.yml`):
Create this file in your project:
```yaml
name: Selenium Tests

on: [push, pull_request]

jobs:
  test:
    runs-on: ubuntu-latest
    
    steps:
    - uses: actions/checkout@v2
    
    - name: Set up Java
      uses: actions/setup-java@v2
      with:
        java-version: '17'
    
    - name: Run tests
      run: mvn clean test
    
    - name: Publish test results
      if: always()
      uses: actions/upload-artifact@v2
      with:
        name: test-reports
        path: target/cucumber-default-report.html
```

---

## 🐛 Troubleshooting

### Common Issues and Solutions:

#### 1. **"ChromeDriver not found" Error**
```
Solution: Selenium 4 automatically manages drivers.
- Clear Maven cache: mvn clean
- Delete .m2 directory and reinstall
```

#### 2. **"Element not found" Exception**
```
Solution:
- Verify locators in Page Objects using Inspect Element
- Ensure element is visible and in DOM before interaction
- Use explicit waits instead of implicit waits
- Check if element is inside an iframe
```

#### 3. **"Stale Element Reference" Error**
```
Solution:
- Re-initialize element after navigation
- Use dynamic element finding instead of caching
- Implement proper waits
```

#### 4. **Tests Timeout**
```
Solution:
- Increase wait times in configuration.properties
- Check application performance
- Verify network connectivity
- Check if element selectors are too broad
```

#### 5. **Screenshot Not Captured**
```
Solution:
- Verify screenshots directory exists
- Check file permissions
- Ensure Hooks.java is properly configured
- Verify TakesScreenshot is implemented
```

### Debug Mode:
```java
// Add this to see browser actions in slow motion
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
// Or use explicit delays:
Thread.sleep(1000); // Only for debugging, remove before committing
```

---

## 📚 Example Usage

### Running a Login Test:

**Feature File** (`LoginToHRM.feature`):
```gherkin
@smoke @Login
Scenario: Valid user login
    When I enter a valid username
    And I enter a valid password
    And I click on the login button
    Then I validate that I am logged in
```

**Step Implementation** (`LoginSteps.java`):
```java
@When("I enter a valid username")
public void enterValidUsername() {
    CommonMethods.sendText(
        loginPage.usernameField, 
        ConfigsReader.getProperty("username")
    );
}

@When("I enter a valid password")
public void enterValidPassword() {
    CommonMethods.sendText(
        loginPage.passwordField, 
        ConfigsReader.getProperty("password")
    );
}

@When("I click on the login button")
public void clickLoginButton() {
    loginPage.loginButton.click();
}

@Then("I validate that I am logged in")
public void validateLogin() {
    Assert.assertTrue(dashboardPage.dashboardTitle.isDisplayed());
}
```

**Run Command**:
```bash
mvn clean test -Dcucumber.filter.tags="@smoke"
```

---

## 🤝 Contributing

Contributions are welcome! Please follow these guidelines:

1. **Fork the repository**
2. **Create a feature branch** (`git checkout -b feature/AmazingFeature`)
3. **Commit your changes** (`git commit -m 'Add AmazingFeature'`)
4. **Push to the branch** (`git push origin feature/AmazingFeature`)
5. **Open a Pull Request**

### Code Style Guidelines:
- Follow Java naming conventions (camelCase)
- Write meaningful commit messages
- Add comments for complex logic
- Keep methods small and focused (Single Responsibility Principle)
- Write descriptive Gherkin scenarios

---

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 📞 Support & Contact

For questions, issues, or suggestions:
- 📧 Email: your.email@example.com
- 🐛 Report Issues: [GitHub Issues](https://github.com/yourusername/Selenium-e2e-automation-framework/issues)
- 💬 Discussions: [GitHub Discussions](https://github.com/yourusername/Selenium-e2e-automation-framework/discussions)

---

## 📈 Roadmap

- [ ] Add RestAssured for API testing
- [ ] Implement parallel test execution
- [ ] Add performance benchmarking
- [ ] Enhanced reporting with charts
- [ ] Docker support for CI/CD
- [ ] Allure Reports integration
- [ ] Database testing capabilities
- [ ] Mobile automation support (Appium)

---

## 🙌 Acknowledgments

- Selenium WebDriver documentation
- Cucumber official documentation
- Community best practices in test automation

**Happy Testing! 🚀**

---

*Last Updated: March 2026*
*Maintained by: Your Name*

