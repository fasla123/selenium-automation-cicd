# 🧪 E-Commerce Automation Framework

End-to-end Selenium Automation Framework built using **Java, Selenium WebDriver, TestNG, and Maven**, integrated with **Jenkins CI (Continuous Integration)** using **GitHub Webhook**.

The framework executes automated test cases on every code push and generates detailed execution reports.

---

## 📑 Table of Contents

- 📌 Overview
- 🚀 Technology Stack
- 🏗️ Framework Architecture
- 📂 Project Structure
- ⚙️ Test Execution
- 📦 Maven Configuration
- 📊 Reporting
- 🔁 Retry Mechanism
- 👂 TestNG Listeners
- ⚡ Parallel Execution
- 🧵 ThreadLocal WebDriver
- 🔄 CI Integration (Jenkins)
- 📸 Project Evidence
- 📚 Key Learnings
- 🚀 Future Enhancements
- 👩‍💻 Author

---

## 📌 Overview

This project is a scalable automation testing framework designed for an e-commerce application.

It follows the **Page Object Model (POM)** design pattern and includes advanced automation features such as reusable components, reporting, retry logic, parallel execution, and CI integration using Jenkins.

Whenever code is pushed to GitHub, Jenkins automatically triggers the test execution pipeline.

---

## 🚀 Technology Stack

| Technology | Purpose |
|------------|---------|
| Java | Programming Language |
| Selenium WebDriver | Browser Automation |
| TestNG | Test Framework |
| Maven | Build & Dependency Management |
| Jenkins | Continuous Integration |
| Git & GitHub | Version Control |
| Extent Reports | Test Reporting |

---

## 🏗️ Framework Architecture

The framework is built using the **Page Object Model (POM)** to ensure scalability, reusability, and maintainability.

### 🎯 Key Features

- ✅ Page Object Model (POM)
- ✅ Abstract Component Design
- ✅ Cross-Browser Testing
- ✅ Parallel Execution
- ✅ ThreadLocal WebDriver
- ✅ Retry Analyzer
- ✅ TestNG Listeners
- ✅ Extent Reports
- ✅ Maven Framework
- ✅ Jenkins CI Integration
- ✅ GitHub Webhook Automation
---

## 📂 Project Structure

```text
ecommerceframework/
│
├── src/
│   ├── main/java/
│   │   ├── org.example.ecommerceframework.abstractcomponents/
│   │   │   └── AbstractComponent.java
│   │   │
│   │   ├── org.example.ecommerceframework.pageobjects/
│   │   │   ├── LandingPage.java
│   │   │   ├── ProductCatalogue.java
│   │   │   ├── ProductCartPage.java
│   │   │   ├── OrdersPage.java
│   │   │   ├── CheckOutPage.java
│   │   │   └── ConfirmationPage.java
│   │   │
│   │   └── org.example.ecommerceframework.resources/
│   │       ├── ExtentReportNG.java
│   │       └── GlobalData.properties
│
│   ├── test/java/
│   │   ├── org.example.ecommerceframework.testcomponents/
│   │   │   ├── BaseTest.java
│   │   │   ├── Listeners.java
│   │   │   └── Retry.java
│   │   │
│   │   └── org.example.ecommerceframework.tests/
│   │       └── SubmitOrderTest.java
│
├── testng.xml
├── regression.xml
├── pom.xml
│
├── reports/
│   ├── index.html
│   ├── submitOrderTest.png
│   └── loginErrorValidation.png
│
├── test-output/
│
├── target/
│
├── project-evidence/ 
│   ├── jenkins-build-success.png
│   ├── maven-test-run.png
│   ├── extent-report-screenshot.png
│   └── test-execution-video.mp4
│
└── README.md
```

---

## ⚙️ Test Execution

Run tests using Maven with environment and browser configuration:

```bash
mvn test -P<profile> -Dbrowser=<browserName>
```

---

## 📦 Maven Configuration

Maven is used for:

- Dependency management
- Test execution
- TestNG integration
- Maven Surefire Plugin
- Profile-based execution 
- Browser parameterization

---

## 📊 Reporting

The framework generates **Extent Reports** after each execution.

Reports include:

- Test execution status
- Pass / Fail results
- Execution logs
- Screenshots for failed tests
- Execution summary

Reports are generated in:

```
reports/
```

---

## 🔁 Retry Mechanism

A TestNG Retry Analyzer is implemented to re-execute failed test cases caused by intermittent issues.

---

## 👂 TestNG Listeners

Custom listeners are implemented to:

- Track test execution events
- Update Extent Reports
- Capture failure screenshots
- Log test results

---

## ⚡ Parallel Execution

The framework supports parallel execution using TestNG suite configuration to reduce execution time.

---

## 🧵 ThreadLocal WebDriver

ThreadLocal WebDriver is used to ensure thread-safe execution during parallel test runs.

---

## 🔄 CI Integration (Jenkins)

This project implements **Continuous Integration (CI)** using Jenkins.

### CI Flow

```text
GitHub Push → Jenkins Webhook Trigger → Maven Test Execution → Report Generation
```

### Jenkins Configuration

The automation framework is integrated with Jenkins using a Maven job.

**Configuration includes:**

- Configured a Jenkins Maven project for automated test execution.
- Connected the GitHub repository using a GitHub Webhook.
- Configured automatic build triggering on every code push.
- Executed the automation suite using the Maven goal:
  ```text
  test -P"$profile" -D"$browser"

---

## 📸 Project Evidence

The `project-evidence` folder contains CI/CD proof:

- Jenkins job configuration
- GitHub webhook setup
- Jenkins console output (build success)
- Browser execution screenshots
- Extent report output
- Test execution summary

---

## 📚 Key Learnings

- Selenium automation framework design
- Maven project structure and execution
- TestNG framework implementation
- Page Object Model design pattern
- CI integration using Jenkins
- GitHub webhook automation
- Parallel execution handling
- Reporting mechanisms

---

## 🚀 Future Enhancements

- Selenium Grid integration
- API automation framework integration

---

## 👩‍💻 Author

**Ummul Fasla**

QA Engineer | Selenium | Test Automation | Maven | TestNG | Jenkins CI
