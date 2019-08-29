package com.crm.clientservice;

import java.util.List;
import javax.transaction.Transactional;
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
import com.crm.service.ServiceDao;

@RestController
@CrossOrigin("*")
public class ClientServiceController {

	@Autowired
	ClientServiceService clientServiceService;

	@Autowired
	ServiceDao serviceDao;

	@GetMapping(value = "/api/clientservices")
	public List<ClientService> getAll() {
		return clientServiceService.getAll();
	}

	@GetMapping(value = "/api/clientservices/{clientId}")
	public List<ClientService> getServices(@PathVariable int clientId) {
		return clientServiceService.getAllServicesForClient(clientId);
	}

	@PostMapping(value = "/api/clients/{clientId}/services/{serviceId}")
	public void addClientService(@Valid @RequestBody ClientService clientService, @PathVariable int serviceId,
			@PathVariable int clientId) {
		clientService.setServiceId(serviceId);
		clientService.setClientId(clientId);
		clientServiceService.addClientService(clientService);
	}

	@Transactional
	@RequestMapping(method = RequestMethod.DELETE, value = "/api/clients/{clientId}/services/{serviceId}")
	public void deleteClientService(@PathVariable int clientId, @PathVariable int serviceId) {
		clientServiceService.deleteByClientIdAndServiceId(clientId, serviceId);
	}
	
	
	@GetMapping(value = "/api/numberofclientservices")
	public int getnumberOfActiveClientServices() {
		return clientServiceService.getnumberOfActiveClientServices();
	}

	@GetMapping(value = "/api/nombredeRelanceEveNational")
	public int getnombreDeRelanceEveNational() {
		return clientServiceService.getnombreDeRelanceEveNational();
	}
	@GetMapping(value = "/api/nombreDeRelanceEveReligieux")
	public int getnombreDeRelanceEveReligieux() {
		return clientServiceService.getnombreDeRelanceEveReligieux();
	}
	@GetMapping(value = "/api/nombreDeRelanceAnniversaire")
	public int getnombreDeRelanceAnniversaire() {
		return clientServiceService.getnombreDeRelanceAnniversaire();
	}
	
	@GetMapping(value = "/api/nombreDeRelances")
	public int getnombreDeRelances() {
		return clientServiceService.getnombreDeRelanceEveNational()+
				clientServiceService.getnombreDeRelanceEveReligieux()+
				clientServiceService.getnombreDeRelanceAnniversaire();
	}
	
	@GetMapping(value = "/api/pourcentageRelancesEveNational")
	public double getpourcentageDeRelancesEveNational() {
		return  Math.round( (double) clientServiceService.getnombreDeRelanceEveNational()/(clientServiceService.getnombreDeRelanceEveNational()+
				clientServiceService.getnombreDeRelanceEveReligieux()+
				clientServiceService.getnombreDeRelanceAnniversaire())*100);
	}
	
	@GetMapping(value = "/api/pourcentageRelancesEveReligieux")
	public double getpourcentageDeRelancesEveReligieux() {
		return  Math.round( (double) clientServiceService.getnombreDeRelanceEveReligieux()/(clientServiceService.getnombreDeRelanceEveNational()+
				clientServiceService.getnombreDeRelanceEveReligieux()+
				clientServiceService.getnombreDeRelanceAnniversaire())*100);
	}
		
	@GetMapping(value = "/api/pourcentageRelancesAnniversaire")
	public double getpourcentageDeRelancesAnniversaire() {
		return  Math.round( (double) clientServiceService.getnombreDeRelanceAnniversaire()/(clientServiceService.getnombreDeRelanceEveNational()+
				clientServiceService.getnombreDeRelanceEveReligieux()+
				clientServiceService.getnombreDeRelanceAnniversaire())*100);
	}
	
}
