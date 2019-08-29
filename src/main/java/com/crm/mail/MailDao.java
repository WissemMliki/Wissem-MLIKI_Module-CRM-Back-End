package com.crm.mail;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.crm.client.Client;

@Repository
public interface MailDao extends JpaRepository<Client, Integer>{
	
	
}