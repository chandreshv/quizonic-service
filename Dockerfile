# Use an official OpenJDK runtime as a parent image
FROM amazoncorretto:17
WORKDIR /app
COPY target/quizonic-service.jar app.jar
EXPOSE 8080
# Command to run the application
CMD ["java", "-jar", "app.jar"]
