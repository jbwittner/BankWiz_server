# Stage 1: Build the project
FROM maven:3.9-eclipse-temurin-21-alpine AS build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml file to download dependencies
COPY ../pom.xml pom.xml

# Copy the project source code
COPY ../application application
COPY ../infrastructure infrastructure
COPY ../domain domain

# Run the Maven command to compile the project
RUN --mount=type=cache,target=/root/.m2 mvn clean package -DskipTests -Dcheckstyle.skip

# Stage 2: Run the application
FROM gcr.io/distroless/java21-debian12

# Set the working directory in the container
WORKDIR /app

# Set the Spring Boot profile environment variable
ENV SPRING_PROFILES_ACTIVE="production"

# Copy the compiled JAR file from the previous stage
COPY --from=build /app/application/target/application-*.jar bankwiz-server.jar

# Expose the port on which your application listens
EXPOSE 9595

# Set the entrypoint to run the JVM with the specified JVM options and Spring Boot parameters
ENTRYPOINT ["java", "-jar", "bankwiz-server.jar"]
