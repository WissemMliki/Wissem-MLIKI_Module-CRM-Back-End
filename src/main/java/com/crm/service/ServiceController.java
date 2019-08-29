package com.crm.service;

import com.crm.service.Service;
import java.util.List;
import java.util.Optional;
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

@RestController
@CrossOrigin("*")
public class ServiceController {
	@Autowired
	ServiceService serviceService;
	
	
	
	@GetMapping(value="/api/services")
	public  List<Service> getAllServices(){
		return serviceService.getAllServices();
	}
	
	@GetMapping(value="/api/services/{id}")
	public Optional<Service> getService(@PathVariable int id) {
		return serviceService.getService(id);
	}
	
	@Transactional
	@PostMapping(value="/api/services")
	public void addService(@Valid @RequestBody Service service) {
		serviceService.addService(service);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/api/services/{id}")
	public void updateService(@RequestBody Service service, @PathVariable int id){
		int buffer = service.getNumeroReference();
		serviceService.updateServiceBuffer(service, id);
		service.setNumeroReference(buffer);
		serviceService.updateService(service, id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/api/services/{id}")
	public void deleteService(@PathVariable int id) {
		serviceService.deleteService(id);
	}
		
	@GetMapping(value = "/api/numberofservices")
	public int getnumberOfActiveServices() {
		return serviceService.getnumberOfActiveServices();
	}
		
}