FROM maven:3.8.6-jdk-11 AS MAVEN_BUILD

MAINTAINER Daniel Barbeira Hayes

COPY pom.xml /build/
COPY src /build/src/

WORKDIR /build/
RUN mvn clean install

FROM eclipse-temurin:11

WORKDIR /app

COPY --from=MAVEN_BUILD /build/target/micro-streaming-analytics-0.0.1-SNAPSHOT.jar /app/
ENTRYPOINT ["java","-jar","micro-streaming-analytics-0.0.1-SNAPSHOT.jar"]