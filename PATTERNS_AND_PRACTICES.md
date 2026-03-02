# Test Automation - Best Practices & Patterns

This document outlines best practices and common design patterns used in the Selenium E2E Automation Framework.

---

## 📋 Table of Contents

1. [Page Object Model (POM)](#page-object-model)
2. [Step Definition Guidelines](#step-definition-guidelines)
3. [Common Patterns](#common-patterns)
4. [Code Organization](#code-organization)
5. [Error Handling](#error-handling)
6. [Performance Tips](#performance-tips)
7. [Debugging Techniques](#debugging-techniques)

---

## 🏗 Page Object Model

### What is Page Object Model?

The Page Object Model (POM) is a design pattern that creates an object repository for storing web elements of a web page. This reduces code duplication and improves maintainability.

### Benefits:
- ✅ Better code organization
- ✅ Reduces duplication
- ✅ Easy to maintain
- ✅ Easy to debug
- ✅ Improves readability

### Implementation Example:

#### ❌ Anti-Pattern (Without POM):
```java
@When("I login")
public void login() {
    driver.findElement(By.id("username")).sendKeys("admin");
    driver.findElement(By.id("password")).sendKeys("password");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
}
```

**Problems:**
- Locators scattered everywhere
- Hard to maintain if selectors change
- Code duplication across steps

#### ✅ Best Practice (With POM):

**Page Object:**
```java
public class LoginPageElements {
    private WebDriver driver;
    
    @FindBy(id = "username")
    private WebElement usernameField;
    
    @FindBy(id = "password")
    private WebElement passwordField;
    
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;
    
    public LoginPageElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void enterUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
    }
    
    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    
    public void clickLogin() {
        loginButton.click();
    }
}
```

**Step Definition:**
```java
@When("I login with credentials")
public void login() {
    loginPage.enterUsername("admin");
    loginPage.enterPassword("password");
    loginPage.clickLogin();
}
```

**Benefits:**
- Locators in one place
- Easy to update selectors
- Reusable methods
- Clear and maintainable code

---

## 👣 Step Definition Guidelines

### 1. **One Step, One Action**

❌ **Bad:**
```gherkin
Scenario: Complete user registration
    When I fill all registration fields and click submit and wait for confirmation
```

✅ **Good:**
```gherkin
Scenario: Complete user registration
    When I fill in the registration form
    And I click the submit button
    Then I should see the confirmation message
```

### 2. **Use Descriptive Step Names**

❌ **Bad:**
```java
@When("I do something")
public void doSomething() { }

@Then("I check")
public void check() { }
```

✅ **Good:**
```java
@When("I enter a valid username {string}")
public void enterValidUsername(String username) { }

@Then("I should see the welcome message")
public void verifyWelcomeMessage() { }
```

### 3. **Avoid Technical Details in Gherkin**

❌ **Bad:**
```gherkin
When I click on the element with id "submit-btn" using JavaScript
And I wait for AJAX to complete
And I read the element's inner text
```

✅ **Good:**
```gherkin
When I submit the form
And I wait for the page to load
Then I should see the confirmation message
```

### 4. **Use Example Tables for Data-Driven Tests**

```gherkin
Scenario Outline: Login with different users
    When I login with username "<username>" and password "<password>"
    Then I should see "<message>"
    
    Examples:
        | username | password | message           |
        | admin    | pass123  | Welcome Admin     |
        | user     | pass456  | Welcome User      |
        | guest    | pass789  | Welcome Guest     |
```

---

## 🔄 Common Patterns

### Pattern 1: Wait for Element

**Pattern:**
```java
public WebElement waitForElement(By locator) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    return wait.until(ExpectedConditions.presenceOf(driver.findElement(locator)));
}
```

**Usage:**
```java
WebElement element = waitForElement(By.id("dynamic-element"));
element.click();
```

### Pattern 2: Switch to Frame

**Pattern:**
```java
public void switchToFrame(WebElement frameElement) {
    try {
        driver.switchTo().frame(frameElement);
    } catch (NoSuchFrameException e) {
        System.out.println("Frame not found: " + e.getMessage());
    }
}
```

**Usage:**
```java
switchToFrame(loginPage.getIframeElement());
```

### Pattern 3: Handle Alerts

**Pattern:**
```java
public void handleAlert(boolean accept) {
    try {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert: " + alertText);
        
        if (accept) {
            alert.accept();
        } else {
            alert.dismiss();
        }
    } catch (NoAlertPresentException e) {
        System.out.println("No alert present");
    }
}
```

### Pattern 4: Retry Failed Operations

**Pattern:**
```java
public void clickWithRetry(WebElement element, int maxAttempts) {
    int attempts = 0;
    while (attempts < maxAttempts) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            return;
        } catch (Exception e) {
            attempts++;
            if (attempts >= maxAttempts) {
                throw new RuntimeException("Failed to click after " + maxAttempts + " attempts", e);
            }
        }
    }
}
```

---

## 📁 Code Organization

### Recommended Structure:

```
src/test/java/com/berkesolutions/
├── pages/
│   ├── LoginPageElements.java
│   ├── DashboardPageElements.java
│   └── ...
├── steps/
│   ├── LoginSteps.java
│   ├── DashboardSteps.java
│   ├── Hooks.java
│   └── ...
├── testbase/
│   ├── BaseClass.java
│   └── PageInitializer.java
├── utils/
│   ├── CommonMethods.java
│   ├── ConfigsReader.java
│   ├── ExcelUtility.java
│   └── Constants.java
└── runners/
    └── RegressionRunner.java
```

### Naming Conventions:

| Component | Naming Pattern | Example |
|-----------|---|---|
| Page Classes | `[PageName]PageElements` | `LoginPageElements.java` |
| Step Classes | `[FeatureName]Steps` | `LoginSteps.java` |
| Runner Classes | `[Type]Runner` | `RegressionRunner.java` |
| Utility Classes | `[Purpose]` | `CommonMethods.java` |
| Feature Files | `[FeatureName].feature` | `LoginToHRM.feature` |

---

## 🛡️ Error Handling

### Best Practices:

#### 1. **Handle Specific Exceptions**

❌ **Bad:**
```java
try {
    element.click();
} catch (Exception e) {
    e.printStackTrace();
}
```

✅ **Good:**
```java
try {
    element.click();
} catch (StaleElementReferenceException e) {
    System.out.println("Element became stale, retrying...");
    element = driver.findElement(locator);
    element.click();
} catch (TimeoutException e) {
    System.out.println("Element not found within timeout");
    throw new AssertionError("Element not visible: " + e.getMessage());
} catch (NoSuchElementException e) {
    System.out.println("Element does not exist in DOM");
    throw new AssertionError("Element not found: " + e.getMessage());
}
```

#### 2. **Log Errors Properly**

```java
try {
    performAction();
} catch (Exception e) {
    System.err.println("ERROR: Failed to perform action");
    System.err.println("Root cause: " + e.getMessage());
    e.printStackTrace();
    Assert.fail("Test failed due to: " + e.getMessage());
}
```

#### 3. **Clean Up Resources**

```java
try {
    // Test logic
} finally {
    // Always cleanup
    if (driver != null) {
        driver.quit();
    }
}
```

---

## ⚡ Performance Tips

### 1. **Use Explicit Waits Over Implicit**

❌ **Bad:**
```java
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
element.click(); // Waits 10 seconds even if element found in 1 second
```

✅ **Good:**
```java
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
wait.until(ExpectedConditions.elementToBeClickable(element)).click();
// Waits only until element is clickable, no extra wait
```

### 2. **Avoid Multiple Waits**

❌ **Bad:**
```java
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Global wait
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Local wait
wait.until(ExpectedConditions.visibilityOf(element)); // Double waits!
```

✅ **Good:**
```java
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
wait.until(ExpectedConditions.visibilityOf(element));
```

### 3. **Avoid Hard Waits**

❌ **Bad:**
```java
Thread.sleep(5000); // Always waits 5 seconds
```

✅ **Good:**
```java
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
wait.until(ExpectedConditions.visibilityOf(element)); // Waits until condition met
```

### 4. **Parallelize Test Execution**

Use Maven plugins to run tests in parallel:
```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <configuration>
        <parallel>methods</parallel>
        <threadCount>4</threadCount>
    </configuration>
</plugin>
```

---

## 🐛 Debugging Techniques

### 1. **Take Screenshots**

```java
public void takeDebugScreenshot(String name) {
    TakesScreenshot ts = (TakesScreenshot) driver;
    File source = ts.getScreenshotAs(OutputType.FILE);
    String destination = "screenshots/debug/" + name + "_" + System.currentTimeMillis() + ".png";
    new File("screenshots/debug/").mkdirs();
    try {
        FileUtils.copyFile(source, new File(destination));
        System.out.println("Screenshot saved: " + destination);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
```

### 2. **Print Element Information**

```java
public void printElementInfo(WebElement element) {
    System.out.println("Element Tag: " + element.getTagName());
    System.out.println("Element Text: " + element.getText());
    System.out.println("Element Visible: " + element.isDisplayed());
    System.out.println("Element Enabled: " + element.isEnabled());
    System.out.println("Element Location: " + element.getLocation());
    System.out.println("Element Size: " + element.getSize());
}
```

### 3. **Browser Inspection**

```java
public void printPageInfo() {
    System.out.println("Current URL: " + driver.getCurrentUrl());
    System.out.println("Page Title: " + driver.getTitle());
    System.out.println("Page Source Length: " + driver.getPageSource().length());
}
```

### 4. **Slow Down Test Execution for Debugging**

```java
public void debugSlowdown(int seconds) {
    try {
        Thread.sleep(seconds * 1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
```

Use in steps:
```java
@When("I perform action")
public void performAction() {
    loginPage.enterUsername("admin");
    debugSlowdown(2); // Wait 2 seconds to observe
    loginPage.clickLogin();
}
```

---

## 📚 Additional Resources

- [Selenium Documentation](https://www.selenium.dev/documentation/)
- [Cucumber Documentation](https://cucumber.io/docs/gherkin/)
- [Page Object Model Pattern](https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/)
- [Best Practices for Test Automation](https://www.selenium.dev/documentation/test_practices/)

---

**Happy Testing! 🚀**
