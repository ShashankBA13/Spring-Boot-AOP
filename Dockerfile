# Stage 1: Build the application
FROM gradle:7.2.0-jdk11 AS builder
COPY --chown=gradle:gradle . /home/gradle/project
WORKDIR /home/gradle/project
RUN gradle build --no-daemon

# Stage 2: Build the image
FROM openjdk:17-alpine
WORKDIR /opt
# ENV PORT 8080
EXPOSE 9091
COPY /build/libs/Spring-Boot-AOP-0.0.1-SNAPSHOT.jar /opt/app.jar
ENTRYPOINT exec java -jar app.jar