package ProductCrudapp.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateOptimisticLockingFailureException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ProductCrudapp.model.Product;

@Component
public class ProductDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional
    public void createProduct(Product product) {
        this.hibernateTemplate.save(product);
    }

    @Transactional
    public void update_pro(Product product) {
        try {
            this.hibernateTemplate.merge(product);
        } catch (HibernateOptimisticLockingFailureException ex) {
            // Handle optimistic locking exception
            // You can log the exception, inform the user, or perform retry logic here
            // For example:
            System.out.println(ex);
        }
    }

    public List<Product> getAllProducts() {
        return this.hibernateTemplate.loadAll(Product.class);
    }

    @Transactional
    public void delete(int pId) {
        Product p = this.hibernateTemplate.load(Product.class, pId);
        this.hibernateTemplate.delete(p);
    }

    public Product getProduct(int pId) {
        return this.hibernateTemplate.get(Product.class, pId);
    }

}
