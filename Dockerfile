FROM gradle:jdk11-slim 

WORKDIR /home/gradle/project
COPY build.gradle .

USER root
RUN chown -R gradle /home/gradle/project
USER gradle