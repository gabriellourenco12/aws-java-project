FROM openjdk:11
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} aws-project.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/aws-project.jar"]