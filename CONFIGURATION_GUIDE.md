# Environment Configuration Guide

This guide explains how to set up and manage different environment configurations for the Selenium E2E Automation Framework.

---

## 📋 Table of Contents

1. [Overview](#overview)
2. [Configuration File Structure](#configuration-file-structure)
3. [Environment-Specific Setups](#environment-specific-setups)
4. [Running Tests with Different Environments](#running-tests-with-different-environments)
5. [Best Practices](#best-practices)
6. [Troubleshooting](#troubleshooting)

---

## 🎯 Overview

Different test environments (Development, QA, Staging, Production) often require different configurations like URLs, credentials, and database connections. This framework supports environment-specific configuration files.

### Supported Environments:
- **Local** - Development environment on your machine
- **Dev** - Development server
- **QA** - Quality Assurance environment
- **Staging** - Pre-production environment
- **Prod** - Production environment

---

## 📁 Configuration File Structure

### Default Configuration
**File:** `src/test/resources/configs/configuration.properties`

All property keys are defined here:
```properties
# Browser Configuration
browser=chrome
url=https://example-hrm.com/

# User Credentials
username=Admin111
password=your_password

# Database Configuration
dbUrl=jdbc:mysql://localhost:3306/testdb
dbUserName=root
dbPassword=dbpassword

# Wait Times
implicit_wait=10
explicit_wait=30
```

---

## 🔧 Environment-Specific Setups

### 1. Create Environment-Specific Files

Create separate property files for each environment:

#### `configuration-local.properties` (Development Machine)
```properties
# Local Development Setup
browser=chrome
url=http://localhost:8080/hrm
username=localadmin
password=localpass123

# Local Database
dbUrl=jdbc:mysql://localhost:3306/hrm_local
dbUserName=root
dbPassword=root

implicit_wait=5
explicit_wait=10
```

#### `configuration-dev.properties` (Dev Server)
```properties
# Development Server
browser=chrome
url=https://dev-hrm.company.com/
username=dev_admin
password=dev_password_123

# Dev Database
dbUrl=jdbc:mysql://dev-db.company.com:3306/hrm_dev
dbUserName=dev_user
dbPassword=dev_pass

implicit_wait=10
explicit_wait=30
```

#### `configuration-qa.properties` (QA Environment)
```properties
# QA Environment
browser=firefox
url=https://qa-hrm.company.com/
username=qa_admin
password=qa_password_456

# QA Database
dbUrl=jdbc:mysql://qa-db.company.com:3306/hrm_qa
dbUserName=qa_user
dbPassword=qa_pass

implicit_wait=15
explicit_wait=45
```

#### `configuration-staging.properties` (Staging)
```properties
# Staging Environment
browser=chrome
url=https://staging-hrm.company.com/
username=staging_admin
password=staging_password_789

# Staging Database
dbUrl=jdbc:mysql://staging-db.company.com:3306/hrm_staging
dbUserName=staging_user
dbPassword=staging_pass

implicit_wait=10
explicit_wait=30
```

#### `configuration-prod.properties` (Production)
```properties
# Production Environment
browser=chrome
url=https://hrm.company.com/
username=${ENV_PROD_USERNAME}
password=${ENV_PROD_PASSWORD}

# Production Database
dbUrl=${ENV_PROD_DB_URL}
dbUserName=${ENV_PROD_DB_USER}
dbPassword=${ENV_PROD_DB_PASS}

implicit_wait=20
explicit_wait=60
```

### 2. Update ConfigsReader to Support Environments

**Enhanced ConfigsReader.java:**
```java
package com.berkesolutions.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader {
    static Properties prop;

    /**
     * Reads properties file based on environment
     * Priority: environment-specific file > default file
     * 
     * @param filePath path to properties file
     */
    public static void readProperties(String filePath) {
        prop = new Properties();
        
        try {
            // Get environment from system property or use "local" as default
            String environment = System.getProperty("env", "local");
            System.out.println("Loading configuration for environment: " + environment);
            
            // Construct environment-specific file path
            String envSpecificPath = filePath.replace("configuration.properties", 
                "configuration-" + environment + ".properties");
            
            File envFile = new File(envSpecificPath);
            File defaultFile = new File(filePath);
            
            // Try to load environment-specific file
            if (envFile.exists()) {
                System.out.println("Using environment-specific config: " + envSpecificPath);
                prop.load(new FileInputStream(envFile));
            } else {
                System.out.println("Environment config not found, using default: " + filePath);
                prop.load(new FileInputStream(defaultFile));
            }
            
        } catch (IOException e) {
            System.out.println("Error loading properties file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Gets property value by key
     * 
     * @param key the property key
     * @return the property value, or null if not found
     */
    public static String getProperty(String key) {
        String value = prop.getProperty(key);
        
        // Support environment variables as fallback
        if (value == null || value.startsWith("${")) {
            String envVar = value.replace("${", "").replace("}", "");
            value = System.getenv(envVar);
            if (value == null) {
                System.out.println("WARNING: Property not found: " + key);
            }
        }
        
        return value;
    }
}
```

---

## 🚀 Running Tests with Different Environments

### Method 1: Using Maven Properties

#### Run tests on QA environment:
```bash
mvn clean test -Denv=qa
```

#### Run tests on Dev environment:
```bash
mvn clean test -Denv=dev
```

#### Run tests on Staging:
```bash
mvn clean test -Denv=staging
```

#### Run tests on Local:
```bash
mvn clean test -Denv=local
```

### Method 2: Using System Properties in Code

```java
// In Step or anywhere in code
String environment = System.getProperty("env", "local");
System.out.println("Testing on: " + environment);
```

### Method 3: Manual Configuration Switch

Edit `configuration.properties` and change the values directly:
```bash
mvn clean test
```

### Method 4: Using Different Runners for Different Environments

Create environment-specific runners:

**QARunner.java:**
```java
@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/",
    glue = "com.berkesolutions.steps",
    tags = "@qa",
    plugin = {
        "html:target/cucumber-qa-report.html",
        "json:target/cucumber-qa.json"
    },
    dryRun = false,
    monochrome = true
)
public class QARunner {
}
```

Run QA tests:
```bash
mvn -Dtest=QARunner test
```

---

## ✅ Best Practices

### 1. **Use Environment Variables for Sensitive Data**

Instead of hardcoding passwords, use environment variables:

```properties
# configuration-prod.properties
username=${PROD_USERNAME}
password=${PROD_PASSWORD}
```

Set environment variables before running tests:
```bash
# Linux/Mac
export PROD_USERNAME="admin"
export PROD_PASSWORD="secure_password"
mvn clean test -Denv=prod

# Windows PowerShell
$env:PROD_USERNAME="admin"
$env:PROD_PASSWORD="secure_password"
mvn clean test -Denv=prod

# Windows Command Prompt
set PROD_USERNAME=admin
set PROD_PASSWORD=secure_password
mvn clean test -Denv=prod
```

### 2. **Create Default/Template Configuration**

Start with a template showing all available properties:

```properties
# Configuration Template
# Copy and customize for each environment

# Browser settings
browser=chrome  # Options: chrome, firefox
headless=false  # Run in headless mode: true/false

# Application URLs
url=https://example.com/
api_url=https://api.example.com/

# Credentials
username=admin
password=password123

# Database (optional)
dbUrl=jdbc:mysql://localhost:3306/db
dbUserName=root
dbPassword=password

# Wait times (seconds)
implicit_wait=10
explicit_wait=30
page_load_timeout=60

# Logging
log_level=INFO  # Options: DEBUG, INFO, WARN, ERROR
```

### 3. **Document All Configurations**

Create a `CONFIGURATION.md` file:
```markdown
# Configuration Properties Reference

| Key | Description | Example | Required |
|-----|-----------|---------|----------|
| browser | Browser to use | chrome, firefox | Yes |
| url | Application URL | https://example.com | Yes |
| username | Login username | admin | Yes |
| password | Login password | pass123 | Yes |
| implicit_wait | Default wait in seconds | 10 | No |
```

### 4. **Keep Defaults Secure**

The default `configuration.properties` should be:
- **In .gitignore** (don't commit actual credentials)
- **Template-based** (show structure, not secrets)
- **Well-documented** (explain each property)

### 5. **Version Control**

```
.gitignore (exclude all configuration.*.properties)
└─ configuration.properties              (template for developers)
   configuration-dev.properties          (git ignored)
   configuration-qa.properties           (git ignored)
   configuration-staging.properties      (git ignored)
   configuration-prod.properties         (git ignored)
```

---

## 🐛 Troubleshooting

### Issue: "Configuration file not found"

**Cause:** Path is incorrect
**Solution:** Verify file path in Constants.java:
```java
System.out.println(Constants.CONFIGURATION_FILEPATH); // Print actual path
```

### Issue: "Environment-specific config not loading"

**Cause:** File naming or path issue
**Solution:** Ensure file naming: `configuration-{env}.properties`
```bash
# Check file exists
ls -la src/test/resources/configs/configuration-*.properties
```

### Issue: "Property returns null"

**Cause:** Property key doesn't exist
**Solution:** 
```java
// Check what properties are loaded
prop.list(System.out);

// Use ConfigsReader.getProperty() with logging
String value = ConfigsReader.getProperty("key");
if (value == null) {
    System.out.println("Property 'key' not found in configuration");
}
```

### Issue: "Environment variable not working"

**Cause:** Environment variable not set
**Solution:** 
```bash
# Verify environment variable is set
echo $PROD_USERNAME  # Linux/Mac
echo %PROD_USERNAME%  # Windows

# Set if not set
export PROD_USERNAME="value"
```

---

## 💡 Advanced: Property Substitution

Create a properties processor for environment interpolation:

```java
public class PropertyResolver {
    private Properties props;
    
    public PropertyResolver(Properties props) {
        this.props = props;
    }
    
    public String resolveProperty(String key) {
        String value = props.getProperty(key);
        
        // Replace ${VAR} with environment variable
        if (value.contains("${")) {
            return value.replaceAll("\\$\\{(.*?)\\}", 
                envVar -> System.getenv(envVar.group(1)));
        }
        
        return value;
    }
}
```

---

## 📚 Summary

1. **Create configuration files** for each environment
2. **Use ConfigsReader** to load environment-specific configs
3. **Pass environment via Maven property:** `mvn clean test -Denv=qa`
4. **Protect sensitive data** using environment variables
5. **Document all properties** in a reference guide
6. **Keep defaults secure** in .gitignore

---

**Happy Testing Across All Environments! 🚀**
