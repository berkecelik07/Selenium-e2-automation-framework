/**
 * BaseClass - WebDriver initialization and teardown
 * 
 * This class handles the initialization and destruction of WebDriver instances.
 * It reads browser configuration from properties file and sets up implicit waits.
 * 
 * Supported browsers: Chrome, Firefox
 * Configuration file: src/test/resources/configs/configuration.properties
 * 
 * @author Berke Solutions
 * @version 1.0
 */
package com.berkesolutions.testbase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.berkesolutions.utils.ConfigsReader;
import com.berkesolutions.utils.Constants;

public class BaseClass {

	/**
	 * Static WebDriver instance used across the framework
	 * Can be accessed from any class extending BaseClass
	 */
	public static WebDriver driver;

	/**
	 * Sets up the WebDriver for test execution
	 * 
	 * Steps performed:
	 * 1. Reads configuration from properties file
	 * 2. Initializes the specified browser (Chrome or Firefox)
	 * 3. Sets implicit wait timeout
	 * 4. Maximizes the browser window
	 * 5. Navigates to the application URL
	 * 6. Initializes all page objects
	 * 
	 * Configuration keys required:
	 * - browser: "chrome" or "firefox"
	 * - url: application base URL
	 */
	public static void setUp() {
		System.out.println("🔧 Setting up WebDriver...");
		
		// Read configuration properties
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);

		String browser = ConfigsReader.getProperty("browser").toLowerCase();
		System.out.println("📱 Initializing " + browser.toUpperCase() + " browser...");

		// Initialize browser based on configuration
		switch (browser) {
		case "chrome":
			System.out.println("✅ Starting ChromeDriver");
			// Note: Selenium 4 auto-manages chromedriver, no need for System.setProperty
			driver = new ChromeDriver();
			break;

		case "firefox":
			System.out.println("✅ Starting FirefoxDriver");
			// Note: Selenium 4 auto-manages geckodriver, no need for System.setProperty
			driver = new FirefoxDriver();
			break;

		default:
			System.out.println("❌ Unsupported browser: " + browser);
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}

		// Configure WebDriver timeouts
		System.out.println("⏱️ Setting implicit wait to " + Constants.IMPLICIT_WAIT_TIME + " seconds");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_TIME));
		
		// Set page load timeout
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_TIMEOUT));
		
		// Set script execution timeout
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Constants.SCRIPT_TIMEOUT));

		// Maximize browser window
		System.out.println("🪟 Maximizing browser window");
		driver.manage().window().maximize();

		// Navigate to application URL
		String website = ConfigsReader.getProperty("url");
		System.out.println("🌐 Navigating to URL: " + website);
		driver.get(website);

		// Initialize all page objects
		System.out.println("📄 Initializing Page Objects");
		PageInitializer.initialize();
		
		System.out.println("✨ WebDriver setup completed successfully!");
	}

	/**
	 * Cleanly closes the WebDriver and releases resources
	 * 
	 * This method:
	 * 1. Checks if driver instance exists
	 * 2. Closes all windows
	 * 3. Quits the driver
	 * 4. Releases all resources
	 */
	public static void tearDown() {
		System.out.println("🧹 Tearing down WebDriver...");
		
		if (driver != null) {
			try {
				driver.quit();
				System.out.println("✅ WebDriver closed successfully");
			} catch (Exception e) {
				System.out.println("❌ Error closing WebDriver: " + e.getMessage());
				e.printStackTrace();
			}
		} else {
			System.out.println("⚠️ WebDriver instance is null");
		}
	}

}
