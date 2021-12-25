# For Java 8, try this
# FROM openjdk:8-jdk-alpine

ADD target/customer-profile-service.jar customer-profile-service.jar

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","customer-profile-service.jar"]

EXPOSE 8081