# Welcome to Dunimed! 

This is a very simple system which aims to create several API's using SpringBoot and execute some business logic related to healthcare system. 

## Technologies

Programming Languages:
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)


Frameworks:
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)

Services: 
![RabbitMQ](https://img.shields.io/badge/Rabbitmq-FF6600?style=for-the-badge&logo=rabbitmq&logoColor=white)

Databases:
![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white)

Infrastructure:
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)


Other tools:
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
Lombok



## System Overview

This system manage four entitities: 

1. customers
2. products
3. orders
4. address
5. deliveries

These entities are composed by the following attributes:

![image](https://user-images.githubusercontent.com/13739735/197055067-3f5a8b74-067d-409a-b9d4-a91718efe721.png)


## ⚙️ Development

This system is currently under construction and will be developed iteratively following X sprints that are described as it follows:

### Sprint 01 - API building

In this sprint, OrderSys will be configured as a maven project using start.spring.io using the following dependencies:

1. Spring Data JPA
2. Spring Boot DevTools
3. H2 Database
4. Spring for RabbitMQ
5. Lombok

Next, the following endpoints should be created:

#### For Customers
- GET - localhost:9000/cliente/lista - List all stored clients
- GET - localhost:9000/cliente/{id} - Display client with such id
- POST - localhost:9000/cliente/ - Add a client
- PUT - localhost:9000/cliente/ - Update or add a client
- DELETE - localhost:9000/cliente/{id} - delete client with such id

#### For Products
- GET - localhost:9000/produto/lista - List all stored products
- GET - localhost:9000/produto/{id} - Display product with such id
- POST - localhost:9000/produto/ - Add a product
- PUT - localhost:9000/produto/ - Update or add a product
- DELETE - localhost:9000/produto/{id} - delete product with such id

#### For Orders
- GET - localhost:9000/pedido/list - List all stored orders
- GET - localhost:9000/pedido/{id} - Display order with such id
- POST - localhost:9000/pedido/ - Add a order
- PUT - localhost:9000/pedido/ - Update or add a order

#### For Deliveries
- GET - localhost:9000/entrega/lista - List all stored deliveries
- GET - localhost:9000/entrega/{id} - Display delivery with such id


For testing these end points, use the following payloads:

Client: 
```json
{
  "idClient": 0,
  "clientName": "Name Client"
}
```


Product: 
```json
{
  "idProduct": 0,
  "productName": "Name Product",
  "productValue": "10.00"
}
```

Order: 
```json
{
    "client": {
        "id": 1,
        "name": "Vinição dos compíuter"
    },
    "products": [
        {
            "id": 1,
            "name": "Casa de papel",
            "value": 10.0
        }
    ],
    "address": {
        "street": "Serafim vieira dos santos",
        "stablishmentNumber": 777,
        "neighborhood": "Primavera 7",
        "complement": "Apto 22",
        "zipCode": "35825-000"
    }
}
```

Deliveries: 
```json
{
    "status": "Entregue",
    "deliveredIn": "1990-10-22",
    "receiver": "Vanessa",
    "idOrder": 1
}
```

### Sprint 02 - RabbitMQ integration

In this step, the RabbitMQ should be used to add and consume a queue.

⚠️ this feature will be detailed soon


### Sprint 03 - Docker

In this step, a docker container should be created to run the application.

⚠️ this feature will be detailed soon

