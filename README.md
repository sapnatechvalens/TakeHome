# Provider Platform – Selenium Java Automation

## Overview

This project automates test cases for the Provider Platform using Selenium WebDriver and Java.

## Technologies Used

- Java  
- Selenium WebDriver  
- TestNG  
- Maven  
- Allure Reports  

## How to Run

1. Clone the repo:
   ```bash
   git clone https://github.com/sapnatechvalens/TakeHome.git
   ```
2. Install dependencies:
   ```bash
   mvn clean install
   ```
3. Run tests:
   - Using IDE: Open `testng.xml` and run as TestNG Suite
   - Using CLI:
     ```bash
     mvn test
     ```

4. Generate Allure Report:
   ```bash
   allure generate allure-results --clean -o allure-report
   allure open allure-report
   ```

### Note: If Allure is not installed

Install Allure on your system:

- **For Windows (using Scoop):**
  ```bash
  scoop install allure
  ```

- **For macOS (using Homebrew):**
  ```bash
  brew install allure
  ```

Verify installation:
```bash
allure --version
```
- **Project Structure:**
provider-platform-qa/
├── src/
│   ├── base/        # Base setup and teardown
│   ├── pages/       # Page Object classes
│   ├── utils/       # Utility classes
│   └── tests/       # Test cases
├── testng.xml       # TestNG suite
├── pom.xml          # Maven config
├── allure-results/  # Test results
└── README.md        # Documentation
## Author
Sapna Chouhan
