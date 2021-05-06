FROM amazoncorretto:11-alpine-jdk
WORKDIR /apps/api-company/
COPY target/api-company.jar ./api-company.jar
ENTRYPOINT ["java", "-jar", "api-company.jar"]
