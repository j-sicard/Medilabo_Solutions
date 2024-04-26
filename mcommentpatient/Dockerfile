FROM openjdk:17-jdk-alpine

# Copy the data.json file to the image's working directory
COPY src/main/resources/data.json /app/data.json

# Copy your application JAR into the image
COPY target/mcommentpatient-0.0.1-SNAPSHOT.jar message-server-1.0.0.jar

# Input command to launch your application
ENTRYPOINT ["java", "-jar", "/message-server-1.0.0.jar"]
