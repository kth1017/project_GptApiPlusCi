package fadet.customAnnotation.validator;

import fadet.private_deploy1.domain.recommendQuestionSupplier.RecomQuestionSupplier;
import fadet.customAnnotation.Category;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class CategoryValidator implements ConstraintValidator<Category, String> {


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        RecomQuestionSupplier recomQuestionSupplier = new RecomQuestionSupplier();
        if(value == null){
           return false;
       }
       return Arrays.asList(recomQuestionSupplier.getLData()).contains(value);
    }
}
