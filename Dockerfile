# Use Maven to build the application
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Use Tomcat to run the application
FROM tomcat:9.0-jdk21
WORKDIR /usr/local/tomcat/webapps
COPY --from=build /app/target/gestionContrat-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
CMD ["catalina.sh", "run"]
