# RegistrationSuite
A registration test for a travelling website.Starts by directing to the url and entering the credentials to the registration portal then asserting the log out and in using the same credentials authentication.

# Prerequisites
A java ide supplied with jdk v.14 eclipse,intellij,etc and maven for installing dependencies 

# Installing
Install ide then build the pom.xml file to download the dependencies

# Running Tests
Compile Test cases through the testng.xml file

# Break Down
The process starts by navigating to the website then entering the credentials using data driven library which is java faker then assert a proper login and logout to ensure a successful registration.A customized report is generated using extent-report library after compile showing the status and duration for each test case and the report is found in reports folder in .html type and viewed by any browser besides if a failure occurred a screenshot is captured and attached to the report for later investigation.The signup api request is monitored using browsermob library to track both post request data and response in har folder with .har type which can be displayed as txt file or by any browser and a copy of response is attached in har folder for the last process.All files are generated upon running testng.xml file 

# Built With
- Maven -dependency management
- Selenium Framework
- TestNG - Testing Tool
- Extent Report - Customized reports
- Browsermob -  monitor request,response
