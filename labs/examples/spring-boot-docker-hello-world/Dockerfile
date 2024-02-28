#Base Image (Linux)
#Install JRE/JDK
#Copy JAR file
#Start App
#Expose Port

#FROM openjdk:8-jre
#FROM openjdk:11-jre
#FROM openjdk:17
#FROM openjdk:17-slim
FROM openjdk:21-slim


LABEL author="saravana@docker.com"
LABEL version="1.0"
LABEL description="Hello World Docker Demo Image"
#ARG JAR_FILE
#COPY ${JAR_FILE} app.jar
COPY  ./target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 8080