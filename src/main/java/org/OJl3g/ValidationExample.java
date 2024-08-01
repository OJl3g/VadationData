package org.OJl3g;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.OJl3g.entity.User;

import java.time.LocalDate;
import java.util.Set;

public class ValidationExample {
    public static void main(String[] args) {
        ValidatorFactory validationFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validationFactory.getValidator();

        User user = new User();
        user.setEmail("google.com");

        user.setBirthDate(LocalDate.of(1988, 12, 10));
        Set<ConstraintViolation<User>> validate = validator.validate(user);

        if (validate.isEmpty()) {
            System.out.println("Все поля прошли проверку валидации");
        } else {
            try {
                for (ConstraintViolation<User> violation : validate) {
                    System.out.println(violation.getMessage()
                            + " : " + violation.getPropertyPath()
                            + " : " + violation.getInvalidValue());
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


    }
}
