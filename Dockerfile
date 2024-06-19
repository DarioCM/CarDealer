# Start with a base image containing Java runtime
FROM openjdk:17.0.2

# Add Maintainer Info
LABEL maintainer="dario20049@gmail.com"

# WOEKDIR
WORKDIR /dealer-shop

# CMD
CMD ["./gradlew", "clean", "bootJar"]

# COPY
COPY build/libs/dealer-shop-0.0.1-SNAPSHOT.jar dealer-shop.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "dealer-shop.jar"]