package com.crm.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ServiceDao extends JpaRepository<Service, Integer>{
	
	Service findByNumeroReference(Integer numeroReference);
	@Query("SELECT COUNT(s) FROM Service s ")
	int numberOfActiveServices();

}

