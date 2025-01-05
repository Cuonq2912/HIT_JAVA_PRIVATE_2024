package org.example.service.Impl;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import org.example.model.Category;
import org.example.model.EntityManagerUtil;
import org.example.model.Product;
import org.example.service.EntityService;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class IProductServiceImpl implements EntityService<Product> {
    Scanner sn = new Scanner(System.in);
    EntityManager entityManager = EntityManagerUtil.getEntityManager();

    @Override
    public void add(Product product) {
        entityManager.getTransaction().begin();
        System.out.println("Enter product name(press enter to skip): ");
        String name = sn.nextLine();
        if (!name.isEmpty()) {
            product.setName(name);
        }

        System.out.println("Enter product price(Press -1 to skip): ");
        double price = sn.nextDouble();
        sn.nextLine();
        if (price != -1) {
            product.setPrice(price);
        }

        System.out.println("Enter product description(Press enter to skip): ");
        String description = sn.nextLine();
        if (!description.isEmpty()) {
            product.setDescription(description);
        }

        System.out.println("Enter product quantity(Press -1 to skip): ");
        int quantity = sn.nextInt();
        sn.nextLine();
        if (quantity != -1) {
            product.setQuantity(quantity);
        }

        System.out.println("Enter product category(Press enter to skip): ");
        Category category = entityManager.find(Category.class, UUID.fromString(sn.nextLine()));
        if (!category.equals(null)) {
            product.setCategory(category);
        }
        try {
            entityManager.persist(product);
        } catch (EntityExistsException e) {
            e.printStackTrace();
        }

        entityManager.getTransaction().commit();
        System.out.println("Product add successfully.");
    }

    @Override
    public boolean delete(UUID id) {
        try {
            entityManager.getTransaction().begin();
            Product product = entityManager.find(Product.class, id);
            if (product != null) {
                System.out.println("Are you sure you want to delete this product? (Y/N)");
                String choice = sn.nextLine();
                if (choice.equalsIgnoreCase("Y")) {
                    entityManager.remove(product);
                    entityManager.getTransaction().commit();
                    return true;
                } else {
                    System.out.println("Product not found with ID: " + id);

                }
            }
            entityManager.getTransaction().commit();
            return false;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("Error while deleting product: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(UUID id) {
        entityManager.getTransaction().begin();
        Product product = entityManager.find(Product.class, id);
        if (product != null) {
            System.out.println("Enter new name (press Enter to skip): ");
            String name = sn.nextLine();
            if (!name.isEmpty()) {
                product.setName(name);
            }

            System.out.println("Enter new price (enter -1 to skip): ");
            double price = sn.nextDouble();
            sn.nextLine(); // consume newline
            if (price != -1) {
                product.setPrice(price);
            }

            System.out.println("Enter new description (press Enter to skip): ");
            String description = sn.nextLine();
            if (!description.isEmpty()) {
                product.setDescription(description);
            }

            System.out.println("Enter new quantity (enter -1 to skip): ");
            int quantity = sn.nextInt();
            sn.nextLine(); // consume newline
            if (quantity != -1) {
                product.setQuantity(quantity);
            }

            entityManager.merge(product);
            entityManager.getTransaction().commit();
            return true;
        }
        entityManager.getTransaction().rollback();
        return false;
    }
    @Override
    public boolean findWithName(String name) {
        try {
            entityManager.getTransaction().begin();
            TypedQuery<Product> query = entityManager
                    .createQuery("SELECT p FROM Product p WHERE LOWER(p.name) like LOWER(:name)", Product.class);
            query.setParameter("name", "%" + name + "%");
            List<Product> productList = query.getResultList();

            if (productList.isEmpty()) {
                System.out.println("No product found with name: " + name);
                entityManager.getTransaction().rollback();
                return false;
            }
            System.out.printf("%-20s%-50s-20s%-50s%-10s%-20s\n",
                    "id", "name", "price", "description", "quantity", "category name");
            System.out.println("=========================================================================================");
            for (Product product : productList) {
                System.out.printf("%-20s%-50s-20s%-50s%-10s%-20s\n",
                        product.getId(), product.getName(), product.getPrice(), product.getDescription(),
                        product.getQuantity(), product.getCategory().getName());
                return true;
            }
        } catch (EntityExistsException e) {
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public void display(){
    }
}
