package com.metier;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Columns;
@Entity
@Table(name="ListeTache")
@IdClass(ListeTachePK.class)
@Embeddable
public class ListeTache {
	@Id
	@Columns(columns = {@Column(name = "idTache",insertable=false, updatable=false),
	@Column(name = "idListeActivite",insertable=false, updatable=false)
	})
	private int idTache;
	private int idListeActivite;
	@ManyToOne
	@JoinColumn(name="idTache")
	private Tache latache;
	@ManyToOne
	@JoinColumn(name="idEtat")
	private Etat etat;
	@ManyToOne
	@JoinColumn(name="idListeActivite")
	private ListeActivite listeActivite;
	public ListeTache() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ListeTache(int idTache, int idListeActivite,Etat etat) {
		super();
		this.idTache = idTache;
		this.idListeActivite = idListeActivite;
		this.etat = etat;
	}




	public int getIdTache() {
		return idTache;
	}




	public void setIdTache(int idTache) {
		this.idTache = idTache;
	}




	public int getIdListeActivite() {
		return idListeActivite;
	}




	public void setIdListeActivite(int idListeActivite) {
		this.idListeActivite = idListeActivite;
	}




	public Tache getLatache() {
		return latache;
	}




	public void setLatache(Tache latache) {
		this.latache = latache;
	}




	public Tache getListeTache() {
		return latache;
	}
	public void setListeTache(Tache listeTache) {
		this.latache = listeTache;
	}
	public Etat getEtat() {
		return etat;
	}
	public void setEtat(Etat etat) {
		this.etat = etat;
	}
	public ListeActivite getListeActivite() {
		return listeActivite;
	}
	public void setListeActivite(ListeActivite listeActivite) {
		this.listeActivite = listeActivite;
	}
	
}
