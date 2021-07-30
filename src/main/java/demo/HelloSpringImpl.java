package demo;

import org.springframework.stereotype.Component;

@Component
public class HelloSpringImpl implements HelloSpringService {
    public void sayHello() {
        System.out.println("Hello Spring!");
    }
}
