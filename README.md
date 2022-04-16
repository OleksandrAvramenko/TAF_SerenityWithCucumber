TEST AUTOMATION FRAMEWORK: TestNG+Selenium

### About project
Sample TestNG project using Selenium

### Working with framework
1. Install latest JDK (at least 1.8.x version).
2. Add jdk path to PATH variable.
3. Add JAVA_HOME variable to System Paths with path to jdk bin folder.
4. Install maven.
5. Add M2_HOME variable to System Paths with path to maven bin folder.
6. Open project.
7. Use environment property file to setup configuration:
...\src\main\resources\environments
8. Folder with test suites configuration:
...\src\test\java\packages\suits 
9. Simple Maven run configuration to run test suite:
mvn clean verify -Denv=dev -Dsuite=debug.xml 
mvn clean verify -Denv=dev -Dsuite=debug.xml -DforkCount=0 - to debug
10. Maven command to generate Allure report in target report directory...\target\site\allure-maven-plugin
mvn allure:report
