FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} customer-service.jar
ENTRYPOINT ["java","-jar","/customer-service.jar"]
EXPOSE 9003