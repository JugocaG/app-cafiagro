FROM eclipse-temurin:17.0.9_9-jdk
ADD build/libs/cafiagro-0.0.1-SNAPSHOT.jar cafiagro-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "cafiagro-0.0.1-SNAPSHOT.jar"]

