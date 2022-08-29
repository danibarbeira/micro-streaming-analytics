FROM eclipse-temurin:11

MAINTAINER Daniel Barbeira Hayes

WORKDIR /micro-streaming-analytics

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
 
COPY src ./src
 
CMD ["./mvnw", "spring-boot:run"]