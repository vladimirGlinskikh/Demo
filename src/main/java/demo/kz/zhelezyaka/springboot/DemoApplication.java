package demo.kz.zhelezyaka.springboot;

import demo.kz.zhelezyaka.controllers.GreetingController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("demo.kz.zhelezyaka")
public class DemoApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        GreetingController controller = (GreetingController) context.getBean("greetingController");
        controller.sayHello();
    }
}
