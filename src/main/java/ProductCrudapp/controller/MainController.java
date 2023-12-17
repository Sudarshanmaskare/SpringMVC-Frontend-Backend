package ProductCrudapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import ProductCrudapp.Dao.ProductDao;
import ProductCrudapp.model.Product;

@Controller
public class MainController {

    @Autowired
    private ProductDao productDao;

    @RequestMapping("/")
    public String home(Model m) {
        List<Product> products = productDao.getAllProducts();
        m.addAttribute("products", products);
        return "index";
    }

    @RequestMapping("add-product")
    public String addProduct(Model m) {
        m.addAttribute("title", "Add Product");
        return "addProductForm";
    }

    @RequestMapping(value = "/handle-product", method = RequestMethod.POST)
    public RedirectView handleProduct(@ModelAttribute Product product, HttpServletRequest request) {
        RedirectView redirectView = new RedirectView();
        productDao.createProduct(product);
        System.out.println(product);
        redirectView.setUrl(request.getContextPath() + "/");
        return redirectView;
    }

    @RequestMapping(value = "/update-product", method = RequestMethod.POST)
    public RedirectView updateProduct(@ModelAttribute Product updatedProduct, HttpServletRequest request) {
        RedirectView redirectView = new RedirectView();
        System.out.println(updatedProduct);
        System.out.println(updatedProduct.getPId());
        Product existingProduct = productDao.getProduct(updatedProduct.getPId());

        // Update the existing product with the changes from the updatedProduct
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setDescription(updatedProduct.getDescription());
        existingProduct.setPrice(updatedProduct.getPrice());

        // Call the DAO method to update the product
        productDao.update_pro(existingProduct);
        System.out.println(existingProduct);
        redirectView.setUrl(request.getContextPath() + "/");
        return redirectView;
    }

    @RequestMapping("/delete/{productId}")
    public RedirectView deleteProduct(@PathVariable("productId") int productId, HttpServletRequest request) {
        RedirectView redirectView = new RedirectView();
        this.productDao.delete(productId);
        redirectView.setUrl(request.getContextPath() + "/");
        return redirectView;
    }

    @RequestMapping("/update/{productId}")
    public String updateForm(@PathVariable("productId") int pId, Model m) {
        Product product = this.productDao.getProduct(pId);
        m.addAttribute("product", product);
        return "updateForm";
    }

}
