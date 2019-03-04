FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} fastwave-service.jar
EXPOSE 8764
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/fastwave-service.jar"]