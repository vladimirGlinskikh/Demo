package springMVC.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springMVC.config.JpaIntegrationConfig;
import springMVC.domain.*;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(JpaIntegrationConfig.class)
@ActiveProfiles("jpadao")
public class UserServiceJpaDaoImplTest {
    private UserService userService;
    private ProductService productService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Test
    public void testSaveOfUser() {
        User user = new User();

        user.setUsername("someUserName");
        user.setPassword("myPassword");

        User savedUser = userService.saveOrUpdate(user);

        assert savedUser.getId() != null;
        assert savedUser.getEncryptedPassword() != null;

        System.out.println("Encrypted Password");
        System.out.println(savedUser.getEncryptedPassword());
    }

    @Test
    public void testSaveOfUserWithCustomer() {
        User user = new User();

        user.setUsername("someUserName");
        user.setPassword("userPassword");

        Customer customer = new Customer();
        customer.setFirstName("Vladimir");
        customer.setLastName("Glinskikh");

        user.setCustomer(customer);
        User savedUser = userService.saveOrUpdate(user);

        assert savedUser.getId() != null;
        assert savedUser.getVersion() != null;
        assert savedUser.getCustomer() != null;
        assert savedUser.getCustomer().getId() != null;
    }

    @Test
    public void testAddCartToUser() {
        User user = new User();

        user.setUsername("someUserName");
        user.setPassword("userPassword");
        user.setCart(new Cart());

        User savedUser = userService.saveOrUpdate(user);

        assert savedUser.getId() != null;
        assert savedUser.getVersion() != null;
        assert savedUser.getCart() != null;
        assert savedUser.getCart().getId() != null;
    }

    @Test
    public void testAddCartToUserWithCartDetails() {
        User user = new User();

        user.setUsername("someUserName");
        user.setPassword("userPassword");
        user.setCart(new Cart());

        List<Product> storedProducts = (List<Product>) productService.listAll();

        CartDetail cartItemOne = new CartDetail();
        cartItemOne.setProduct(storedProducts.get(0));
        user.getCart().addCartDetail(cartItemOne);

        CartDetail cartItemTwo = new CartDetail();
        cartItemTwo.setProduct(storedProducts.get(1));
        user.getCart().addCartDetail(cartItemTwo);

        User savedUser = userService.saveOrUpdate(user);

        assert savedUser.getId() != null;
        assert savedUser.getVersion() != null;
        assert savedUser.getCart() != null;
        assert savedUser.getCart().getId() != null;
        assert savedUser.getCart().getCartDetails().size() == 2;
    }

    @Test
    public void testAddAndRemoveCartToUserWithCartDetails() {
        User user = new User();

        user.setUsername("someUserName");
        user.setPassword("userPassword");

        user.setCart(new Cart());

        List<Product> storedProducts = (List<Product>) productService.listAll();

        CartDetail cartItemOne = new CartDetail();
        cartItemOne.setProduct(storedProducts.get(0));
        user.getCart().addCartDetail(cartItemOne);

        CartDetail cartItemTwo = new CartDetail();
        cartItemTwo.setProduct(storedProducts.get(1));
        user.getCart().addCartDetail(cartItemTwo);

        User savedUser = userService.saveOrUpdate(user);

        assert savedUser.getCart().getCartDetails().size() == 2;

        savedUser.getCart().removeCartDetail(savedUser.getCart().getCartDetails().get(0));
        userService.saveOrUpdate(savedUser);
        assert savedUser.getCart().getCartDetails().size() == 1;
    }
}