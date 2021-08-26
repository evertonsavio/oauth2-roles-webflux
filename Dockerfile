FROM maven:3.6.3-jdk-11-slim AS MAVEN_BUILD
ARG SPRING_ACTIVE_PROFILE
MAINTAINER Savio
COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn clean install -Dmaven.test.skip=true -Dspring.profiles.active=$SPRING_ACTIVE_PROFILE && mvn package -Dmaven.test.skip=true -B -e -Dspring.profiles.active=$SPRING_ACTIVE_PROFILE
FROM openjdk:11-slim
WORKDIR /app
COPY --from=MAVEN_BUILD /build/target/*.jar /app/app-service.jar
ENTRYPOINT ["java", "-jar", "app-service.jar"]