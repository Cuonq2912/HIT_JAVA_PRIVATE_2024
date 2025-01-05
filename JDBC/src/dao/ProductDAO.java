package dao;

import db.DbConnect;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductDAO {
    private Scanner sn = new Scanner(System.in);
    private Connection connection;

    public ProductDAO() {
        initializeConnection();
    }

    private void initializeConnection() {
        try {
            connection = DbConnect.getConnection();
            if (connection == null) {
                throw new SQLException("Failed to establish connection");
            }
            // Test connection with a simple query
            try (Statement stmt = connection.createStatement()) {
                stmt.execute("SELECT 1");
            }
            } catch (SQLException e) {
                System.err.println("Connection Error: " + e.getMessage());
                e.printStackTrace();
                System.exit(1);
            }
    }

    public void insertProduct() throws SQLException {
        System.out.println("====INSERT=====");
        System.out.println("Input name: ");
        String name = sn.nextLine();
        System.out.println("Input price: ");
        String price = sn.nextLine();
        System.out.println("Input category id: ");
        String categoryId = sn.nextLine();

        String query = "INSERT INTO Product (name, price, category_id) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, price);
            stmt.setString(3, categoryId);
            int result = stmt.executeUpdate();
            System.out.println(result > 0 ? "Insert successfully" : "Insert unsuccessfully");
        }
    }

    public void updateProduct() throws SQLException, RuntimeException {
        System.out.println("===UPDATE===");
        System.out.println("Enter the id of the product you want to update: ");
        String id = sn.nextLine();

        System.out.println("Input new name: ");
        String new_name = sn.nextLine();
        System.out.println("Input new price: ");
        String new_price = sn.nextLine();
        System.out.println("Input new category id: ");
        String new_categoryId = sn.nextLine();

        String query = "UPDATE Product SET name = ?, price = ?, category_id = ?, WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, new_name);
            stmt.setString(2, new_price);
            stmt.setString(3, new_categoryId);
            int result = stmt.executeUpdate();
            System.out.println(result > 0 ? "Update successfully" : "Update successfully");
        }
    }

    public void deleteProduct() throws SQLException {
        System.out.println("===DELETE===");
        System.out.println("Enter the id of the product you want to delete ");
        String id = sn.nextLine();

        String query = "DELETE FROM Product WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, id);
            int result = stmt.executeUpdate();
            System.out.println(result > 0 ? "Delete successfully" : "Delete unsuccessfully");
        }
    }

    public ArrayList<Product> viewAllProducts() throws SQLException {
        System.out.println("===LIST OF PRODUCT===");
        ArrayList<Product> products = new ArrayList<>();
        String query = "SELECT * FROM Product";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                products.add(new Product(rs.getString("id"), rs.getString("name"), rs.getString("price"), rs.getString("category_id")));
            }
        }
        return products;
    }

    public Product getById() throws SQLException {
        System.out.println("===GET PRODUCT BY ID===");
        System.out.println("Enter id of the product you want to view: ");
        String id = sn.nextLine();
        String query = "SELECT * FROM Product WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Product(rs.getString("id"), rs.getString("name"), rs.getString("price"),
                            rs.getString("category_id"));
                }
            }
        }
        return null;
    }
}

// Search & Filter Operations:
// Search by multiple criteria
// Full-text search
// Filter by date range
// Advanced filtering

// Data Analytics:
// Count/Sum/Average calculations
// Group by operations
// Statistical analysis

// Batch Operations:
// Bulk insert
// Batch update
// Transaction management

// Data Export/Import:
// Export to CSV/Excel
// Import from files
// Data migration

// Advanced Search
// private static void searchProductsByMultipleCriteria() throws SQLException {
// String query = "SELECT * FROM Product WHERE price BETWEEN ? AND ? AND
// category_id = ? AND name LIKE ?";
// try (PreparedStatement stmt = connection.prepareStatement(query)) {
// stmt.setDouble(1, minPrice);
// stmt.setDouble(2, maxPrice);
// stmt.setInt(3, categoryId);
// stmt.setString(4, "%" + searchTerm + "%");
// // ...execute and process results
// }
// }
//
//// Analytics Example
// private static void getProductStats() throws SQLException {
// String query = "SELECT category_id, COUNT(*) as count, AVG(price) as
// avg_price, MAX(price) as max_price " +
// "FROM Product GROUP BY category_id";
// try (Statement stmt = connection.createStatement();
// ResultSet rs = stmt.executeQuery(query)) {
//// ...process statistics
// }
// }
//
//// Batch Insert Example
// private static void batchInsertProducts(List<Product> products) throws
// SQLException {
// String query = "INSERT INTO Product (name, price, category_id) VALUES (?, ?,
// ?)";
// connection.setAutoCommit(false);
// try (PreparedStatement stmt = connection.prepareStatement(query)) {
// for (Product product : products) {
// stmt.setString(1, product.getName());
// stmt.setDouble(2, product.getPrice());
// stmt.setInt(3, product.getCategoryId());
// stmt.addBatch();
// }
// stmt.executeBatch();
// connection.commit();
// } catch (SQLException e) {
// connection.rollback();
// throw e;
// }
// }

// Export to CSV Example
// private static void exportProductsToCSV(String filename) throws SQLException
// {
// String query = "SELECT * FROM Product";
// try (Statement stmt = connection.createStatement();
// ResultSet rs = stmt.executeQuery(query);
// FileWriter fw = new FileWriter(filename)) {
// // Write headers
// fw.append("ID,Name,Price,Category\n");
// // Write data
// while (rs.next()) {
// fw.append(String.format("%s,%s,%s,%s\n",
// rs.getString("id"),
// rs.getString("name"),
// rs.getString("price"),
// rs.getString("category_id")));
// }
// }
// }