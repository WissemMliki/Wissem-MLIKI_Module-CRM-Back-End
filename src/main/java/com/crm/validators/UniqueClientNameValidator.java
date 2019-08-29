package com.crm.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import com.crm.client.ClientDao;


public class UniqueClientNameValidator implements ConstraintValidator<UniqueClientName, String> {

	@Autowired
	ClientDao clientDao;

	@Override
	public void initialize(UniqueClientName constraintAnnotation) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid(String nom, ConstraintValidatorContext context) {
		if (clientDao == null) {
			return true;
		}
		return clientDao.findByName(nom) == null;
	}

}
