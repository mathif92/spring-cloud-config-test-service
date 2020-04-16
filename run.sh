#!/usr/bin/env bash

if [ "$(docker ps -a | grep test_service_mysql)" ]; then
    docker start test_service_mysql
else
    docker run --name test_service_mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=test_service -e MYSQL_USER=test -e MYSQL_PASSWORD=test -p 3306:3306 -d mysql:5.5
fi

if [ "$(docker ps -a | grep test-service)" ]; then
    docker rm test-service
fi

# Generate the application's jar file
gradle bootJar

port=8080

# Build the docker image using the Dockerfile placed in this folder
docker build -t test-service:1 --build-arg jar_file=./build/libs/test-service.jar --build-arg port=${port} .
docker run --name test-service --link test_service_mysql --link config-server -p ${port}:${port} test-service:1
