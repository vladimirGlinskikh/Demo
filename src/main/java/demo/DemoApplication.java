package demo;

import demo.kz.zhelezyaka.controllers.GreetingController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        GreetingController controller = (GreetingController) context.getBean("greetingController");
        controller.sayHello();
//        InjectedByConstructorService constructorService =
//                (InjectedByConstructorService) context.getBean("injectedByConstructorService");
//        constructorService.getMessage();
//
//        System.out.println("----------------------");
//        SetterBasedService setterBasedService =
//                (SetterBasedService) context.getBean("setterBasedService");
//        setterBasedService.getMessage();


    }
}
