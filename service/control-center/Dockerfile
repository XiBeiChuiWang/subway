FROM java:8

COPY *.jar /app.jar

CMD ["--server.port=8000"]

EXPOSE 8000

ENTRYPOINT ["java","-jar","/app.jar"]