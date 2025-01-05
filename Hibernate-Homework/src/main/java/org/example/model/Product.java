package org.example.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;
    @Column(nullable = false, columnDefinition = "varchar(40)")
    private String name;
    @Column(nullable = false, columnDefinition = "Decimal(10, 2)")
    private double price;
    @Column(columnDefinition = "text")
    private String description;
    @Column(columnDefinition = "int")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public Product() {
    }

    public Product(UUID id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Product(String name, double price, String description, int quantity) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }

    public Product(UUID id, String name, String description, double price, int quantity, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
