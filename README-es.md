# SpringBoot-RabbitMQ-Consumer-Direct

Este proyecto es un ejemplo de una aplicación Spring Boot que utiliza RabbitMQ para el procesamiento de mensajes mediante un `Direct Exchange`.

## Requisitos

- Java 17 o superior
- Spring Boot 3.3.3
- RabbitMQ 3.8.x o superior

## Configuración del proyecto

### Dependencias principales

El proyecto utiliza las siguientes dependencias principales:

- `spring-boot-starter-amqp`: Para trabajar con RabbitMQ.
- `spring-boot-starter-web`: Para exponer endpoints y otras funcionalidades web.
- `lombok`: Para simplificar el código eliminando el boilerplate.
- `spring-boot-devtools`: Herramientas para desarrollo, como reinicio automático.
- `spring-boot-starter-test`: Para pruebas unitarias.

### Configuración de RabbitMQ

Las propiedades de conexión a RabbitMQ están definidas en el archivo `application.properties`:

```properties
spring.application.name=SpringBoot-RabbitMQ-Consumer-Direct

# RabbitMQ connection
spring.rabbitmq.host=192.168.1.111
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest
```

### Configuración de RabbitMQ (Clase `RabbitMQConfigBinding`)

La clase `RabbitMQConfigBinding` configura las colas, el intercambio (`Direct Exchange`), y las vinculaciones (`bindings`).

- **Colas:** Se definen dos colas `queue.A` y `queue.B`.
- **Exchange:** Se define un `Direct Exchange` con el nombre `exchange.direct`.
- **Bindings:** Se asocian las colas a las rutas `routing.A` y `routing.B` respectivamente.

### Consumidor de Mensajes (Clase `Consumer`)

La clase `Consumer` se encarga de recibir los mensajes de las colas configuradas:

- `receive(Message message)`: Recibe mensajes de la `queue.A`.
- `receiveFromB(Message message)`: Recibe mensajes de la `queue.B`.

### Modelo de Mensaje (Clase `Message`)

La clase `Message` representa la estructura de los mensajes que serán enviados y recibidos por las colas de RabbitMQ.

## Ejecución del Proyecto

1. Clona el repositorio.
2. Configura las propiedades de conexión en el archivo `application.properties`.
3. Asegúrate de tener RabbitMQ en ejecución.
4. Ejecuta la aplicación con Maven:

   ```bash
   mvn spring-boot:run
   ```

## Licencia

Este proyecto no incluye una licencia específica.


