# ---------- Build stage ----------
FROM eclipse-temurin:17-jdk AS builder

LABEL authors="ravik"

WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests

# ---------- Runtime stage ----------
FROM eclipse-temurin:17-jdk

# 2. Copy jar file to container
COPY --from=builder /app/target/Casino-1.0-SNAPSHOT.jar app.jar

# 3. Run the jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
