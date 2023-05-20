FROM openjdk:17-alpine
WORKDIR /opt
# ENV PORT 8080
EXPOSE 9091
COPY /build/libs/Spring-Boot-AOP-0.0.1-SNAPSHOT.jar /opt/app.jar
ENTRYPOINT exec java -jar app.jar