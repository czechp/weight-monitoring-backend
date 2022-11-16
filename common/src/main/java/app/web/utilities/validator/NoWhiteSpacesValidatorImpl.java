package app.web.utilities.validator;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

class NoWhiteSpacesValidatorImpl implements ConstraintValidator<NoWhiteSpacesValidator, String> {
    @Override
    public boolean isValid(String field, ConstraintValidatorContext constraintValidatorContext) {
        return !(field.contains(" ") || field.contains("  "));
    }
}
