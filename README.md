# Spring Boot with Debezium Example

>**This is an example of Spring Boot that pulls data generated by Insert / Update / Delete operations in Mysql via Debezium and kafka**
>
>**For about [Debezium](https://debezium.io)**
>
>**For Debezium [Documentation](https://debezium.io/documentation/reference/1.3/)**
## How Is It Work?

<p align="center">
<img src="https://github.com/NrktSLL/spring-boot-debezium-ex/blob/master/images/spring-boot-debezium-ex.png" alt="Spring Boot with Debezium Example" width="50%" height="50%"/> 
</p>

## Prerequisites

*  Docker 
*  Docker Compose

## Run Debezium with Mysql Connector
>*Start the following command via terminal, in project location;*

```
sh connector.sh
```


**This process will run the relevant containers, and   mysql-connector will connect to debezium. (You can examine connector.sh to see commands.)**


>**After this process,related Spring Boot project can be started.**

## Used Dependencies
* Spring Boot Web
* Spring Boot Data JPA
* Spring Boot Validation
* Spring Boot Actuator
* Spring Kafka
* Lombok
* Configuration Processor
* Mysql
* Jackson Databind
* Google Guava

## Resource;

* https://github.com/joumenharzli/spring-rdbms-cdc-kafka-elasticsearch
* https://github.com/debezium/debezium-examples
* https://github.com/debezium/docker-images
