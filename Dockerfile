FROM openjdk:8-jdk-alpine
COPY ./ ./
COPY build/libs/*.jar app.jar
RUN apk update && apk add curl
ENTRYPOINT ["java","-jar","/app.jar"]