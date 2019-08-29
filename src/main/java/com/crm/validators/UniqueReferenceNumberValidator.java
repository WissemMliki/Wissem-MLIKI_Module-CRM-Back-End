package com.crm.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import com.crm.service.ServiceDao;

public class UniqueReferenceNumberValidator implements ConstraintValidator<UniqueReferenceNumber, Integer> {

	@Autowired
	private ServiceDao serviceDao;

	@Override
	public void initialize(UniqueReferenceNumber constraintAnnotation) {

	}

	@Override
	public boolean isValid(Integer referenceNumber, ConstraintValidatorContext context) {
		if (serviceDao == null) {
			return true;
		}
		return serviceDao.findByNumeroReference(referenceNumber) == null;
	}

}
