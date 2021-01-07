package com.justica.processo.validation;

import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.InvalidStateException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public abstract class CNPJContraintValidator implements ConstraintValidator<CNPJ, String> {
    @Override
    public boolean isValid(String cnpj, ConstraintValidatorContext constraintValidatorContext) {
        try {
            new CNPJValidator(false).assertValid(cnpj);
            return true;
        } catch(InvalidStateException e) {
            return false;
        }
    }
}
