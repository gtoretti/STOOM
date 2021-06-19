FROM openjdk:8u212-jdk-alpine3.9

RUN mkdir /opt/microservices/

ADD build/libs/backend-0.0.1-SNAPSHOT.jar /opt/microservices/
RUN adduser -D docker
RUN chown -R docker.docker /opt/microservices/ &&\
    chmod -R 775 /opt/microservices/

EXPOSE 8080
WORKDIR /opt/microservices

USER docker

#set the following env vars in the cloud provider:
ENV DB_URL=${DB_URL}
ENV DB_USER=${DB_USER}
ENV DB_PASS=${DB_PASS}
ENV DB_DRIVER=${DB_DRIVER}
ENV GEO_KEY=${GEO_KEY}

ENTRYPOINT ["java", "-jar", "backend-0.0.1-SNAPSHOT.jar"]