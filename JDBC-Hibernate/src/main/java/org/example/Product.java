package org.example;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
        @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(columnDefinition = "varchar(60)", nullable = false)
    private String name;
    @Column(columnDefinition = "string default(0)", nullable = false)
    private double price;
    @Column(columnDefinition ="double default(0)", nullable = false)

    @ManyToOne
        @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public Product() {
    }

    public Product(String id, String name, double price, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
