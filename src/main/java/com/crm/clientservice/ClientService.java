package com.crm.clientservice;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.crm.service.Service;
import com.crm.client.Client;
import com.crm.validators.ValidDates;

@Entity
@ValidDates(message = "La date de début doit être antérieure à la date de fin")
@Table(name = "client_service")
@IdClass(Cliser.class)
public class ClientService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private int clientId;

	@Id
	private int serviceId;

	// fields of hospitalDoctor table

	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	private String moyenContact;
	private String remarque;
	private boolean relanceEveNational;
	private boolean relanceEveReligieux;
	private boolean relanceanniversaire;

	@ManyToOne
	@JoinColumn(name="ClientId", insertable = false, updatable = false)
	private Client client;

	@ManyToOne
	@JoinColumn(name="ServiceId", insertable = false, updatable = false)
	private Service service;

	// GETTERS AND SETTERS....

	public ClientService() {

	}

	public ClientService(int clientId, int serviceId, Date dateDebut, Date dateFin, String moyenContact,
			String remarque, boolean relanceEveNational, boolean relanceEveReligieux, boolean relanceanniversaire,
			Client client, Service service) {
		super();
		this.clientId = clientId;
		this.serviceId = serviceId;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.moyenContact = moyenContact;
		this.remarque = remarque;
		this.relanceEveNational = relanceEveNational;
		this.relanceEveReligieux = relanceEveReligieux;
		this.relanceanniversaire = relanceanniversaire;
		this.client = client;
		this.service = service;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getMoyenContact() {
		return moyenContact;
	}

	public void setMoyenContact(String moyenContact) {
		this.moyenContact = moyenContact;
	}

	public String getRemarque() {
		return remarque;
	}

	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}

	public boolean isRelanceEveNational() {
		return relanceEveNational;
	}

	public void setRelanceEveNational(boolean relanceEveNational) {
		this.relanceEveNational = relanceEveNational;
	}

	public boolean isRelanceEveReligieux() {
		return relanceEveReligieux;
	}

	public void setRelanceEveReligieux(boolean relanceEveReligieux) {
		this.relanceEveReligieux = relanceEveReligieux;
	}

	public boolean isRelanceanniversaire() {
		return relanceanniversaire;
	}

	public void setRelanceanniversaire(boolean relanceanniversaire) {
		this.relanceanniversaire = relanceanniversaire;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	@Override
	public String toString() {
		return "ClientService [clientId=" + clientId + ", serviceId=" + serviceId + ", dateDebut=" + dateDebut
				+ ", dateFin=" + dateFin + ", moyenContact=" + moyenContact + ", remarque=" + remarque
				+ ", relanceEveNational=" + relanceEveNational + ", relanceEveReligieux=" + relanceEveReligieux
				+ ", relanceanniversaire=" + relanceanniversaire + ", client=" + client + ", service=" + service + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientService other = (ClientService) obj;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (clientId != other.clientId)
			return false;
		if (dateDebut == null) {
			if (other.dateDebut != null)
				return false;
		} else if (!dateDebut.equals(other.dateDebut))
			return false;
		if (dateFin == null) {
			if (other.dateFin != null)
				return false;
		} else if (!dateFin.equals(other.dateFin))
			return false;
		if (moyenContact == null) {
			if (other.moyenContact != null)
				return false;
		} else if (!moyenContact.equals(other.moyenContact))
			return false;
		if (relanceEveNational != other.relanceEveNational)
			return false;
		if (relanceEveReligieux != other.relanceEveReligieux)
			return false;
		if (relanceanniversaire != other.relanceanniversaire)
			return false;
		if (remarque == null) {
			if (other.remarque != null)
				return false;
		} else if (!remarque.equals(other.remarque))
			return false;
		if (service == null) {
			if (other.service != null)
				return false;
		} else if (!service.equals(other.service))
			return false;
		if (serviceId != other.serviceId)
			return false;
		return true;
	}
	

}
