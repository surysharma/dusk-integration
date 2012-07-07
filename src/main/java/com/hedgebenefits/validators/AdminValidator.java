package com.hedgebenefits.validators;

import com.hedgebenefits.domain.Admin;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by IntelliJ IDEA.
 * User: sureshsharma
 * Date: 05/07/2012
 * Time: 18:08
 * To change this template use File | Settings | File Templates.
 */
@Component
public class AdminValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Admin.class.equals(clazz);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void validate(Object target, Errors errors) {
        Admin admin = (Admin) target;
        ValidationUtils.rejectIfEmpty(errors, "username", null, "Pl. enter username");
        ValidationUtils.rejectIfEmpty(errors, "password", null, "Pl. enter password");
    }
}
