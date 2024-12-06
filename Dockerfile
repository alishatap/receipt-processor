FROM openjdk:17
COPY target/receipt-processor-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/receipt-processor.jar"]