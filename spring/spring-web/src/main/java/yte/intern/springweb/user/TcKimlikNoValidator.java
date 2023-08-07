package yte.intern.springweb.user;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TcKimlikNoValidator implements ConstraintValidator<TcKimlikNo, String> {

    @Override
    public void initialize(TcKimlikNo constraintAnnotation) {
    }
    @Override
    public boolean isValid(String tcKimlikNo, ConstraintValidatorContext context) {
        if (tcKimlikNo == null) {
            return true; // Null değere izin ver
        }

        // TC kimlik no doğrulama mantığı burada gerçekleştirin
        if (tcKimlikNo.length() != 11 || tcKimlikNo.charAt(0) == '0') {
            return false;
        }

        int[] digits = new int[11];
        for (int i = 0; i < 11; i++) {
            digits[i] = Character.getNumericValue(tcKimlikNo.charAt(i));
        }

        int d10 = ((digits[0] + digits[2] + digits[4] + digits[6] + digits[8]) * 7 -
                (digits[1] + digits[3] + digits[5] + digits[7])) % 10;
        int d11 = (digits[0] + digits[1] + digits[2] + digits[3] + digits[4] +
                digits[5] + digits[6] + digits[7] + digits[8] + digits[9]) % 10;

        return digits[9] == d10 && digits[10] == d11;
    }
}
