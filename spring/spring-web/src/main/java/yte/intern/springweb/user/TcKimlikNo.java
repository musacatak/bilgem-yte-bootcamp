package yte.intern.springweb.user;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TcKimlikNoValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TcKimlikNo {
    String message() default "Geçerli bir TC kimlik numarası giriniz";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
