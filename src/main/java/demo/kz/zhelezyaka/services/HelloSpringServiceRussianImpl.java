package demo.kz.zhelezyaka.services;

public class HelloSpringServiceRussianImpl implements HelloSpringService{
    @Override
    public String getGreeting() {
        return "Привет Спринг!";
    }
}
