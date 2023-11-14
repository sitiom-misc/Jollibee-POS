package com.example.entjava2me3.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String item;
    private int quantity;
    private double price;
    private boolean isPending;
    public Order(String name, String item, int quantity, double price) {
        this.name = name;
        this.item = item;
        this.quantity = quantity;
        this.price = price;
        this.isPending = true;
    }
}
