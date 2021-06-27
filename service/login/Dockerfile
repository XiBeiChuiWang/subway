FROM java:8

COPY *.jar /app.jar

CMD ["--server.port=8001"]

EXPOSE 8001

ENTRYPOINT ["java","-jar","/app.jar"]