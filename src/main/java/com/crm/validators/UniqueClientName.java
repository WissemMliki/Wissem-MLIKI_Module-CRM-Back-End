package com.crm.validators;


import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;
import  java.lang.annotation.*;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { UniqueClientNameValidator.class })
public @interface UniqueClientName {
	
	String message();

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
