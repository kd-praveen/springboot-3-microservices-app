# springboot-3-microservices-app
 The project contains several microservices that communicate with each other using REST APIs. The microservices are built with Spring Boot, which is a framework for creating Java applications that can run as standalone JAR files with an embedded server. The project uses Spring Initializr to generate the basic structure and dependencies for each microservice.

The project consists of the following microservices:

- ***config-server***: This service implements Spring Cloud Config Server. It is used to provide server-side and client-side support for externalized configuration in a distributed system. So when you have multiple microservices, and you want to easily control the configuration for all of them at one go - you’ll mostly be looking at Spring Cloud Config Server.

- ***service-registry***: This service implements Netflix Eureka service registry. A service registry is useful because it enables client-side load-balancing and decouples service providers from consumers without the need for DNS.

- ***springboot-jwt-auth***: This service provides authentication and authorization using Spring Security and JWT tokens.

- ***api-gateway***: This service acts as a gateway for the other services. It uses Spring Cloud Gateway to route requests to the appropriate service based on the URL path.



To run the project, you need to have Java 17, Maven, PostgreSql and Zipkin server installed on your machine.

You can then use a REST client such as Postman or curl to test the APIs of each service.

The token can be obtained by logging in to 'springboot-jwt-auth' with a valid username and password.

For more information about Spring Boot and microservices, you can visit the following links:

- https://spring.io/projects/spring-boot
- https://spring.io/microservices/
