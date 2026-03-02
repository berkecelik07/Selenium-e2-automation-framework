# Contributing to Selenium E2E Automation Framework

Thank you for considering contributing to our project! We appreciate your interest in improving this automation framework.

## 📋 Code of Conduct

This project adheres to a Code of Conduct. By participating, you are expected to uphold this code. Please report unacceptable behavior to the project maintainers.

## 🚀 How to Contribute

### Reporting Bugs

Before creating a bug report, search the issue tracker to ensure the issue hasn't been reported before. When creating a bug report:

- **Use a clear, descriptive title**
- **Provide a detailed description** of the exact steps to reproduce the problem
- **Provide specific examples** to demonstrate the steps
- **Describe the observed behavior** and explain what the expected behavior should be
- **Include screenshots or test logs** if applicable
- **Include your system information** (OS, Java version, Browser version)

### Suggesting Enhancements

When suggesting an enhancement:

- **Use a clear, descriptive title**
- **Provide a detailed description** of the suggested enhancement
- **Provide specific examples** to demonstrate the functionality
- **Explain why this enhancement would be useful** to users
- **List some alternatives** or related features

### Pull Requests

1. Fork the repository and create a new branch:
   ```bash
   git checkout -b feature/YourFeatureName
   ```

2. Make your changes following our code standards

3. Write clear commit messages:
   ```bash
   git commit -m "Add feature: brief description of changes"
   git commit -m "Fix: brief description of bug fix"
   ```

4. Push to your branch:
   ```bash
   git push origin feature/YourFeatureName
   ```

5. Open a Pull Request with:
   - A clear title and description
   - Reference to any related issues
   - Screenshots or test results if applicable

## 📝 Code Standards

### Java Code Style

- **Follow conventional Java naming conventions**
  - Class names: `PascalCase` (e.g., `LoginPageElements`)
  - Method names: `camelCase` (e.g., `enterUsername()`)
  - Constants: `UPPER_SNAKE_CASE` (e.g., `IMPLICIT_WAIT_TIME`)

- **Meaningful names for variables and methods**
  ```java
  // ✅ Good
  WebElement usernameField;
  void enterValidUsername()
  
  // ❌ Avoid
  WebElement f;
  void enter()
  ```

- **Add JavaDoc comments for public methods**
  ```java
  /**
   * This method enters text into a web element after clearing it
   * @param element The web element to interact with
   * @param text The text to enter
   */
  public static void sendText(WebElement element, String text) {
      element.clear();
      element.sendKeys(text);
  }
  ```

### Page Object Guidelines

- **One page class per page/component**
- **Use @FindBy annotations** for element locators
- **Private WebElement fields** with public getter methods
- **Group related actions** in meaningful methods

```java
public class LoginPageElements {
    
    @FindBy(id = "username")
    private WebElement usernameField;
    
    @FindBy(id = "password")
    private WebElement passwordField;
    
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;
    
    public void enterCredentials(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }
    
    public void clickLogin() {
        loginButton.click();
    }
}
```

### Gherkin Guidelines

- **Use Given-When-Then structure**
- **Write clear, readable scenarios**
- **Use descriptive step names**
- **Avoid technical jargon** in feature files

```gherkin
# ✅ Good
Feature: User Authentication

Scenario: Valid user should login successfully
    Given I am on the login page
    When I enter a valid username "admin"
    And I enter a valid password "password123"
    And I click the login button
    Then I should see the dashboard

# ❌ Avoid
Feature: Auth Test

Scenario: Login Test
    When I login
    Then I see dashboard
```

## 🧪 Testing Guidelines

### New Features

- Write test scenarios for new features
- Ensure all tests pass before submitting PR
- Include both positive and negative test cases

```gherkin
Scenario: Valid user login - Happy Path
    When I enter valid credentials
    Then I should be logged in

Scenario: Invalid user login - Sad Path
    When I enter invalid credentials
    Then I should see error message
```

### Test Execution

Before submitting a PR:

```bash
# Clean and run all tests
mvn clean test

# Run specific test suite
mvn -Dtest=RegressionRunner test

# Run by tags
mvn clean test -Dcucumber.filter.tags="@smoke"
```

## 🔍 Code Review Process

1. Your PR will be reviewed by maintainers
2. We may request changes for:
   - Code style issues
   - Missing test coverage
   - Documentation
   - Performance concerns
3. Once approved, your PR will be merged

## 📚 Documentation

- Update README.md if adding new features
- Add comments for complex logic
- Include examples for new utilities
- Update this guide if modifying contribution process

## 🐛 Debugging Tips

### Enable Debug Logging

```java
// In BaseClass.java
public static void setUp() {
    // Add debug flag
    System.out.println("Initializing WebDriver...");
    driver = new ChromeDriver();
    System.out.println("WebDriver initialized successfully");
}
```

### Use Implicit Waits for Debugging

```java
// Slow down test execution to observe browser actions
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
```

### Capture Screenshots on Failure

Already implemented in Hooks.java - check for screenshots in:
- `screenshots/failed/` for failed tests
- `screenshots/passed/` for passed tests

## 📞 Questions?

- Open a Discussion on GitHub
- Create an Issue with the `question` label
- Contact maintainers via email

## ✅ Checklist Before Submitting PR

- [ ] Code follows style guidelines
- [ ] Tests pass locally (`mvn clean test`)
- [ ] New tests added for new features
- [ ] Documentation updated
- [ ] No unnecessary dependencies added
- [ ] Commit messages are clear and descriptive
- [ ] No sensitive data (credentials, API keys) committed
- [ ] Screenshots from test runs attached (if applicable)

---

**Thank you for contributing! Your efforts help make this framework better for everyone.** 🎉
