# Building and Running

Instructions for building and running on Linux (java-8-openjdk-amd64):

1.Edit backend/test-configuration.env with your database params and google Geocoder key.

2.Execute following commands:

cd backend

./gradlew clean

./gradlew build -x test

source test-configuration.env

java -jar build/libs/backend-0.0.1-SNAPSHOT.jar

3.Test the API.

# Testing the API

---------------------------------------------------------------------------------------

Insert Test with empty latitude/longitude:

curl --header "Content-Type: application/json"
  --request POST
  --data '{"streetName":"Av. Brasil","number":"9087","complement":"Ap 10","neighbourhood":"Centro","city":"Sao Paulo","state":"Sao Paulo","country":"Brasil","zipcode":"00000-000","latitude":"","longitude":"" }' 
  http://localhost:8080/address


---------------------------------------------------------------------------------------
  
Insert Test with values on latitude/longitude:

curl --header "Content-Type: application/json"
  --request POST
  --data '{"streetName":"Av. Brasil","number":"9087","complement":"Ap 10","neighbourhood":"Centro","city":"Sao Paulo","state":"Sao Paulo","country":"Brasil","zipcode":"00000-000","latitude":"80000","longitude":"50000" }' 
  http://localhost:8080/address  
  
---------------------------------------------------------------------------------------
  
List all: (open in browser: http://localhost:8080/address)

curl http://localhost:8080/address 
  
---------------------------------------------------------------------------------------

List per id test:

curl http://localhost:8080/address/#{id}

---------------------------------------------------------------------------------------

Update by id test:

curl --header "Content-Type: application/json" 
  --request PUT 
  --data '{"id":17,"streetName":"Av. Brasil","number":"7777","complement":"Ap 10","neighbourhood":"Centro","city":"Sao Paulo","state":"Sao Paulo","country":"Brasil","zipcode":"00000-000","latitude":"4345345","longitude":"345345435" }' 
  http://localhost:8080/address

---------------------------------------------------------------------------------------

Delete by id test:

curl -X DELETE http://localhost:8080/address/#{id}


  