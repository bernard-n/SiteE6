package com.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Categorie")
public class Categorie {
	@Id
	@Column(name="idCategorie")
	private int idCategorie;
	@Column(name="libelle")
	private String libelle;
	
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Categorie(int idCategorie, String libelle) {
		super();
		this.idCategorie = idCategorie;
		this.libelle = libelle;
	}
	public int getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
}
