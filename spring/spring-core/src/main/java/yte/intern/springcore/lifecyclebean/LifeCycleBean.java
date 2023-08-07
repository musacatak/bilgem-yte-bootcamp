package yte.intern.springcore.lifecyclebean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class LifeCycleBean {
    public LifeCycleBean() {
        System.out.println("Constructor içindeyim");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("PostConstruct içindeyim");
    }

    public void printMethod() {
        System.out.println("print içindeyim");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("PreDestroy içindeyim");
    }
}
