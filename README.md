# Test technique 

this project allows to manage user.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

sts tool suite
Java 8
Google chrome
MongoDb


### Installing

the steps will be :  


```
- Download MongoDB from the official website : https://www.mongodb.com/download-center#atlas
- open mongoDb  from file bin/mongo.exe 
   * Create User :
   db.createUser(
    {
     user: "sa",
     pwd: "123",
     roles: [ "readWrite", "dbAdmin" ]
    }
   )

   * Create DB testTechnique:
   use testTechnique

   * Create collection 
   db.createcollection('users');

   *  
- Open the project in eclipse from the folder TestTechnique
- Do update maven to get all dependencies
- Run As the project with Spring  Boot App
```


## Running the tests

use Junit to run test.

Be careful to put the right id because is generated automatically.

## Built With

* [Spring Boot App](https://spring.io/guides/gs/spring-boot/) - Framework Java
* [Maven](https://maven.apache.org/) - Dependency Management


## Authors

* **BOUHLEL Hichem** .

