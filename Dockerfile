FROM ubuntu:latest AS build

RUN apt-get update && apt-get install -y openjdk-17-jdk wget unzip

RUN wget https://services.gradle.org/distributions/gradle-7.6-bin.zip \
    && unzip gradle-7.6-bin.zip -d /opt \
    && ln -s /opt/gradle-7.6/bin/gradle /usr/bin/gradle

COPY . .

RUN ./gradlew bootJar --no-daemon

FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY --from=build /build/libs/simple_rest.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
