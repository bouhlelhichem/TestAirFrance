package com.airfrance.testtechnique.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

@Component
public class FranceValidator implements ConstraintValidator<France, String> {
    private static final String LIVEIN_FRANCE = "france";

    @Override
    public boolean isValid(String address, ConstraintValidatorContext constraintValidatorContext) {
        return address.toLowerCase().contains(LIVEIN_FRANCE);
    }
}
