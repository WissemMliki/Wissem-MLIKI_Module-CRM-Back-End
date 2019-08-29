package com.crm.client;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

	@Autowired
	private ClientDao clientDao;

	public List<Client> getAllClients() {
		List<Client> clients = new ArrayList<>();
		clientDao.findAll().forEach(clients::add);
		return clients;
	}

	public Optional<Client> getClient(int id) {
		return clientDao.findById(id);
	}

	public void addClient(Client client) {
		clientDao.save(client);
	}

	public void updateClient(int id, Client client) {
		clientDao.save(client);
	}
	
	public void updateClientBuffer(int id, Client client) {
		String buffer = "XXXXXXX";
		client.setNom(buffer);
		clientDao.save(client);
	}

	public void deleteClient(int id) {
		clientDao.deleteById(id);
	}
		
	public int getnumberOfActiveClients() {
		
		return clientDao.numberOfActiveClients();
	}

   public int getnumberOfClientsWithServices() {
		
		return clientDao.numberOfClientsWithServices();
	}
		
	}

