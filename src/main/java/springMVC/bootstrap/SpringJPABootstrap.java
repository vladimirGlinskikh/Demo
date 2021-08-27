package springMVC.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import springMVC.domain.Customer;
import springMVC.domain.Product;
import springMVC.services.CustomerService;
import springMVC.services.ProductService;

import java.math.BigDecimal;

@Component
public class SpringJPABootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private ProductService productService;
    private CustomerService customerService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadProducts();
        loadCustomers();
    }

    public void loadCustomers() {
        Customer customer1 = new Customer();
        customer1.setFirstName("Vladimir");
        customer1.setLastName("Glinskikh");
        customer1.setAddressLine1("1 Main St");
        customer1.setCity("Kostanay");
        customer1.setState("Kostanay");
        customer1.setZipCode("555111");
        customer1.setEmail("vladimir.v.glinskikh@gmail.com");
        customer1.setPhoneNumber("+77019321740");
        customerService.saveOrUpdate(customer1);

        Customer customer2 = new Customer();
        customer2.setFirstName("Vasiliy");
        customer2.setLastName("Tkachuk");
        customer2.setAddressLine1("2 Main St");
        customer2.setCity("Kostanay");
        customer2.setState("Kostanay");
        customer2.setZipCode("555111");
        customer2.setEmail("vasiliy@gmail.com");
        customer2.setPhoneNumber("+77019824367");
        customerService.saveOrUpdate(customer2);

        Customer customer3 = new Customer();
        customer3.setFirstName("Andrey");
        customer3.setLastName("Shatalov");
        customer3.setAddressLine1("3 Main St");
        customer3.setCity("Kostanay");
        customer3.setState("Kostanay");
        customer3.setZipCode("555111");
        customer3.setEmail("andry.shatalov@gmail.com");
        customer3.setPhoneNumber("+77018923456");
        customerService.saveOrUpdate(customer3);

        Customer customer4 = new Customer();
        customer4.setFirstName("Lubov");
        customer4.setLastName("Kim");
        customer4.setAddressLine1("4 Main St");
        customer4.setCity("Kostanay");
        customer4.setState("Kostanay");
        customer4.setZipCode("555111");
        customer4.setEmail("lubov.kim@gmail.com");
        customer4.setPhoneNumber("+77016783456");
        customerService.saveOrUpdate(customer4);

        Customer customer5 = new Customer();
        customer5.setFirstName("Ruslan");
        customer5.setLastName("Niasbaev");
        customer5.setAddressLine1("5 Main St");
        customer5.setCity("Kostanay");
        customer5.setState("Kostanay");
        customer5.setZipCode("555111");
        customer5.setEmail("ruslan.niasbaev@gmail.com");
        customer5.setPhoneNumber("+77019872315");
        customerService.saveOrUpdate(customer5);
    }

    public void loadProducts() {
        Product product1 = new Product();
        product1.setDescription("Product 1");
        product1.setPrice(new BigDecimal("14.88"));
        product1.setImageUrl("http://example.com/product1");
        productService.saveOrUpdate(product1);

        Product product2 = new Product();
        product2.setDescription("Product 2");
        product2.setPrice(new BigDecimal("12.68"));
        product2.setImageUrl("http://example.com/product2");
        productService.saveOrUpdate(product2);

        Product product3 = new Product();
        product3.setDescription("Product 3");
        product3.setPrice(new BigDecimal("23.87"));
        product3.setImageUrl("http://example.com/product3");
        productService.saveOrUpdate(product3);

        Product product4 = new Product();
        product4.setDescription("Product 4");
        product4.setPrice(new BigDecimal("144.23"));
        product4.setImageUrl("http://example.com/product4");
        productService.saveOrUpdate(product4);

        Product product5 = new Product();
        product5.setDescription("Product 5");
        product5.setPrice(new BigDecimal("64.79"));
        product5.setImageUrl("http://example.com/product5");
        productService.saveOrUpdate(product5);
    }
}
