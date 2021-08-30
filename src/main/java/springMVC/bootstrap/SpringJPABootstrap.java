package springMVC.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import springMVC.domain.Address;
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
        customer1.setBillingAddress(new Address());
        customer1.getBillingAddress().setAddressLine1("1 Main St");
        customer1.getBillingAddress().setCity("Kostanay");
        customer1.getBillingAddress().setState("Kostanay");
        customer1.getBillingAddress().setZipCode("555111");
        customer1.setEmail("vladimir.v.glinskikh@gmail.com");
        customer1.setPhoneNumber("+77019321740");
        customerService.saveOrUpdate(customer1);

        Customer customer2 = new Customer();
        customer2.setFirstName("Vasiliy");
        customer2.setLastName("Tkachuk");
        customer2.setBillingAddress(new Address());
        customer2.getBillingAddress().setCity("Kostanay");
        customer2.getBillingAddress().setState("Kostanay");
        customer2.getBillingAddress().setZipCode("555111");
        customer2.setEmail("vasiliy@gmail.com");
        customer2.setPhoneNumber("+77019824367");
        customerService.saveOrUpdate(customer2);

        Customer customer3 = new Customer();
        customer3.setFirstName("Andrey");
        customer3.setLastName("Shatalov");
        customer3.setBillingAddress(new Address());
        customer3.getBillingAddress().setCity("Kostanay");
        customer3.getBillingAddress().setState("Kostanay");
        customer3.getBillingAddress().setZipCode("555111");
        customer3.setEmail("andry.shatalov@gmail.com");
        customer3.setPhoneNumber("+77018923456");
        customerService.saveOrUpdate(customer3);

        Customer customer4 = new Customer();
        customer4.setFirstName("Lubov");
        customer4.setLastName("Kim");
        customer4.setBillingAddress(new Address());
        customer4.getBillingAddress().setCity("Kostanay");
        customer4.getBillingAddress().setState("Kostanay");
        customer4.getBillingAddress().setZipCode("555111");
        customer4.setEmail("lubov.kim@gmail.com");
        customer4.setPhoneNumber("+77016783456");
        customerService.saveOrUpdate(customer4);

        Customer customer5 = new Customer();
        customer5.setFirstName("Ruslan");
        customer5.setLastName("Niasbaev");
        customer5.setBillingAddress(new Address());
        customer5.getBillingAddress().setCity("Kostanay");
        customer5.getBillingAddress().setState("Kostanay");
        customer5.getBillingAddress().setZipCode("555111");
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
