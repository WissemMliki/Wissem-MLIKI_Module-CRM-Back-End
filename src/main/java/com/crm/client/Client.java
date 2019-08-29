package com.crm.client;

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
import com.crm.clientservice.ClientService;
import com.crm.service.Service;
import com.crm.validators.UniqueClientName;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Client {

	@JsonBackReference
	@OneToMany(mappedBy="client", fetch = FetchType.LAZY)
	private List<ClientService> services;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private int id;
	@Column(name = "Name")
	@UniqueClientName(message = "Le client avec ce nom existe déjà")
	private String name;
	@Column(name = "Nationalité")
	private String nationalite;
	@Temporal(TemporalType.DATE)
	@Column(name = "date_de_naissance")
	Date dateDeNaissance;
	@Column(name = "ville")
	private String ville;
	@Column(name = "rue")
	private String rue;
	@Column(name = "code_postale")
	private String codePostale;
	@Column(name = "numéro_téléphone")
	private String numeroTelephone;
	@Column(name = "numéro_fax")
	private String numeroFax;
	@Column(name = "email")
	private String email;
	@Column(name = "facebook")
	private String facebook;
	@Column(name = "twitter")
	private String twitter;
	@Column(name = "skype")
	private String skype;
	@Column(name = "service_offert ")
	private boolean serviceOffert;

	public Client() {

	}

	public Client(List<ClientService> services, int id, String nom, String nationalite, Date dateDeNaissance,
			String ville, String rue, String codePostale, String numeroTelephone, String numeroFax, String email,
			String facebook, String twitter, String skype, boolean serviceOffert) {
		super();
		this.services = services;
		this.id = id;
		this.name = nom;
		this.nationalite = nationalite;
		this.dateDeNaissance = dateDeNaissance;
		this.ville = ville;
		this.rue = rue;
		this.codePostale = codePostale;
		this.numeroTelephone = numeroTelephone;
		this.numeroFax = numeroFax;
		this.email = email;
		this.facebook = facebook;
		this.twitter = twitter;
		this.skype = skype;
		this.serviceOffert = serviceOffert;
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

	public String getName() {
		return name;
	}

	public void setNom(String nom) {
		name = nom;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostale() {
		return codePostale;
	}

	public void setCodePostale(String codePostale) {
		this.codePostale = codePostale;
	}

	public String getNumeroTelephone() {
		return numeroTelephone;
	}

	public void setNumeroTelephone(String numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}

	public String getNumeroFax() {
		return numeroFax;
	}

	public void setNumeroFax(String numeroFax) {
		this.numeroFax = numeroFax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getSkype() {
		return skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	public boolean isServiceOffert() {
		return serviceOffert;
	}

	public void setServiceOffert(boolean serviceOffert) {
		this.serviceOffert = serviceOffert;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", Nom=" + name + ", nationalite=" + nationalite + ", dateDeNaissance="
				+ dateDeNaissance + ", ville=" + ville + ", rue=" + rue + ", codePostale=" + codePostale
				+ ", numeroTelephone=" + numeroTelephone + ", numeroFax=" + numeroFax + ", email=" + email
				+ ", facebook=" + facebook + ", twitter=" + twitter + ", skype=" + skype + ", serviceOffert="
				+ serviceOffert + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (codePostale == null) {
			if (other.codePostale != null)
				return false;
		} else if (!codePostale.equals(other.codePostale))
			return false;
		if (dateDeNaissance == null) {
			if (other.dateDeNaissance != null)
				return false;
		} else if (!dateDeNaissance.equals(other.dateDeNaissance))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (facebook == null) {
			if (other.facebook != null)
				return false;
		} else if (!facebook.equals(other.facebook))
			return false;
		if (id != other.id)
			return false;
		if (nationalite == null) {
			if (other.nationalite != null)
				return false;
		} else if (!nationalite.equals(other.nationalite))
			return false;
		if (numeroFax == null) {
			if (other.numeroFax != null)
				return false;
		} else if (!numeroFax.equals(other.numeroFax))
			return false;
		if (numeroTelephone == null) {
			if (other.numeroTelephone != null)
				return false;
		} else if (!numeroTelephone.equals(other.numeroTelephone))
			return false;
		if (rue == null) {
			if (other.rue != null)
				return false;
		} else if (!rue.equals(other.rue))
			return false;
		if (serviceOffert != other.serviceOffert)
			return false;
		if (services == null) {
			if (other.services != null)
				return false;
		} else if (!services.equals(other.services))
			return false;
		if (skype == null) {
			if (other.skype != null)
				return false;
		} else if (!skype.equals(other.skype))
			return false;
		if (twitter == null) {
			if (other.twitter != null)
				return false;
		} else if (!twitter.equals(other.twitter))
			return false;
		if (ville == null) {
			if (other.ville != null)
				return false;
		} else if (!ville.equals(other.ville))
			return false;
		return true;
	}

	public void addService(Service service, boolean relanceEveNational, boolean relanceEveReligieux, boolean relanceanniversaire,Date dateFin, Date dateDebut,
			String moyenContact, String remarque) {
		ClientService association = new ClientService();
		association.setService(service);
		association.setClient(this);
		association.setServiceId(service.getId());
		association.setClientId(this.getId());
		association.setDateDebut(dateDebut);
		association.setDateFin(dateFin);
		association.setMoyenContact(moyenContact);
		association.setRemarque(remarque);
		association.setRelanceEveNational(relanceEveNational);
		association.setRelanceEveReligieux(relanceEveReligieux);
		association.setRelanceanniversaire(relanceanniversaire);

		services.add(association);
	}
		
}

