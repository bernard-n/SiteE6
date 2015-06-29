package com.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="Technologie")
public class Technologie {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idTechnologie")
	private int idTechnologie;
	@Column(name="libelle")
	private String libelle;
	@Column(name="note")
	private int note;
	@ManyToOne
	@JoinColumn(name="idTypeTechnologie")
	private TypeTechnologie laTypeTechnologie;
	public Technologie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Technologie(int idTechnologie, String libelle, int note,
			com.metier.TypeTechnologie laTypeTechnologie) {
		super();
		this.idTechnologie = idTechnologie;
		this.libelle = libelle;
		this.note = note;
		laTypeTechnologie = laTypeTechnologie;
	}
	public int getIdTechnologie() {
		return idTechnologie;
	}
	public void setIdTechnologie(int idTechnologie) {
		this.idTechnologie = idTechnologie;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public TypeTechnologie getTypeTechnologie() {
		return laTypeTechnologie;
	}
	public void setTypeTechnologie(TypeTechnologie laTypeTechnologie) {
		this.laTypeTechnologie = laTypeTechnologie;
	}
	
}
