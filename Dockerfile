FROM openjdk:17-jdk-alpine

EXPOSE 8081

COPY target/estoque-mercado-0.0.1-SNAPSHOT.jar /app/app.jar
WORKDIR /app

CMD ["java", "-jar", "/app/app.jar"]
