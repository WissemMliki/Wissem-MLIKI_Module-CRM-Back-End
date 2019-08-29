package com.crm.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDao extends JpaRepository<Client, Integer>{

	Client findByName(String name);
	
	@Query("SELECT COUNT(c) FROM Client c ")
	int numberOfActiveClients();
	
	@Query("SELECT COUNT(c) FROM Client c WHERE c.serviceOffert = true ")
	int numberOfClientsWithServices();
}
