FROM java:8

COPY *.jar /app.jar

CMD ["--server.port=8888"]

EXPOSE 8888

ENTRYPOINT ["java","-jar","/app.jar"]