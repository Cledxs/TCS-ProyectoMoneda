FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/moneda-demo-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

#Ejecución:
#1. mvn clean package
#2. docker build -t moneda-demo .
#3. docker run -d -p 8080:8080 moneda-demo