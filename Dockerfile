FROM openjdk:17
VOLUME /tpm
COPY EmployeeManagementSystem.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
EXPOSE 8080