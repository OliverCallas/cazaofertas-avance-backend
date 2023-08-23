FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar cazaofertas.jar
ENTRYPOINT [ "java","-jar","/cazaofertas.jar" ]


