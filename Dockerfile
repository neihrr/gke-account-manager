FROM openjdk:17-jdk-slim
WORKDIR /app
COPY demo-0.0.1-SNAPSHOT.jar /app/demo-client.jar
EXPOSE 8091
CMD ["java", "-jar", "demo-client.jar"]