package org.example.Controller;

import org.example.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import static org.example.JDBC.JDBCConnector.getConnection;

public class ProductDAO {
    static Scanner sn = new Scanner(System.in);
    static Connection connection;
    public ProductDAO(){
        try{
            connection = getConnection();
            if (connection == null) {
                throw new SQLException("Failed");
            }
        }  catch (SQLException e) {
            System.err.println("Connection Error: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void addProduct() throws SQLException {
        System.out.println("====INSERT=====");
        System.out.println("Input name: ");
        String name = sn.nextLine();
        System.out.println("Input price: ");
        int price = sn.nextInt();
        System.out.println("Input category id: ");
        int categoryId = sn.nextInt();

        String query = "INSERT INTO Product(name, price, category_id) VALUES (?, ?, ?)";
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1, name);
            stmt.setInt(2, price);
            stmt.setInt(3, categoryId);
            int result = stmt.executeUpdate();
            System.out.println(result > 0 ? "Add successfully" : "Add unsuccessfully");
        }
    }

    public static boolean updateProduct() throws SQLException {
        System.out.println("Enter id:");
        int id = sn.nextInt();
        sn.nextLine();
        System.out.println("Input new name: ");
        String new_name = sn.nextLine();
        System.out.println("Input new price: ");
        int new_price = sn.nextInt();
        System.out.println("Input new category id: ");
        int new_categoryId = sn.nextInt();

        String query = "UPDATE Product SET name = ?, price = ?, category_id = ?, WHERE id = ?";
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1, new_name);
            stmt.setInt(2, new_price);
            stmt.setInt(3, new_categoryId);
            stmt.setInt(4, id);
            int result = stmt.executeUpdate();
            if(result > 0) return true;
        }
        return false;
    }

    public static void deleteProduct() throws SQLException {
        System.out.println("Enter id of product want to delete");
        int id = sn.nextInt();
        String query = "DELETE FROM Product WHERE id = ?";
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, id);
            int result = stmt.executeUpdate();
            System.out.println(result > 0 ? "Delete successfully" : "Delete unsuccessfully");
        }
    }

    public static Product getById() throws SQLException {
        System.out.println("Enter id of product you want to get:");
        int id = sn.nextInt();
        String query = "SELECT * FROM Product WHERE id = ?";
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    return new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("price"), rs.getInt("category_id"));
                }
            }
        } catch (NullPointerException e){
            throw new NullPointerException();
        }
        return null;
    }

    public ArrayList<Product> getAllProduct() throws SQLException {
        System.out.println("List of product");
        ArrayList<Product> products = new ArrayList<>();
        String query = "SELECT * FROM Product";
        try(Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query)){
                while(rs.next()){
                    products.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("price"), rs.getInt("category_id")));
                }
        }
        return products;
    }
}
