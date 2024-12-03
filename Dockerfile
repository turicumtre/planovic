# Build backend
FROM gradle:8.11.1-jdk21 as builder
WORKDIR /app
COPY . .
RUN gradle build -x test

# Run backend
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
