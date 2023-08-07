package yte.intern.springweb.user;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class ValidUsernameValidator implements ConstraintValidator<ValidUsername, String> {

    @Override
    public boolean isValid(String kullaniciAdi, ConstraintValidatorContext context) {
        if (kullaniciAdi == null) {
            return true;
        }

        return !kullaniciAdi.equals("admin") && Pattern.matches("^[a-zA-Z0-9._-]{3,}$", kullaniciAdi);
    }
}
