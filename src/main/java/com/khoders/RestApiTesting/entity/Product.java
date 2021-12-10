package com.khoders.RestApiTesting.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@Getter
@Setter
@ToString
public class Product {
    @Id
    private Long id;
    private String name;
    private int quantity;
    private double price;

}
