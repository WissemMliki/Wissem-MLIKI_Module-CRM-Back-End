package com.crm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceService {

	@Autowired
	private ServiceDao serviceDao;
	
	public List<com.crm.service.Service> getAllServices(){
		List<com.crm.service.Service> services = new ArrayList<>();
		serviceDao.findAll().forEach(services::add);
		return services;
	}
	
	
	public Optional<com.crm.service.Service> getService(int id) {
			return serviceDao.findById(id);
	}
	
	
	public void addService(com.crm.service.Service service) {
		serviceDao.save(service);
	}
	
	public void updateService(com.crm.service.Service service, int id) {
		serviceDao.save(service);
	}
	
	public void updateServiceBuffer(com.crm.service.Service service, int id) {
		service.setNumeroReference(0);
		serviceDao.save(service);
	}
	
	
	public void deleteService(int id) {
		serviceDao.deleteById(id);
	}
	
	public int getnumberOfActiveServices() {
		
		return serviceDao.numberOfActiveServices();
	}

		
}

