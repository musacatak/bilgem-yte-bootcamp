package yte.intern.springcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringCoreApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SpringCoreApplication.class,args);

        //ComponentTest componentTest = context.getBean(ComponentTest.class);
        //componentTest.print();

        //ApplicationContext context = new AnnotationConfigApplicationContext(DependencyInjectionTest.class);
        //DependencyInjectionTest diTest = context.getBean(DependencyInjectionTest.class);
        //diTest.print();

        DependencyInjectionTest dependencyInjectionTest = context.getBean(DependencyInjectionTest.class);
        dependencyInjectionTest.print();


    }

}
