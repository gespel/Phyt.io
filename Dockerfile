FROM openjdk:24-slim-bullseye

WORKDIR /app

COPY target/StensWateringBackend-1.0-jar-with-dependencies.jar /app/backend.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "backend.jar"]