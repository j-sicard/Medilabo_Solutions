# Using the OpenJDK 17 JDK Alpine image as a base
FROM openjdk:17-jdk-alpine

# Copying Spring Boot application JAR file to Docker container
COPY target/mpatient-0.0.1-SNAPSHOT.jar app.jar

# Copy the directory containing the data.sql file into the Docker container
COPY src/main/resources/data.sql /docker-entrypoint-initdb.d/

# Spring Boot application run command when starting container
ENTRYPOINT ["java", "-jar", "/app.jar"]
