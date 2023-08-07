package yte.intern.springcore.dependencyInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DependencyInjectionTest {

    private final FieldInjectionBean fieldInjectionBean;
    private final SetterInjectionBean setterInjectionBean;
    private final ConstructorInjectionBean constructorInjectionBean;

    @Autowired
    public DependencyInjectionTest(
            FieldInjectionBean fieldInjectionBean,
            SetterInjectionBean setterInjectionBean,
            ConstructorInjectionBean constructorInjectionBean) {
        this.fieldInjectionBean = fieldInjectionBean;
        this.setterInjectionBean = setterInjectionBean;
        this.constructorInjectionBean = constructorInjectionBean;
    }

    public void print() {
        fieldInjectionBean.print();
        setterInjectionBean.print();
        constructorInjectionBean.print();
    }

}
