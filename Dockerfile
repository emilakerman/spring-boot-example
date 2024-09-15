FROM ubuntu:latest AS build

# RUN apt-get update && apt-get install -y openjdk-17-jdk wget unzip

RUN apt-get update && apt-get install -y openjdk-17-jdk

WORKDIR /simple_rest

# RUN wget https://services.gradle.org/distributions/gradle-7.6-bin.zip \
#     && unzip gradle-7.6-bin.zip -d /opt \
#     && ln -s /opt/gradle-7.6/bin/gradle /usr/bin/gradle

COPY ./simple_rest .

RUN chmod +x ./gradlew
RUN ./gradlew bootJar --no-daemon

FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY --from=build /simple_rest/build/libs/simple_rest.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
