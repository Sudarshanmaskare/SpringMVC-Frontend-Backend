package ProductCrudapp.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pId;
    private String name;
    private String description;
    private int price;

    public Product() {
    }

    public Product(int pId, String name, String description, int price) {
        this.pId = pId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getPId() {
        return this.pId;
    }

    public void setPId(int pId) {
        this.pId = pId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product pId(int pId) {
        setPId(pId);
        return this;
    }

    public Product name(String name) {
        setName(name);
        return this;
    }

    public Product description(String description) {
        setDescription(description);
        return this;
    }

    public Product price(int price) {
        setPrice(price);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Product)) {
            return false;
        }
        Product product = (Product) o;
        return pId == product.pId && Objects.equals(name, product.name)
                && Objects.equals(description, product.description) && price == product.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pId, name, description, price);
    }

    @Override
    public String toString() {
        return "{" +
                " pId='" + getPId() + "'" +
                ", name='" + getName() + "'" +
                ", description='" + getDescription() + "'" +
                ", price='" + getPrice() + "'" +
                "}";
    }

}