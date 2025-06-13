FROM eclipse-temurin:21-jdk-alpine

ARG JAR_FILE=target/renadeapi-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_renadeapi.jar
EXPOSE 80
ENTRYPOINT ["java", "-jar", "app_renadeapi.jar", "--server.port=80"]