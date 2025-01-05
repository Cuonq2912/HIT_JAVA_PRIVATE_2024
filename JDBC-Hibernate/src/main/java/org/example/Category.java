package org.example;


import jakarta.persistence.*;

@Entity
public class Category {
    @Id
        @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(columnDefinition = "varchar(100)", nullable = false)
    private String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(String id, String name) {
        this.id = id;
        this.name = name;
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
}
