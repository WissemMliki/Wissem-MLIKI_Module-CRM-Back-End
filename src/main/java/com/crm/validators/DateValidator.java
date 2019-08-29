package com.crm.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.crm.clientservice.ClientService;

public class DateValidator implements ConstraintValidator<ValidDates, ClientService>{

	@Override
	public void initialize(ValidDates constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(ClientService clientService, ConstraintValidatorContext context) {
		
		if(clientService.getDateDebut().before(clientService.getDateFin())) {
			return true;
		} 
		else return false;
		
	}

}
