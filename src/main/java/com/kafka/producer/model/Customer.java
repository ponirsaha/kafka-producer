package com.kafka.producer.model;

import lombok.Data;

@Data
public class Customer {
    private String id;
    private String name;
    private String phone;
    private String email;
    private String address;
    private Integer age;
}
