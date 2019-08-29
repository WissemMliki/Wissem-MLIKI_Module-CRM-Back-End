package com.crm.mail;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.crm.client.Client;
import com.crm.client.ClientDao;

@Service
public class MailService {
	
	private JavaMailSender javaMailSender;
	@Autowired
	private ClientDao clientDao;
	
	@Autowired
	public MailService(JavaMailSender javaMailSender)
	{
	this.javaMailSender	= javaMailSender;
	}
	
	
	public List<Client> getAllClients() {
		List<Client> clients = new ArrayList<>();
		clientDao.findAll().forEach(clients::add);
		return clients;
	}
	
	public void sendMail(Client client, String contenu) throws MailException
	{
	SimpleMailMessage mail = new SimpleMailMessage();
	mail.setTo(client.getEmail());
	mail.setFrom("SfmTechnologies@gmail.com");
	mail.setSubject("Ajout d'un nouveau service SFM");
	mail.setText("Bonjour,\n\nUn nouveau service SFM est ajouté.\n"+contenu+"\nVeuillez nous contacter pour plus d'informations."
			+ "\nTel: (+216) 71 845 248, Fax: (+216) 71 845 249, Mail: info@sfmtelecom.com\n\nCordialement,\nGroupe SFM");
	javaMailSender.send(mail);
	
	}
	
	public void sendMailOfServices(Client client, String contenu) throws MailException
	{
	SimpleMailMessage mail = new SimpleMailMessage();
	mail.setTo(client.getEmail());
	mail.setFrom("SfmTechnologies@gmail.com");
	mail.setSubject("Liste des services SFM");
	mail.setText("Bonjour,\n\nVoici la liste de tous les services SFM.\n"+contenu+"\nVeuillez nous contacter pour plus d'informations."
			+ "\nTel: (+216) 71 845 248, Fax: (+216) 71 845 249, Mail: info@sfmtelecom.com\n\nCordialement,\nGroupe SFM");
	javaMailSender.send(mail);
	
	}
}
