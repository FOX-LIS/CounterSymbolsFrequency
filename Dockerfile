FROM openjdk:17-alpine
MAINTAINER Lisunov Vladimir
COPY target/CounterSymbolsFrequency-0.0.1-SNAPSHOT.jar counterfreq.jar
ENTRYPOINT ["java", "-jar", "/counterfreq.jar"]