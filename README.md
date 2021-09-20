# DESARROLLO-DE-SOFTWARE_GRUPO3

## Consideraciones Técnicas

2. Mysql
3. Spring-boot  
   * JPA
   * Patron Repository
   * MVC
   * Thymeleaf
5. Tomcat 9 

## Preparacion de la base de datos

1. Cree una base de datos llamada tiendaDB
2. en el proyecto ubiquese en la ruta  tienda\src\main\resources y abra el archivo application.properties
3. modifique la cadena de conexion de acuerdo a los siguientes datos:

~~~
  spring.datasource.url=jdbc:mysql://localhost:3306/tiendaDB
  spring.datasource.username=root
  spring.datasource.password=root308/*
~~~

## correr el proyecto en desarrollo

1. verifique que tenga java11 instalado
1. ubiquese en la raiz del proyecto
2. abra una terminal de acuerdo a su sistema operativo y corra el siguiente comando

linux o Mac

~~~
  ./mvnw spring-boot:run
~~~


Windows

~~~
  mvnw spring-boot:run
~~~

### visualizar el proyecto

1. abra un navegador y coloque la ruta http://localhost:8082/login
2. inicie sesion con los siguientes datos
   usuario: admininicial
   contraseña: admin123456


