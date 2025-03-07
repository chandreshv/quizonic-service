# Use an official OpenJDK runtime as a parent image
FROM amazoncorretto:17
WORKDIR /app
COPY target/quizonic-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
# Command to run the application
CMD ["java", "-jar", "app.jar"]
