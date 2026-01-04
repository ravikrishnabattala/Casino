# 1. Use JDK image
FROM eclipse-temurin:17-jdk

LABEL authors="ravik"

# 2. Copy jar file to container
COPY target/TryYourLuck-1.0-SNAPSHOT.jar app.jar

# 3. Run the jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
