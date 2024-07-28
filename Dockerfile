FROM openjdk:24-slim-bullseye

WORKDIR /app

COPY target/StensWateringBackend-1.0.jar /app/backend.jar

ENTRYPOINT ["java", "-jar", "backend.jar"]