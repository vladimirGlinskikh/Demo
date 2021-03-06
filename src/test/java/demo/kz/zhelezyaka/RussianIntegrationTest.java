package demo.kz.zhelezyaka;

import demo.kz.zhelezyaka.services.HelloSpringServiceRussianImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/hello-spring.xml"})
public class RussianIntegrationTest {

    @Autowired
    HelloSpringServiceRussianImpl helloSpringServiceRussian;

    @Test
    public void testHelloSpring() {
        String greeting = helloSpringServiceRussian.getGreeting();
        assertEquals("Привет Спринг!", greeting);
    }
}
