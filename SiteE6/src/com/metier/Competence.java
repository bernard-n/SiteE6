package com.metier;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Competence")
public class Competence {
	@Id
	@Column(name="idCompetence")
	private String idCompetence;
	@Column(name="libelleCompetence")
	private String libelleCompetence;
	@ManyToOne
	@JoinColumn(name="idActivite")
	private Activite laActivite;
	@ManyToMany(mappedBy="listeCompetence")
	private List<ListeActivite> listeListeActivite;
	
	public Competence() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Competence(String idCompetence, String libelleCompetence,
			Activite laActivite, List<ListeActivite> listeListeActivite) {
		super();
		this.idCompetence = idCompetence;
		this.libelleCompetence = libelleCompetence;
		this.laActivite = laActivite;
		this.listeListeActivite = listeListeActivite;
	}

	public List<ListeActivite> getListeListeActivite() {
		return listeListeActivite;
	}

	public void setListeListeActivite(List<ListeActivite> listeListeActivite) {
		this.listeListeActivite = listeListeActivite;
	}

	public String getIdCompetence() {
		return idCompetence;
	}
	public void setIdCompetence(String idCompetence) {
		this.idCompetence = idCompetence;
	}
	public String getLibelleCompetence() {
		return libelleCompetence;
	}
	public void setLibelleCompetence(String libelleCompetence) {
		this.libelleCompetence = libelleCompetence;
	}
	public Activite getLaActivite() {
		return laActivite;
	}
	public void setLaActivite(Activite laActivite) {
		this.laActivite = laActivite;
	}
	
}
