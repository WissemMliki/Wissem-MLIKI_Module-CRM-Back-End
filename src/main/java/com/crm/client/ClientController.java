package com.crm.client;

import java.util.List;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crm.service.ServiceService;

@RestController
@CrossOrigin("*")
class ClientController {
	@Autowired
	ClientService clientService;

	@Autowired
	ServiceService serviceService;
	
	@GetMapping(value = "/api/clients")
	public List<Client> getAllClients() {
		return clientService.getAllClients();
	}

	@GetMapping(value = "/api/clients/{id}")
	public Optional<Client> getClient(@PathVariable int id) {
		return clientService.getClient(id);
	}

	@PostMapping(value = "/api/clients")
	public void addClient(@Valid @RequestBody Client client){
		
		clientService.addClient(client);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/api/clients/{id}")
	public void updateClient(@RequestBody Client client, @PathVariable int id) {
		String buffer = client.getName();
		clientService.updateClientBuffer(id, client);
		client.setNom(buffer);
		clientService.updateClient(id, client);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/api/clients/{id}")
	public void deleteClient(@PathVariable int id) {
		clientService.deleteClient(id);
	}
	
	@GetMapping(value = "/api/numberofclients")
	public int getnumberOfActiveClients() {
		return clientService.getnumberOfActiveClients();
	}
	@GetMapping(value = "/api/numberofclientswithservices")
	public int getnumberOfClientsWithServices() {
		return clientService.getnumberOfClientsWithServices();
	}
	
		
	@GetMapping(value = "/api/pourcentageClientsWithServices")
	public double getpourcentageClientsWithServices() {
		return  Math.round( (double) clientService.getnumberOfClientsWithServices()/
				clientService.getnumberOfActiveClients()*100);
	}
	
	@GetMapping(value = "/api/pourcentageClientsWithoutServices")
	public double getpourcentageClientsWithoutServices() {
		return  100-this.getpourcentageClientsWithServices();
	}
		
	
}

