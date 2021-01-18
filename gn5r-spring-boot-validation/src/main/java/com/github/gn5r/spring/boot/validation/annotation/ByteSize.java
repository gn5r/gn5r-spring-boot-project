package com.github.gn5r.spring.boot.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.github.gn5r.spring.boot.validation.ByteSizeValidation;

/**
 * <p>
 * バイト数バリデートアノテーション
 * </p>
 *
 * @author gn5r
 */
@Documented
@Constraint(validatedBy = { ByteSizeValidation.class })
@Target({ ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(ByteSize.List.class)
public @interface ByteSize {

	String message() default "{com.github.gn5r.spring.boot.validation.ByteSize.message}";

	String encoding() default "MS932";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	int min() default 0;

	int max() default Integer.MAX_VALUE;

	@Documented
	@Target({ ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER })
	@Retention(RetentionPolicy.RUNTIME)
	public @interface List {
		ByteSize[] value();
	}
}
