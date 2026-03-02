/**
 * Constants class - Contains all application-wide constants
 * 
 * This class holds all the constant values used throughout the framework
 * such as file paths, wait times, and other configuration values.
 * 
 * @author Berke Solutions
 * @version 1.0
 */
package com.berkesolutions.utils;

public class Constants {
	
	// ================== FILE PATH CONSTANTS ==================
	
	/**
	 * Configuration properties file path
	 * Location: src/test/resources/configs/configuration.properties
	 */
	public static final String CONFIGURATION_FILEPATH = 
		System.getProperty("user.dir") + "/src/test/resources/configs/configuration.properties";
	
	/**
	 * HTML Report file path
	 * Location: target/html-report/
	 */
	public static final String REPORT_FILEPATH = 
		System.getProperty("user.dir") + "/target/html-report/HRM.html";
	
	/**
	 * Screenshot storage path
	 * Location: screenshots/ (with subdirectories: passed/, failed/)
	 */
	public static final String SCREENSHOT_FILEPATH = 
		System.getProperty("user.dir") + "/screenshots/";
	
	
	// ================== WAIT TIME CONSTANTS (in seconds) ==================
	
	/**
	 * Default implicit wait time
	 * Used for WebDriver: driver.manage().timeouts().implicitlyWait()
	 * Value: 10 seconds
	 */
	public static final int IMPLICIT_WAIT_TIME = 10;
	
	/**
	 * Default explicit wait time
	 * Used for WebDriverWait: new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_TIME))
	 * Value: 30 seconds
	 */
	public static final int EXPLICIT_WAIT_TIME = 30;
	
	
	// ================== BROWSER CONSTANTS ==================
	
	/**
	 * Chrome browser identifier
	 */
	public static final String BROWSER_CHROME = "chrome";
	
	/**
	 * Firefox browser identifier
	 */
	public static final String BROWSER_FIREFOX = "firefox";
	
	
	// ================== PAGE TIMEOUT CONSTANTS (in seconds) ==================
	
	/**
	 * Page load timeout - Maximum time to wait for page load
	 */
	public static final int PAGE_LOAD_TIMEOUT = 60;
	
	/**
	 * Script timeout - Maximum time to wait for JavaScript execution
	 */
	public static final int SCRIPT_TIMEOUT = 30;
	
	
	// ================== TEST DATA CONSTANTS ==================
	
	/**
	 * Default admin username for testing (when not provided externally)
	 * NOTE: Use configuration.properties for sensitive data in real projects
	 */
	public static final String DEFAULT_USERNAME = "Admin111";
	
	/**
	 * Default admin password for testing (when not provided externally)
	 * NOTE: Use configuration.properties for sensitive data in real projects
	 */
	public static final String DEFAULT_PASSWORD = "password123";
	
	
	// ================== APPLICATION URL CONSTANTS ==================
	
	/**
	 * Base application URL
	 * Note: Actual URL should be read from configuration.properties
	 */
	public static final String BASE_URL = "https://example-hrm.com";
	
	
	// ================== SCREENSHOT SUBDIRECTORIES ==================
	
	/**
	 * Subdirectory for passed test screenshots
	 */
	public static final String PASSED_SCREENSHOTS_FOLDER = "passed/";
	
	/**
	 * Subdirectory for failed test screenshots
	 */
	public static final String FAILED_SCREENSHOTS_FOLDER = "failed/";
	
	
	// ================== HELPER METHODS ==================
	
	/**
	 * Get the project root directory path
	 * @return project root directory
	 */
	public static String getProjectPath() {
		return System.getProperty("user.dir");
	}
	
}
