package com.crm.service;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import com.crm.clientservice.ClientService;
import com.crm.validators.UniqueReferenceNumber;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Service {

	@JsonBackReference
	@OneToMany(mappedBy = "service", fetch = FetchType.LAZY)
	private List<ClientService> services;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	int id;

	@Column(name = "nom")
	@Size(min=3, message = "Le nom doit comporter au moins 3 caractères")
	String nom;

	@Column(name = "Description")
	@Size(min=10, message = "La description doit comporter au moins 10 caractères")
	String description;
	
	@Column(name = "type")
	@Size(min=3, message = "Le type doit comporter au moins 3 caractères")
	String type;

	@Column(name = "Numéro_de_réference")
	@UniqueReferenceNumber(message="Ce numéro de réference existe déjà")
	int numeroReference;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_de_création")
	Date dateCreation;

	@Column(name = "is_primary")
	boolean isPrimary;

	public Service() {

	}

	public Service(List<ClientService> services, int id,
			@Size(min = 3, message = "Le nom doit comporter au moins 3 caractères") String nom,
			@Size(min = 20, message = "La description doit comporter au moins 20 caractères") String description,
			@Size(min = 3, message = "Le type doit comporter au moins 3 caractères") String type, int numeroReference,
			Date dateCreation, boolean isPrimary) {
		super();
		this.services = services;
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.type = type;
		this.numeroReference = numeroReference;
		this.dateCreation = dateCreation;
		this.isPrimary = isPrimary;
	}

	public List<ClientService> getServices() {
		return services;
	}

	public void setServices(List<ClientService> services) {
		this.services = services;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNumeroReference() {
		return numeroReference;
	}

	public void setNumeroReference(int numeroReference) {
		this.numeroReference = numeroReference;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public boolean isPrimary() {
		return isPrimary;
	}

	public void setPrimary(boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

	@Override
	public String toString() {
		return "Service [id=" + id + ", nom=" + nom + ", description=" + description + ", type=" + type
				+ ", numeroReference=" + numeroReference + ", dateCreation=" + dateCreation + ", isPrimary=" + isPrimary
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Service other = (Service) obj;
		if (dateCreation == null) {
			if (other.dateCreation != null)
				return false;
		} else if (!dateCreation.equals(other.dateCreation))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (isPrimary != other.isPrimary)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (numeroReference != other.numeroReference)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
}

