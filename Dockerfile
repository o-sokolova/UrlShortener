FROM openjdk:8-jdk-alpine
COPY . .
ENTRYPOINT ["java","-jar","build/libs/*.jar"]