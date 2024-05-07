FROM eclipse-temurin:21.0.2_13-jdk-alpine
COPY target/rag-1.0.2.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]