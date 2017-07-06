# data-consumer
Data Consumer Service - Rest API
Service to consume JSON/HTML 

API Requirements :
1. Create a Spring boot application which would have e2e API.
2. The API needs to fetch data from Apache (with dispatcher module configured).
3. Write a Unit test to validate the code.
4. Write a selenium based automation test.
5. Additionally , try for API specifications are in swagger and consider versioning in context path.

Technology Stack :
1. Java/J2EE
2. Spring Boot - Micro Service framework
3. Rest Template - Rest API
4. json-simple - JSON API
5. Junit/Selenium - Testing Frawework
6. Maven - Build Tool
7. Swagger - API Specifications
8. Sonar/Jacoco - Test Coverage

Building and executing the application from command line

mvn clean package
java -jar target/consumer-service-0.0.1-SNAPSHOT.jar

Open http://localhost:8080 in a browser
