FROM adoptopenjdk/openjdk11
EXPOSE 8080
ARG JAR_FILE=target/DollarEuroRecorder.jar
ADD ${JAR_FILE} EuroDollarAPI.jar
ENTRYPOINT ["java","-jar","/EuroDollarAPI.jar"]