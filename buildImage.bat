#!/bin/sh
./mvnw clean package && java -jar target/bookcrossing-main-0.0.1-SNAPSHOT.jar
docker build -t ikyz9/bookcrossing-main .
./mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=ikyz9/bookcrossing-main