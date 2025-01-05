package org.example.service;

import java.util.UUID;

public interface EntityService<T> {
    void add(T entity);
    boolean delete(UUID id);
    boolean update(UUID id);
    void display();
    boolean findWithName(String name);
}
