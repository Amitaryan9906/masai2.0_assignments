# Amazon Search Automation with Extent Reports

## 🚀 Tools Used
- Selenium WebDriver
- TestNG
- ExtentReports 5
- WebDriverManager

## 🧪 Test Scenario
1. Navigate to Amazon
2. Search for "Laptop"
3. Validate title and search results
4. Capture screenshot if the test fails

## 📂 Project Structure
- `tests/` → Contains `AmazonSearchTest.java`
- `utils/` → Contains `ExtentReportManager.java`
- `testng.xml` → Runs only SmokeTest group
- `test-output/` → Report HTML and screenshots

## ▶️ How to Run
```bash
mvn clean test -DsuiteXmlFile=testng.xml
