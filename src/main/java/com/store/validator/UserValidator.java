package com.store.validator;

import com.store.entity.Users;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Users.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Users users = (Users) o;
        if(users.getUsername() == null || users.getUsername().isEmpty()){
            errors.rejectValue("username","msg.required");
        }
    }
}
