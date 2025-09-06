FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY gradlew .
COPY gradle gradle
COPY build.gradle.kts .
COPY settings.gradle.kts .
COPY src src

RUN chmod +x ./gradlew
RUN ./gradlew build -x test

EXPOSE 5005 8080

CMD ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=*:5005", "-cp", "build/classes/java/main", "org.thread.Main"]