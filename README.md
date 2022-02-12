TEST AUTOMATION FRAMEWORK: Serenity+jBehave+Maven

### About project
Sample Serenity project using Cucumber

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
...\src\test\java\tests
9. Serenity configuration:
...\src\test\resources\serenity.conf
10. Simple Maven run configuration to run test suite:
A. clean verify -Denv=dev -Dmetaflter=+smoke
B. clean verify -Denv=dev -Dmetafilter=+smoke -DforkCount=0 - to debug