# favorite-products-api

## Objective

Create "Users" and your "Favorite Products" and management between each

> To run a quick test, see the section [Quick Test](#quick-test). JRE21 and Docker Compose required

## Online Demo

~http://ec2-3-145-204-211.us-east-2.compute.amazonaws.com:9080/favorite-products-api/swagger-ui/index.html 🚀~ Not fully deployed yet

## OpenAPI / Swagger

http://localhost:9080/favorite-products-api/swagger-ui/index.html#/

>http://localhost:9080 is the base url for local dev

### Development

### Tools and etc

#### MapStruct

>MapStruct is a fast and ligthweight java mapping

Ths project is configured already

See on this [link](https://mapstruct.org/documentation/ide-support/) to view the support for your favorite IDE or click bellow:

 - [Eclipse](https://mapstruct.org/documentation/ide-support/#eclipse)
 - [IntelliJ IDEA](https://mapstruct.org/documentation/ide-support/#intellij-idea)

#### Environment

##### Dev

Set on your IDE

```
spring.profiles.active=dev

```

### Build & Deploy

#### Build

To create a runnable .jar, run this command

```bash
./gradlew clean build -x test
```

> ```-x test``` ignores the unit test phase


#### Deploy

> Remember: The enviroments variables in production generally are Infrastructure/DevOps responsability, but on some cases de Dev Team have ways to configuring (OpenShift, Azure Secrets, GitHub Secrets etc)

To run this app, first you needed the JRE 21.
Second: run this command

```bash
java -jar build/libs/favorite-products-api-1.0.0.jar --spring.profiles.active=dev
```

Where:

1. ```1.0.0``` is the version your application
2. ```--spring.profiles.active=dev``` is for choosing the enviroment configurations. Remove this for getting the default configuration (production)


##### Quick test

If you want a simple quick test, run the command:


```bash
./gradlew bootRun --args='--spring.profiles.active=dev'
```

