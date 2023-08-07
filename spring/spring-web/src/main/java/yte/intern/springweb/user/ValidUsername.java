package yte.intern.springweb.user;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidUsernameValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidUsername {
    String message() default "Geçerli bir kullanıcı adı giriniz";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
