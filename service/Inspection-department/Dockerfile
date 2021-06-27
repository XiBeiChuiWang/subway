FROM java:8

COPY *.jar /app.jar

CMD ["--server.port=8002"]

EXPOSE 8002

ENTRYPOINT ["java","-jar","/app.jar"]