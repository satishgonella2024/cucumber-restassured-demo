# Use a base image with Java and Gradle
FROM gradle:7.6.1-jdk17 AS build

# Set the working directory
WORKDIR /app

# Copy the project files
COPY . .

# Build the project
RUN gradle clean build

# Use a smaller base image for running the application
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/app/build/libs/app-1.0-SNAPSHOT.jar /app/app.jar

# Expose any necessary ports (optional)
EXPOSE 8080

# Command to run the tests
CMD ["java", "-jar", "app.jar"]