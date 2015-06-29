package com.metier;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="TypeTechnologie")
public class TypeTechnologie {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idTypeTechnologie")
	private int idTypeTechnologie;
	@Column(name="libelle")
	private String libelle;
	@OneToMany(mappedBy="laTypeTechnologie")
	private List<Technologie> listeTechnologie;
	public TypeTechnologie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TypeTechnologie(int idTypeTechnologie, String libelle) {
		super();
		this.idTypeTechnologie = idTypeTechnologie;
		this.libelle = libelle;
	}
	public int getIdTypeTechnologie() {
		return idTypeTechnologie;
	}
	public void setIdTypeTechnologie(int idTypeTechnologie) {
		this.idTypeTechnologie = idTypeTechnologie;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public List<Technologie> getListeTechnologie() {
		return listeTechnologie;
	}
	public void setListeTechnologie(List<Technologie> listeTechnologie) {
		this.listeTechnologie = listeTechnologie;
	}
	
}
