FROM openjdk:17
COPY src/main/resources/receipt-processor-0.0.1-SNAPSHOT.jar receipt-processor.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/receipt-processor.jar"]