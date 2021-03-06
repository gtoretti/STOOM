 Building and Running
----------------------------------------------


Instructions for building and running on Linux (java-8-openjdk-amd64):

If you have a DB available, move to step 1.

If you don't have a DB available for local tests, execute MariaDB as container by the following command:

    docker run --name mariadbtest -e MYSQL_DATABASE=STOOM -e MYSQL_ROOT_PASSWORD=mypass docker.io/library/mariadb:10.4

Next, execute the following command to retrieve the MariaDB IP to connect from outside the container:

    docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' mariadbtest

The DB configuration in this case is the following:

    DB_URL=jdbc:mysql://172.17.0.2:3306/STOOM
    DB_USER=root
    DB_PASS=mypass
    DB_DRIVER=org.mariadb.jdbc.Driver


1.Start up a local Kafka event streaming: https://kafka.apache.org/quickstart


2.Using a separated command window, execute following commands to build, export your DB configuration and start API:


cd backend
./gradlew clean
./gradlew build -x test

export DB_URL=jdbc:mysql://172.17.0.2:3306/STOOM
export DB_USER=root
export DB_PASS=mypass
export DB_DRIVER=org.mariadb.jdbc.Driver
export GEO_KEY=AIzaSyCj0cY2yEvVfYhAaTz3-P2MW-YRKmhz5Uw

java -jar build/libs/backend-0.0.1-SNAPSHOT.jar


3.Test the API.

4.After finished, stop the API with Ctrl+C and if used MariaDB container, stop and remove it with the following commands:

docker stop mariadbtest
docker rm mariadbtest


# Testing the API

---------------------------------------------------------------------------------------

Insert Test with empty latitude/longitude:

curl --header "Content-Type: application/json" --request POST --data '{"streetName":"Av. Brasil","number":"9087","complement":"Ap 10","neighbourhood":"Centro","city":"Sao Paulo","state":"Sao Paulo","country":"Brasil","zipcode":"00000-000","latitude":"","longitude":"" }' http://localhost:8080/address


---------------------------------------------------------------------------------------
  
Insert Test with values on latitude/longitude:

curl --header "Content-Type: application/json" --request POST --data '{"streetName":"Av. Brasil","number":"9087","complement":"Ap 10","neighbourhood":"Centro","city":"Sao Paulo","state":"Sao Paulo","country":"Brasil","zipcode":"00000-000","latitude":"80000","longitude":"50000" }'  http://localhost:8080/address  
  
---------------------------------------------------------------------------------------
  
List all: (open in browser: http://localhost:8080/address)

curl http://localhost:8080/address 
  
---------------------------------------------------------------------------------------

List per id test:

curl http://localhost:8080/address/#{id}

---------------------------------------------------------------------------------------

Update by id test:

curl --header "Content-Type: application/json"  --request PUT --data '{"id":1,"streetName":"Av. Brasil","number":"7777","complement":"Ap 10","neighbourhood":"Centro","city":"Sao Paulo","state":"Sao Paulo","country":"Brasil","zipcode":"00000-000","latitude":"4345345","longitude":"345345435" }' http://localhost:8080/address

---------------------------------------------------------------------------------------

Delete by id test:

curl -X DELETE http://localhost:8080/address/#{id}

-----------------------------------------------------------------------------------
  



Additional useful reference:

SpringBoot Pagination: https://www.baeldung.com/spring-data-jpa-pagination-sorting
Unit Testing: https://spring.io/guides/gs/testing-web/

SOLID: https://en.wikipedia.org/wiki/SOLID
Clean Architecture: https://www.baeldung.com/spring-boot-clean-architecture

Java Useful links:
https://www.javatpoint.com/java-8-features
https://www.javatpoint.com/java-8-stream
https://www.baeldung.com/new-java-9
https://www.baeldung.com/java-10-overview
https://www.baeldung.com/java-11-new-features


