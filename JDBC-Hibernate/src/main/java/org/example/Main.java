package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        Scanner sn = new Scanner(System.in);
        while (true) {
            int choice = sn.nextInt();
            // INSERT
            if (choice == 1) {
                entityManager.getTransaction().begin();
                Category category = new Category("Điện tử");
                entityManager.merge(category);
                entityManager.getTransaction().commit();
            }
            // SELECT
            if(choice == 2){
                TypedQuery<Category> query = entityManager.createQuery(
                        "SELECT c FROM Category c WHERE c.name LIKE CONCAT('%', :name, '%') ",
                        Category.class);
                query.setParameter("name", "");
                List<Category> categories = query.getResultList();
                for(Category category : categories){
                    System.out.println(category.getName());
                }
            }
            //UPDATE
            if(choice == 3){
                sn.nextLine();
                System.out.println("Enter category: ");
                String cateforyId = sn.nextLine();
                Category category = entityManager.find(Category.class, cateforyId);
                if(category != null){
                    entityManager.getTransaction().begin();
                    System.out.println("Enter new name: ");
                    String newName = sn.nextLine();
                    category.setName(newName);
                    entityManager.merge(category);
                    entityManager.getTransaction().commit();
                }
            }

            //DELETE
            if(choice == 4){
                sn.nextLine();
                System.out.println("Enter id: ");
                String categoryId = sn.nextLine();
                Category category = entityManager.find(Category.class, categoryId);
                if(category != null){
//                    entityManager
                }
            }
        }
    }
}