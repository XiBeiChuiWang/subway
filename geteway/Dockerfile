FROM java:8

COPY *.jar /app.jar

CMD ["--server.port=20427"]

EXPOSE 20427

ENTRYPOINT ["java","-jar","/app.jar"]