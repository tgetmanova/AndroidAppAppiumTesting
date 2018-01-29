# Android App "Buy List" with Appium testing 

## **Project structure**  
- ***Selenium*** and ***Appium*** client libraries for Java
- ***Spring Context*** for Appium driver type injection  
- ***TestNG*** as a main test run and tests suite framework arrangement
- ***Allure*** library allows to use specific annotations that will be reflected  
in the corresponding Allure report. ***Allure plugin for Maven*** allows to generate  
HTML reports automatically with Maven lifecycle phases. ***Allure adapter for TestNG***  
integrates tests suites with Allure reporting
- ***AssertJ*** library is used for assertions customization  
  
`src/main/resources/` contains `app` directory where target application apk file   
is located;  
also here Allure and Application properties files are kept.    
The last one specify some properties extracted from Android driver configuration.

## ***Test run***
- **Appium Driver type** is configurable via JVM options parameter: `-DdriverType=Android`.  
This flag is being passed into factory method `getDriverByType()` via Spring IoC configuration.  
By default, it is being instantiated as "Android".  
- Start **Appium** server
- Connect and start **Android device [emulator]** 
- Run tests (either single test method/test class or all tests included into  
`src/test/resources/al-tests.xml`) with right click -> 'Run tests' in IDE or  
creating run configurations *TestNG* and specifying test suites/methods manually



- To run tests with Maven with Allure test report generation:
`mvn clean test site`  
Allure report in HTML format will be output into `target\site\allure-maven-plugin` directory

![alt text](https://raw.githubusercontent.com/tgetmanova/AndroidAppAppiumTesting/master/.github/Maven_Allure_Idea_Config.png)


At the time this project was being developed, the following Android version usage statistic presented:

![alt text](https://raw.githubusercontent.com/tgetmanova/AndroidAppAppiumTesting/master/.github/Android_versions.PNG)

Taking into consideration given statistic tests have been validated for the most popular 6 and 7 versions + the latest 8 for perspective
