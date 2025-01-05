package model;

public class Product {
    protected String id;
    protected String name;
    protected String price;
    protected String categoryId;

    public Product() {
    }

    public Product(String id, String name, String categoryId, String price) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.price = price;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", categoryId='" + categoryId + '\'' +
                '}';
    }
}
