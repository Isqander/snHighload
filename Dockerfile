FROM openjdk:17-jdk-alpine
COPY /build/libs/HighloadSN-0.0.1-SNAPSHOT.jar /highloadsn.jar
EXPOSE 8080
CMD ["java", "-jar", "/highloadsn.jar"]