# Notification Microservice

[![NPM](https://img.shields.io/npm/l/react)](https://github.com/JoelMaciel/Product-Catalog/blob/readm/LICENCE)

## About the project.

### Notification Service is a microservice designed to manage the receiving and sending 
### of notifications to users. It is part of a microservice architecture and communicates
### with the Course microservice via RabbitMQ, a robust and reliable messaging system.

## **Main functionality**
### Message reception: The microservice listens to the queue of RabbitMQ registration messages published by the Course Service.
### Sending Notifications: On receiving an enrollment message, the service processes the information and sends a welcome message to the newly enrolled user.




## Technology used :
-  JAVA 11 
-  RABBITMQ
-  DOCKER
-  SPRING SECURITY
-  UNIT TESTING, INTEGRATION AND E2E USING JUNIT5 AND MOCKITO.
-  POSTGRESQL - FLYWAY
-  JPA PERSISTENCE - SPRING DATA JPA
-  SPRING HATEOAS
-  OPEN API (SWAGGER)
-  VALIDATION
-  JACOCO

## Request Images

### Eureka Server
![Captura de tela de 2024-06-11 11-27-06](https://github.com/JoelMaciel/ead_authuser_microservice/assets/77079093/953f3b67-2a0d-425e-a456-3c13572e81d2)


### RabbitMQ -->>


#### EXCHANGES
![Captura de tela de 2024-06-11 16-38-53](https://github.com/JoelMaciel/ead_authuser_microservice/assets/77079093/d3c2215e-cc02-4eb8-9af1-7b1dfaca47cc)

#### QUEUES
![Captura de tela de 2024-06-11 16-38-41](https://github.com/JoelMaciel/ead_authuser_microservice/assets/77079093/3c03795c-99a9-446a-81de-693ad15e92b5)



## Project under construction....