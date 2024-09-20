FROM amazoncorretto:21-alpine-jdk as build
WORKDIR /app
COPY . .
RUN chmod +x mvnw
RUN ./mvnw package -DskipTests

# Run stage
FROM amazoncorretto:21-alpine-jdk
COPY --from=build /app/target/Pagina-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]