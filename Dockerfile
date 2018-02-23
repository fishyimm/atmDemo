FROM openjdk:8-jdk-alpine
ADD /target/atmDemo.jar atmDemo.jar
ENTRYPOINT ["java","-jar","atmDemo.jar"]