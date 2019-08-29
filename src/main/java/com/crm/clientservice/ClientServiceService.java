package com.crm.clientservice;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceService {

	@Autowired
	ClientServiceDao clientServiceDao;

	public List<ClientService> getAll() {
		List<ClientService> clientservices = new ArrayList<>();
		clientServiceDao.findAll().forEach(clientservices::add);
		return clientservices;
	}

	public void addClientService(ClientService clientService) {
		clientServiceDao.save(clientService);
	}

	public List<ClientService> getAllServicesForClient(int clientId) {
		return clientServiceDao.findByClientId(clientId);
	}
				
	public void deleteByClientIdAndServiceId(int clientId, int serviceId) {
		clientServiceDao.deleteByClientIdAndServiceId(clientId, serviceId);
	}
	
	public int getnumberOfActiveClientServices() {
		
		return clientServiceDao.numberOfActiveClientServices();
	}

    public int getnombreDeRelanceEveNational() {
		
		return clientServiceDao.nombreDeRelanceEveNational();
	}

    public int getnombreDeRelanceEveReligieux() {
	
	return clientServiceDao.nombreDeRelanceEveReligieux();
    }

    public int getnombreDeRelanceAnniversaire() {
	
	return clientServiceDao.nombreDeRelanceAnniversaire();
    }	
	
}
