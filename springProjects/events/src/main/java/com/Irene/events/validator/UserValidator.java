package com.Irene.events.validator;

import javax.validation.Validator;
import org.springframework.validation.Errors;
import org.springframework.stereotype.Component;

import com.Irene.events.model.User;

@Component
public class UserValidator implements Validator {
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		if(!user.getConfirmPassword().equals(user.getPassword())) {
			errors.rejectValue("confirmPassword", "Match");
		}
	}
	
}
