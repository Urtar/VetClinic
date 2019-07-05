package pl.coderslab;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = LoginValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginValid {
    String message() default "{podany login już istnieje w bazie}";//"{startWith.error.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {}; }
