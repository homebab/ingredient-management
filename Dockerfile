#FROM openjdk:11-jdk-alpine
#VOLUME /tmp
#COPY target/media-0.0.1-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java", "-jar", "/app.jar"]

FROM adoptopenjdk/openjdk11:latest
VOLUME /tmp
ARG JAR_FILE='build/libs/server-0.0.1-SNAPSHOT.jar'
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

#FROM openjdk:8-jdk-alpine
#VOLUME /tmp
#ARG JAR_FILE='target/spring-server-1.0-SNAPSHOT.jar'
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java", "-jar", "/app.jar"]