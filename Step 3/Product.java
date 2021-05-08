public class Product implements Comparable<Product> {
    private String name;
    private String code;
    private Integer quantity = 0;

    public Product(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public Product(String name, String code, Integer quantity) {
        this.name = name;
        this.code = code;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }

    public Integer getQuantity() {
        return quantity;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", " +
            "Code: " + code + ", " +
            "Quantity in stock: " + quantity;
    }

    public int compareTo(Product comparedProduct) {
        return this.code.compareToIgnoreCase(comparedProduct.getCode());
    }
}
