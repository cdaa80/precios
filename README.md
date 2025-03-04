# Api Consulta Precio

## Descripción General

Esta api permite recuperar el precio de un producto por medio de los siguientes parametros fecha y hora, id del producto y id de la cadena (Zara).



## Tecnologia utilizada

* Maven
* Java 17
* Spring Boot 3
* Flyway
* Base de datos H2

## Estructura de la Aplicación 

Implementación basada en una arquitectura hexagonal

```
> src
    > java
        > com.ecommerce.precios
            > application
                > dto
                > service
            > domain
                > model
                > repository
            > infrastructure
                > controller
                > exception
            > shared 
    > resources
        > db
        application.yml
            
            
```
