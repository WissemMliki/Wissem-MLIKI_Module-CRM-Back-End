package com.crm.clientservice;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientServiceDao extends JpaRepository<ClientService, Integer> {
	
List<ClientService> findByClientId(int clientId);
ClientService findByClientIdAndServiceId(int clientId, int serviceId);
public void deleteByClientIdAndServiceId(int clientId, int serviceId);

@Query("SELECT COUNT(cs) FROM ClientService cs ")
int numberOfActiveClientServices();

@Query("SELECT COUNT(cs) FROM ClientService cs WHERE cs.relanceEveNational = true ")
int nombreDeRelanceEveNational();

@Query("SELECT COUNT(cs) FROM ClientService cs WHERE cs.relanceEveReligieux = true ")
int nombreDeRelanceEveReligieux();

@Query("SELECT COUNT(cs) FROM ClientService cs WHERE cs.relanceanniversaire = true ")
int nombreDeRelanceAnniversaire();


}