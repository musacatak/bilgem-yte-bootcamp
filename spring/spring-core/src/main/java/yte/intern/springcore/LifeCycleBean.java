package yte.intern.springcore;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class LifeCycleBean {
    public LifeCycleBean() {
        System.out.println("Constructor içinde");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("PostConstruct içinde");
    }

    public void printMethod() {
        System.out.println("Bir print methodunun içerisinde");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("PreDestroy içinde");
    }
}
