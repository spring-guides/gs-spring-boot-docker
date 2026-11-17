#####################################
# Stage 1: Build the application
#####################################
FROM maven:3.9-eclipse-temurin-17 AS builder

WORKDIR /app

COPY . .

# By running this command, Maven will download the dependencies and build the application, skipping the tests to speed up the build process.
RUN mvn clean package -DskipTests

#####################################
# Stage 2: Run the application
#####################################
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8082

# Immutable entrypoint to run the application. This ensures that the application starts when the container is run.
ENTRYPOINT ["java", "-jar", "app.jar"]

# Mutable command to specify the server port. This allows users to override the default port if needed.
CMD ["--server.port=8080"]