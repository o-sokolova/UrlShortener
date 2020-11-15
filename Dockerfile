FROM java:8
WORKDIR /
ADD build/lib/*.jar UrlShortener.jar
EXPOSE 8888
CMD nohup java -jar UrlShortener.jar > app.log &