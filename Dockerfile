FROM openjdk:17-jdk-alpine
ENV client_secret=secreto
ADD build/libs/dbz-msa-dragon-ball-z-bff-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar", "app.jar"]