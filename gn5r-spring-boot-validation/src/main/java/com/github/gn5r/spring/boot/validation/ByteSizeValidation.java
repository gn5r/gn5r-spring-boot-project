package com.github.gn5r.spring.boot.validation;

import java.io.UnsupportedEncodingException;
import java.util.Objects;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.github.gn5r.spring.boot.validation.annotation.ByteSize;

/**
 * <p>バイト数バリデートクラス</p>
 * <p>デフォルトでは {@code MS932} でバイト数を取得し指定した範囲内かどうかチェックする。任意のエンコーディングを指定可能</p>
 *
 * @author gn5r
 * @see ByteSize
 */
public class ByteSizeValidation implements ConstraintValidator<ByteSize, CharSequence> {

	private String message;
	private String encoding;
	private int min;
	private int max;

	@Override
	public void initialize(ByteSize annotation) {
		this.message = annotation.message();
		this.encoding = annotation.encoding();
		this.min = annotation.min();
		this.max = annotation.max();
	}

	@Override
	public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
		if (Objects.isNull(value))
			return true;

		try {
			final int size = String.valueOf(value).getBytes(this.encoding).length;

			if (size >= this.min && size <= this.max) {
				return true;
			}
		} catch (UnsupportedEncodingException e) {
			return false;
		}

		context.disableDefaultConstraintViolation();
		context.buildConstraintViolationWithTemplate(this.message).addConstraintViolation();

		return false;
	}
}
