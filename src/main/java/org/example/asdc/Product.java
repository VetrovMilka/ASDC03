package org.example.asdc;

public class Product implements Comparable<Product>{
    private Integer id;
    private String name;
    private String description;
    private Integer price;
    private Integer pieces;
    private String unitOfMeasurement;


    public Product(Integer id, String name,
                   String description, Integer price,
                   Integer pieces, String unitOfMeasurement) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.pieces = pieces;
        this.unitOfMeasurement = unitOfMeasurement;
    }
    public Product(Product product) {
        this.id = product.id;
        this.name = product.name;
        this.description = product.description;
        this.price = product.price;
        this.pieces = product.pieces;
        this.unitOfMeasurement = product.unitOfMeasurement;
    }

    public static Product create(Integer id, String name,
                                 String description, Integer price,
                                 Integer pieces, String unitOfMeasurement){
        return new Product(id, name, description, price, pieces, unitOfMeasurement);
    }


    public Product copy(){
        return new Product(this);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getPieces() {
        return pieces;
    }

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;

        if (!getId().equals(product.getId())) return false;
        if (getName() != null ? !getName().equals(product.getName()) : product.getName() != null) return false;
        if (getDescription() != null ? !getDescription().equals(product.getDescription()) : product.getDescription() != null)
            return false;
        if (getPrice() != null ? !getPrice().equals(product.getPrice()) : product.getPrice() != null) return false;
        if (getPieces() != null ? !getPieces().equals(product.getPieces()) : product.getPieces() != null) return false;
        return getUnitOfMeasurement() != null ? getUnitOfMeasurement().equals(product.getUnitOfMeasurement()) : product.getUnitOfMeasurement() == null;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
        result = 31 * result + (getPieces() != null ? getPieces().hashCode() : 0);
        result = 31 * result + (getUnitOfMeasurement() != null ? getUnitOfMeasurement().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return
                id +
                ";" + name +
                ";" + description +
                ";" + price +
                ";" + pieces +
                ";" + unitOfMeasurement;
    }

    @Override
    public int compareTo(Product o) {
        return this.getId() - o.getId();
    }
}

