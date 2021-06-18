# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.1/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.1/gradle-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.5.1/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.5.1/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Spring Security](https://docs.spring.io/spring-boot/docs/2.5.1/reference/htmlsingle/#boot-features-security)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)






export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64
./gradlew clean
./gradlew build -x test

export DB_HOST=localhost
export DB_PORT=3300
export DB_NAME=STOOM
export DB_USER=root
export DB_PASS=9M2as1sTGQgcgbK2mnQfz5Ye7HvBXDrQ1f/FAgzrhF0=


java -jar build/libs/backend-0.0.1-SNAPSHOT.jar


insert test:

curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"streetName":"Av. Brasil","number":"1234","complement":"Ap 10","neighbourhood":"Centro","city":"Sao Paulo","state":"Sao Paulo","country":"Brasil","zipcode":"00000-000","latitude":"00","longitude":"00" }' \
  http://localhost:8080/address


update test:

curl --header "Content-Type: application/json" \
  --request PUT \
  --data '{"id":1,"streetName":"Av. Brasil","number":"5678","complement":"Ap 10","neighbourhood":"Centro","city":"Sao Paulo","state":"Sao Paulo","country":"Brasil","zipcode":"00000-000","latitude":"00","longitude":"00" }' \
  http://localhost:8080/address

list all test:
curl http://localhost:8080/address -u user:password

read by id test:
curl http://localhost:8080/address/#{id}





