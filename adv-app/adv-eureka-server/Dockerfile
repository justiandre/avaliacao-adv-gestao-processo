FROM anapsix/alpine-java:8

COPY ./docker/entrypoint.sh /
COPY ./target/adv-eureka-server.jar /data/

RUN \
    apk update && \ 
    apk add curl bash && \
    chmod 777 /entrypoint.sh

ENTRYPOINT ["/entrypoint.sh"]

CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/data/adv-eureka-server.jar"]
