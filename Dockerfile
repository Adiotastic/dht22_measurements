FROM openjdk:8-jdk-alpine
ENV SPRING_PROFILES_ACTIVE=docker
ENV JAVA_OPTS=""
EXPOSE 8080
ADD target/*.jar app.jar
ENTRYPOINT exec java $JAVA_OPTS -Dspring.profiles.active=${SPRING_PROFILES_ACTIVE} -jar app.jar
