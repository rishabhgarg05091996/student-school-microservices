# student-school Microservices Project
Simple Microservices project using Spring Boot 3, Spring Cloud, and PostgreSQL database
This project implements a microservices architecture with the following components:

## API Gateway
The API Gateway serves as the single entry point for all client requests, managing and routing them to the appropriate microservices.

## Config Server
The Config Server centralizes configuration management for all microservices, simplifying application maintenance and ensuring consistency across environments.

## Discovery Server
The Discovery Server provides service registration and discovery, enabling seamless service-to-service communication within the microservices ecosystem.

## Student Microservice
The Student Microservice is responsible for managing student-related data and operations, such as adding, updating, and retrieving student records.

## School Microservice
The School Microservice manages school-related data and operations, including adding, updating, and retrieving school records.

## Inter-Service Communication - Using OpenFeign
This project demonstrates inter-service communication using OpenFeign, a declarative REST client that simplifies service-to-service communication within the microservices ecosystem.

## Distributed Tracing - Using Zipkin
The project showcases the use of Zipkin for distributed tracing, enhancing application observability and enabling the visualization and troubleshooting of latency issues.

## Pre-requisites
1. Create PostgreSQL database table with name `student` and 'school'.

## Usage
### School Microservice Endpoints :- 
1. To Fetch all schools :- http://localhost:8222/api/v1/schools
2. To fetch specific school with its students :- http://localhost:8222/api/v1/schools/with-students/1

### Student Microservice Endpoints :-
1. To Fetch all students :- http://localhost:8222/api/v1/students
2. To fetch all students by school Id :- http://localhost:8222/api/v1/students/school/1

### Eureka Dashboard :-
http://localhost:8761/



