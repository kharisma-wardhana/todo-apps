FROM openjdk:17-jdk-alpine3.14 as builder
WORKDIR /app
COPY ./mvnw /app
COPY ./pom.xml /app
COPY ./src /app/src
CMD [ "./mvnw", "clean", "package" ]

FROM openjdk:17-jdk-alpine3.14 as runtime
COPY --from=builder /app/target/*.jar /app/app.jar
EXPOSE 3000
ENTRYPOINT [ "java", "-jar", "/app/app.jar" ]