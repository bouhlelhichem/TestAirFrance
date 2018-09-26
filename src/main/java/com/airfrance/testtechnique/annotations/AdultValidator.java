package com.airfrance.testtechnique.annotations;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

@Component
public class AdultValidator implements ConstraintValidator<Adult, Date> {
	private static final int ADULT_AGE = 18;

	@Override
	public boolean isValid(Date dateOfBirth, ConstraintValidatorContext constraintValidatorContext) {
		return dateOfBirth != null && LocalDate.now().minusYears(ADULT_AGE)
				.isAfter(dateOfBirth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
	}
}
