package top.anyel.consumer.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import top.anyel.consumer.model.Message;

public interface MessageRepository extends MongoRepository<Message, Integer> {
}