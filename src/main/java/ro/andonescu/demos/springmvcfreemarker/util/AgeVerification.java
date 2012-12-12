package ro.andonescu.demos.springmvcfreemarker.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=AgeVerificationValidator.class)
public @interface AgeVerification {
	
	String message() default "{AgeVerification.message}";

	Class<?>[] groups() default { };
	
	Class<? extends Payload>[] payload() default { };
	
	int minAge() default 18;
	
}
