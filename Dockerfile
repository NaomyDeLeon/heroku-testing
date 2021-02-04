FROM maven:latest as build
COPY pom.xml /usr/local/pom.xml
WORKDIR /usr/local/
RUN mvn clean install
RUN ls

FROM openjdk:8-jdk-alpine
COPY --from=build /usr/local/target/technical.test-0.0.1-SNAPSHOT.jar /usr/local/target/technical.test-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/target/technical.test-0.0.1-SNAPSHOT.jar"]
