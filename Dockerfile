FROM openjdk:21-jdk-slim

ADD build/lib/incometax-0.0.1-SNAPSHOT.jar incometax.jar

ENTRYPOINT ["java", "-jar", "incometax.jar"]