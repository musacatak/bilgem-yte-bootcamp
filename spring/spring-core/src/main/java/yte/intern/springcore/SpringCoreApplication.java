package yte.intern.springcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringCoreApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SpringCoreApplication.class,args);

        DependencyInjectionTest dependencyInjectionTest = context.getBean(DependencyInjectionTest.class);
        dependencyInjectionTest.print();

        LifeCycleBean bean = context.getBean(LifeCycleBean.class);
        bean.printMethod();

    }

}
