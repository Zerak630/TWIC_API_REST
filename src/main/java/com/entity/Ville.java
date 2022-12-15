package com.entity;

import com.model.VilleModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "ville_france")
public class Ville {

	@Id
	@Column(name = "Code_commune_INSEE")
	private String codeCommune;

	@Column(name = "Nom_commune")
	private String nomCommune;

	@Column(name = "Code_postal")
	private String codePostal;

	@Column(name = "Libelle_acheminement")
	private String libelleAcheminement;

	@Column(name = "Ligne_5")
	private String ligne;

	@Column(name = "Latitude")
	private String latitude;

	@Column(name = "Longitude")
	private String longitude;


	public Ville(VilleModel model) {
		this.codeCommune = model.getCodeCommune();
		this.nomCommune = model.getNomCommune();
		this.codePostal = model.getCodePostal();
		this.libelleAcheminement = model.getLibelleAcheminement();
		this.ligne = model.getLigne();
		this.latitude = model.getLatitude();
		this.longitude = model.getLongitude();
	}
}
