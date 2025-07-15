FROM openjdk:21

ARG APP_JAR=*.jar

COPY ${APP_JAR} app.jar

ENTRYPOINT ["java",  "-jar", "app.jar"]

EXPOSE 9200

#docker build .
#docker run 4ec00ccb2e2fbe5788e07176e729efe63821442cc055088e4deacb1c343ced5b
#docker rmi 367c29e4fda7b76350699553bd2820f4b1b0bfd1c0ec067eec4260cffe690b67
#docker rm 52580d670efe
#docker ps