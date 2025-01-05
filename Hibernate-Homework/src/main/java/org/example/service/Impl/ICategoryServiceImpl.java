package org.example.service.Impl;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.TypedQuery;

import org.example.model.Category;
import org.example.model.EntityManagerUtil;
import org.example.service.EntityService;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import jakarta.persistence.EntityManager;

public class ICategoryServiceImpl implements EntityService<Category> {
    Scanner sn = new Scanner(System.in);
    EntityManager entityManager = EntityManagerUtil.getEntityManager();

    @Override
    public void add(Category category) {
        try {
            entityManager.getTransaction().begin();
            category = newCategory();
            entityManager.persist(category);
            entityManager.getTransaction().commit();
            System.out.println("Category added successfully.");
        } catch (EntityExistsException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean update(UUID id) {
        try {
            entityManager.getTransaction().begin();
            Category category = entityManager.find(Category.class, id);
            if (category != null) {
                System.out.println("Current name: " + category.getName());
                System.out.println("Enter new name (press Enter to skip): ");
                String name = sn.nextLine();
                if (!name.isEmpty()) {
                    category.setName(name);
                }

                System.out.println("Current description: " + category.getDescription());
                System.out.println("Enter new description (press Enter to skip): ");
                String description = sn.nextLine();
                if (!description.isEmpty()) {
                    category.setDescription(description);
                }

                entityManager.merge(category);
                entityManager.getTransaction().commit();
                System.out.println("Category updated successfully!");
                return true;
            }
            System.out.println("Category not found!");
            entityManager.getTransaction().rollback();
            return false;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("Error updating category: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(UUID id) {
        try {
            entityManager.getTransaction().begin();
            Category category = entityManager.find(Category.class, id);
            if (category != null) {
                System.out.println("Are you sure you want to delete category: " + category.getName() + "? (y/n)");
                String confirm = sn.nextLine();
                if (confirm.equalsIgnoreCase("y")) {
                    entityManager.remove(category);
                    entityManager.getTransaction().commit();
                    System.out.println("Category deleted successfully!");
                    return true;
                }
            }
            System.out.println("Category not found or deletion cancelled!");
            entityManager.getTransaction().rollback();
            return false;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("Error deleting category: " + e.getMessage());
            return false;
        }
    }
    @Override
    public void display() {
        TypedQuery<Category> query = entityManager.createQuery("SELECT c FROM Category c", Category.class);
        List<Category> categories = query.getResultList();
        if (categories.isEmpty()) {
            System.out.println("No categories found.");
            return;
        }
        System.out.printf("%-20s%-50s%-50s\n", "id", "name", "description");
        System.out.println("===========================================================================================");
        for (Category category : categories) {
            System.out.printf("%-20s%-50s%-50s\n", category.getId(), category.getName(), category.getDescription());
        }
    }

    @Override
    public boolean findWithName(String name){
        System.out.println("We don't support this feature");
        return true;
    }

    private Category newCategory() {
        System.out.println("Enter name: ");
        String name = sn.nextLine();
        while (name.isEmpty()) {
            System.out.println("Name cannot be empty. Please enter again: ");
            name = sn.nextLine();
        }
        System.out.println("Enter description: ");
        String description = sn.nextLine();
        return new Category(name, description);
    }
}
