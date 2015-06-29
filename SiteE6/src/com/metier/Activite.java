package com.metier;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Activite")
public class Activite {
	@Id
	@Column(name="idActivite")
	private String idActivite;
	@Column(name="libelleActivite")
	private String libelleActivite;
	@OneToMany(mappedBy="laActivite")
	private List<Competence> listeCompetence;
	
	public Activite(String idActivite, String libelleActivite,
			List<Competence> listeCompetence) {
		super();
		this.idActivite = idActivite;
		this.libelleActivite = libelleActivite;
		this.listeCompetence = listeCompetence;
	}
	
	public List<Competence> getListeCompetence() {
		return listeCompetence;
	}

	public void setListeCompetence(List<Competence> listeCompetence) {
		this.listeCompetence = listeCompetence;
	}

	public String getIdActivite() {
		return idActivite;
	}
	public void setIdActivite(String idActivite) {
		this.idActivite = idActivite;
	}
	public String getLibelleActivite() {
		return libelleActivite;
	}
	public void setLibelleActivite(String libelleActivite) {
		this.libelleActivite = libelleActivite;
	}
	public Activite() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Activite [idActivite=" + idActivite + ", libelleActivite="
				+ libelleActivite + "]";
	}
	
}
