FROM openjdk:17-jdk-slim-buster as builder
WORKDIR /app
COPY ./.mvn /app/.mvn
COPY ./mvnw /app
COPY ./pom.xml /app
RUN ./mvnw clean
COPY ./src /app/src
RUN ./mvnw package

FROM openjdk:17-jdk-slim-buster
WORKDIR /app
COPY --from=builder /app/target/*.jar /app/app.jar
EXPOSE 3000
ENTRYPOINT [ "java", "-jar", "/app/app.jar" ]