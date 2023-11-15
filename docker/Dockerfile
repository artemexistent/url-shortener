####
# This Dockerfile is used in order to build a container that runs the Spring Boot application
#
# Build the image with:
#
# docker build -f docker/Dockerfile -t springboot/sample-demo .
#
# Then run the container using:
#
# docker run -i --rm -p 8081:8081 springboot/sample-demo
####
FROM registry.access.redhat.com/ubi8/openjdk-17:1.15-1.1682053058 AS builder

# Build dependency offline to streamline build
RUN mkdir project
WORKDIR /home/jboss/project
COPY gradlew .
COPY gradle gradle

COPY settings.gradle .
COPY build.gradle .
 
# Copy the source code to the container
COPY src src

# Run the Gradle wrapper to download and install Gradle
RUN ./gradlew --version
 
# Build the Spring Boot application
RUN ./gradlew build

FROM registry.access.redhat.com/ubi8/openjdk-17-runtime:1.15-1.1682053056
COPY --from=builder /home/jboss/project/target/export-run-artifact.jar  /deployments/export-run-artifact.jar
EXPOSE 8080
ENTRYPOINT ["/opt/jboss/container/java/run/run-java.sh", "--server.port=8080"]



