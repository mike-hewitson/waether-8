FROM openjdk:8-alpine

COPY target/uberjar/weather-8.jar /weather-8/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/weather-8/app.jar"]
