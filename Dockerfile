# Use Maven with JDK 17
FROM maven:3.9.6-eclipse-temurin-17

# Set working directory inside container
WORKDIR /app

# Copy all project files into container
COPY . .

# Run Maven tests
CMD ["mvn", "clean", "test"]
