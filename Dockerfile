FROM maven:latest as builder

COPY pom.xml /usr/local/pom.xml
WORKDIR /usr/local/

RUN mvn clean install


FROM openjdk:8-jdk-alpine
EXPOSE 8080
ARG JAR_FILE=target/technical.test-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
