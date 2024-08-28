package top.anyel.consumer.model;

import lombok.Data;

@Data
public class Message {
    // atributos
    private int id;
    private String name;

    private String lastName;
    private String email;
    private String phone;
    private Double noteFinal;
}
