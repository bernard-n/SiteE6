package com.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Tache")
public class Tache {
	@Id
	@Column(name="idTache")
	private int idTache;
	@Column(name="libelleTache")
	private String libelleTache;
	@Column(name="numTache")
	private int numTache;
	
	public Tache() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tache(int idTache, String libelleTache) {
		super();
		this.idTache = idTache;
		this.libelleTache = libelleTache;
	}
	
	public int getNumTache() {
		return numTache;
	}
	public void setNumTache(int numTache) {
		this.numTache = numTache;
	}
	public int getIdTache() {
		return idTache;
	}
	public void setIdTache(int idTache) {
		this.idTache = idTache;
	}
	public String getLibelleTache() {
		return libelleTache;
	}
	public void setLibelleTache(String libelleTache) {
		this.libelleTache = libelleTache;
	}
	
}
