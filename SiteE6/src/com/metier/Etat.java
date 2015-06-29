package com.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Etat")
public class Etat {
	@Id
	@Column(name="idEtat")
	private int idEtat;
	@Column(name="libelleEtat")
	private String libelleEtat;
	
	public Etat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Etat(int idEtat, String libelleEtat) {
		super();
		this.idEtat = idEtat;
		this.libelleEtat = libelleEtat;
	}
	public int getIdEtat() {
		return idEtat;
	}
	public void setIdEtat(int idEtat) {
		this.idEtat = idEtat;
	}
	public String getLibelleEtat() {
		return libelleEtat;
	}
	public void setLibelleEtat(String libelleEtat) {
		this.libelleEtat = libelleEtat;
	}
	
}
