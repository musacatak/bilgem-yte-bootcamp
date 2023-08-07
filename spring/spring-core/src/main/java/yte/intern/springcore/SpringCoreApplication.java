package yte.intern.springcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import yte.intern.springcore.beanimplement.InjectionTest;
import yte.intern.springcore.dependencyInjection.DependencyInjectionTest;
import yte.intern.springcore.lifecyclebean.LifeCycleBean;

@SpringBootApplication
public class SpringCoreApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SpringCoreApplication.class,args);

        DependencyInjectionTest dependencyInjectionTest = context.getBean(DependencyInjectionTest.class);
        dependencyInjectionTest.print();

        LifeCycleBean bean = context.getBean(LifeCycleBean.class);
        bean.printMethod();

        InjectionTest injectionTest = context.getBean(InjectionTest.class);
        injectionTest.print();

    }

}
