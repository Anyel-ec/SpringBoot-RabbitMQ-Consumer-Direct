package top.anyel.consumer.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfigBinding {

    // definimos las colas y los routing keys
    public static final String QUEUE_A = "queue.A";
    public static final String QUEUE_B = "queue.B";
    public static final String ROUTING_A = "routing.A";
    public static final String ROUTING_B = "routing.B";

    // definimos los beans
    @Bean
    Queue queueA(){ // creamos la cola A
        return new Queue(QUEUE_A, false);
    }

    @Bean
    Queue queueB(){ // creamos la cola B
        return new Queue(QUEUE_B, false);
    }

    @Bean
    DirectExchange exchange(){ // creamos el exchange
        return new DirectExchange("exchange.direct");
    }

    // definimos los bindings para las colas y el exchange
    @Bean
    Binding binding(Queue queueA, DirectExchange exchange){
        return BindingBuilder.bind(queueA)
                .to(exchange)
                .with(ROUTING_A);
    }

    @Bean
    Binding bindingB(Queue queueB, DirectExchange exchange){
        return BindingBuilder.bind(queueB)
                .to(exchange)
                .with(ROUTING_B);
    }

    // el Converter nos ayuda a convertir los mensajes a JSON
    @Bean
    MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    // el RabbitTemplate nos ayuda a enviar mensajes
    @Bean
    RabbitTemplate rabbitTemplate(ConnectionFactory factory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(factory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}