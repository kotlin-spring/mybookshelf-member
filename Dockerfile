FROM eclipse-temurin:17 AS builder
WORKDIR /src/source
COPY . .
RUN ./gradlew bootJar

FROM  eclipse-temurin:17
WORKDIR /opt/app
COPY --from=builder /src/source/build/libs/*.jar /opt/app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]