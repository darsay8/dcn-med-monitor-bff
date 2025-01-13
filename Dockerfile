FROM openjdk:23-slim
WORKDIR /app
COPY target/spring-security-server-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
EXPOSE 8080