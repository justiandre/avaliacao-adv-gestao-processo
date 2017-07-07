FROM anapsix/alpine-java:8

ENV PORT 8080

EXPOSE 8080

COPY ./adv-eureka-server.jar /data/

CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/data/adv-eureka-server.jar"]
