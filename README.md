# SpringBoot-RabbitMQ-Consumer-Direct

This project is an example of a Spring Boot application that uses RabbitMQ for message processing via a `Direct Exchange`.

## Requirements

- Java 17 or higher
- Spring Boot 3.3.3
- RabbitMQ 3.8.x or higher

## Project Configuration

### Main Dependencies

The project uses the following main dependencies:

- `spring-boot-starter-amqp`: For working with RabbitMQ.
- `spring-boot-starter-web`: To expose endpoints and other web functionalities.
- `lombok`: To simplify the code by removing boilerplate.
- `spring-boot-devtools`: Development tools like auto-restart.
- `spring-boot-starter-test`: For unit testing.

### RabbitMQ Configuration

The RabbitMQ connection properties are defined in the `application.properties` file:

```properties
spring.application.name=SpringBoot-RabbitMQ-Consumer-Direct

# RabbitMQ connection
spring.rabbitmq.host=192.168.1.111
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest
```

### RabbitMQ Configuration (Class `RabbitMQConfigBinding`)

The `RabbitMQConfigBinding` class configures the queues, the exchange (`Direct Exchange`), and the bindings.

- **Queues:** Two queues `queue.A` and `queue.B` are defined.
- **Exchange:** A `Direct Exchange` named `exchange.direct` is defined.
- **Bindings:** The queues are associated with the routing keys `routing.A` and `routing.B` respectively.

### Message Consumer (Class `Consumer`)

The `Consumer` class is responsible for receiving messages from the configured queues:

- `receive(Message message)`: Receives messages from `queue.A`.
- `receiveFromB(Message message)`: Receives messages from `queue.B`.

### Message Model (Class `Message`)

The `Message` class represents the structure of the messages that will be sent and received by the RabbitMQ queues.

## Project Execution

1. Clone the repository.
2. Configure the connection properties in the `application.properties` file.
3. Ensure RabbitMQ is running.
4. Run the application with Maven:

   ```bash
   mvn spring-boot:run
   ```

## License

This project does not include a specific license.
