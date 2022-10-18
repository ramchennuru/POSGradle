package com.POSSystemGradle.POSSytemGradle.Product;


import com.POSSystemGradle.POSSytemGradle.Price.Price;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="product")
public class ProductModel {
    @Id
    private long id;
    private long price;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    private Price priceTable;

    public ProductModel(long id, long price, String name, Price priceTable) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.priceTable = priceTable;
    }

    public ProductModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Price getPriceTable() {
        return priceTable;
    }

    public void setPriceTable(Price priceTable) {
        this.priceTable = priceTable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductModel product = (ProductModel) o;
        return id == product.id && price == product.price && Objects.equals(name, product.name) && Objects.equals(priceTable, product.priceTable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, name, priceTable);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", priceTable=" + priceTable +
                '}';
    }
}
