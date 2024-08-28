package top.anyel.consumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import top.anyel.consumer.model.Message;
import top.anyel.consumer.services.MessageService;

@Slf4j
@Component
public class Consumer {
    @Autowired
    private MessageService messageService;
    @RabbitListener(queues = "queue.A")
    private void receive(Message message){

        log.info("Message received from QUEUE.A ->{}", message);
        messageService.saveMessage(message);
    }

    @RabbitListener(queues = "queue.B")
    private void receiveFromB(Message message){

        log.info("Message received from QUEUE.B ->{}", message);
        messageService.saveMessage(message);
    }



}