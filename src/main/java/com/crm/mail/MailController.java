package com.crm.mail;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.crm.client.Client;


@RestController
@CrossOrigin("*")
class MailController {
	@Autowired
	MailService mailService;

	
	@PostMapping(value = "/api/mail-success")
	public String mailSuccess(@Valid @RequestBody String contenu) {
		List<Client> clients1 = mailService.getAllClients();
		for(int i=0; i<clients1.size(); i++)
		{	
			mailService.sendMail(clients1.get(i), contenu);
		}
		return "les mails ont été envoyés avec succès";
	}
	
	@PostMapping(value = "/api/mail-success-listOfServices")
	public String mailSuccessListOfServices(@Valid @RequestBody String contenu) {
		List<Client> clients1 = mailService.getAllClients();
		for(int i=0; i<clients1.size(); i++)
		{	
			mailService.sendMailOfServices(clients1.get(i), contenu);
		}
		return "les mails ont été envoyés avec succès";
	}
	
}

