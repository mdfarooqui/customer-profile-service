# For Java 8, try this
# FROM openjdk:8-jdk-alpine

ADD target/customer-profile-service-1.0.0-SNAPSHOT.jar docker-customer-profile-service.jar

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","docker-customer-profile-service.jar"]

EXPOSE 8081