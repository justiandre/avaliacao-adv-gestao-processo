FROM anapsix/alpine-java:8

ENV PORT 8080

EXPOSE 8080

COPY ./target/adv-config-server.jar /data/

CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/data/adv-config-server.jar"]
