FROM openjdk:8-jdk-slim as builder
EXPOSE 8080
ADD target/springboot-new.jar springboot-new.jar
ENTRYPOINT ["java","-jar","/springboot-new.jar"]
CMD ["./mvnw", "spring-boot:run"]