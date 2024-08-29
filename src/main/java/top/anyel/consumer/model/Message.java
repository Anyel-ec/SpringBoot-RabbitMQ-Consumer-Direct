package top.anyel.consumer.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.annotation.Collation;

@Data
@Collation
public class Message {
    // atributos
    @Id
    private int id;
    private String name;

    private String lastName;
    private String email;
    private String phone;
    private Double noteFinal;
}
