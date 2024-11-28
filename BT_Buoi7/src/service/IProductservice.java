package service;

import model.Product;

public interface IProductservice {
    public boolean addProduct(Product product);
    public boolean deleteProduct(String id);
    public boolean updateProduct(String id);
    public boolean display();
    public boolean findWithNameProduct(String name);
}
