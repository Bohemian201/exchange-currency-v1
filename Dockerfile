FROM adoptopenjdk/openjdk11:latest
RUN mkdir -p /opt/exchangecurrency
WORKDIR /opt/exchangecurrency
COPY target/exchangecurrency-0.0.1-SNAPSHOT.jar /opt/exchangecurrency/target/
EXPOSE 9080
CMD ["sh", "-c", "java -jar /opt/exchangecurrency/target/exchangecurrency-0.0.1-SNAPSHOT.jar"]