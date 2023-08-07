package yte.intern.springcore.beanimplement;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {
    @Bean
    public BeanTest beanTest() {
        return new BeanTest();
    }
}
