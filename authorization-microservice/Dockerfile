#FROM openjdk:8-jdk-alpine
#EXPOSE 8090
#ADD target/rest-docker-demo-0.0.1-SNAPSHOT.jar rest-docker-demo-0.0.1-SNAPSHOT.jar
#ENTRYPOINT ["java","-jar","/rest-docker-demo-0.0.1-SNAPSHOT.jar"]

# For Java 8, try this
FROM openjdk:8-jdk-alpine

# For Java 11, try this
# FROM adoptopenjdk/openjdk11:alpine-jre

# Refer to Maven build -> finalName
ARG JAR_FILE=target/authorization-microservice.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/docker-demo.jar /opt/app/docker-demo.jar
COPY ${JAR_FILE} authorization-microservice.jar

# java -jar /opt/app/docker-demo.jar
ENTRYPOINT ["java","-jar","authorization-microservice.jar"]
