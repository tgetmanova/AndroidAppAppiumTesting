# AndroidAppAppiumTesting

To run tests with Maven with Allure test report generation:
`mvn clean test site`

Allure report in HTML format will be output into *target\site\allure-maven-plugin* directory

Appium Driver type is configurable via JVM options parameter: `-DdriverType=Android`.  
This flag is being passed into factory method `getDriverByType()` via Spring IoC configuration.  
By default, it is being instantiated as "Android".  
