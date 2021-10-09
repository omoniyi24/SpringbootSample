#FROM nginx:latest
#COPY ./target/interview-0.0.1-SNAPSHOT.jar /interview-0.0.1-SNAPSHOT.jar

FROM java:8
WORKDIR /
COPY ./target/interview-0.0.1-SNAPSHOT.jar /interview-0.0.1-SNAPSHOT.jar
EXPOSE 8080



